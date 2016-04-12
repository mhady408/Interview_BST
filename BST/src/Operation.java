
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * the common operationes of BST
 * 
 */
public class Operation {
	
	/*
	 * create a new tree by TreeNode.
	 *         10
	 *      8      9
	 *    6   7      5
	 */
	public TreeNode creatTree(){
		TreeNode root = new TreeNode(10);
		TreeNode node8 = new TreeNode(8);
		TreeNode node9 = new TreeNode(9);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		TreeNode node5 = new TreeNode(5);
		TreeNode node4 = new TreeNode(4);
		root.left = node8;
		root.right = node9;
		node8.left = node6;
		node8.right = node7;
		//node9.left = node4;
		node9.right = node5;
		node6.left = node4;
		return root;
	}
	
	/**
	 * compute the number of TreeNode.
	 */
	public int getNodeNum(TreeNode root){
		if(root == null)
			return 0;
		else
			return getNodeNum(root.left)+getNodeNum(root.right)+1;
	}
	
	/**
	 * compute the depth of the tree.
	 */
	public int getDepth(TreeNode root){
		if(root == null)
			return 0;
		int leftDepth = getDepth(root.left);
		int rightDepth = getDepth(root.right);
		return leftDepth>rightDepth?leftDepth+1:rightDepth+1;
	}
	
	/**
	 * preorder tree walk with recursion.
	 * 递归先序遍历
	 */
	public void preorderTreeWalk_recursion(TreeNode root, Stack<Integer> stack){
		if(root != null){
			stack.push(root.value);
			preorderTreeWalk_recursion(root.left,stack);
			preorderTreeWalk_recursion(root.right,stack);
		}
	}
	
	/**
	 * preorder tree walk without recursion
	 * 非递归先序遍历
	 */
	public void preorderTreeWalk(TreeNode root,Stack<Integer> result){
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while(root != null || !stack.isEmpty()){
			while(root != null){
				result.push(root.value);
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			root = root.right;
		}
	}
	
	/**
	 * inorder tree walk with recursion.
	 * 递归中序遍历
	 */
	public void inorderTreeWalk_recursion(TreeNode root,Stack<Integer> stack){
		if(root != null){
			inorderTreeWalk(root.left,stack);
			stack.push(root.value);
			inorderTreeWalk(root.right,stack);
		}
	}
	
	/**
	 * inorder tree walk without recursion
	 * 非递归中序遍历
	 */
	public void inorderTreeWalk(TreeNode root,Stack<Integer> result){
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while(root != null || !stack.isEmpty()){
			while(root != null){
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			result.push(root.value);
			root = root.right;
		}
	}
	
	/**
	 * postorder tree walk with recursion.
	 * 递归后序遍历
	 */
	public void postorderTreeWalk_recursion(TreeNode root,Stack<Integer> stack){
		if(root != null){
			postorderTreeWalk(root.left,stack);
			postorderTreeWalk(root.right,stack);
			stack.push(root.value);
		}
	}
	
	/**
	 * Postorder tree walk without recursion
	 * 非递归后序遍历
	 */
	public void postorderTreeWalk(TreeNode root,Stack<Integer> result){
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode preNode = null;
		while(root != null || !stack.isEmpty()){
			while(root != null){
				stack.push(root);
				root = root.left;
			}
			root = stack.peek();
			if(root.right == null || root.right == preNode){
				result.push(root.value);
				root = stack.pop();
				preNode = root;
				root = null;
			}else{
				root = root.right;
			}
		}
		
	}
	
	/**
	 * tree walk by each level.
	 */
	public Stack<Integer> levelWalk(TreeNode root){
		TreeNode node = null;
		Stack<Integer> result = new Stack<Integer>();
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		while(!q.isEmpty()){
			node = q.poll();
			result.push(node.value);
			if(node.left != null)
				q.offer(node.left);
			if(node.right != null)
				q.offer(node.right);
		}
		return result;
	}
	
	/**
	 * convert the BST to LinkedList
	 */
	public TreeNode convert(TreeNode root){
		TreeNode LastNode = null;
		convertNode(root,LastNode);
		TreeNode HeadOfList = LastNode;
		while(HeadOfList != null && HeadOfList.left != null)
			HeadOfList = HeadOfList.left;
		return HeadOfList;
	}
	/**
	 * the assist function of convert.
	 */
	public void convertNode(TreeNode root,TreeNode LastNode){
		if(root == null)
			return;
		TreeNode CurrentNode = root;
		if(root.left != null){
			convertNode(root.left,LastNode);
		}
		CurrentNode.left = LastNode;
		if(LastNode != null){
			LastNode.right = CurrentNode;
		}
		LastNode = CurrentNode;
		if(CurrentNode.right != null){
			convertNode(CurrentNode.right,LastNode);
		}
	}
	
	/**
	 * get the number of TreeNode in Kth level
	 */
	public int getNodeNumKthLevel(TreeNode root,int k){
		if(root == null || k<1)
			return 0;
		if(k == 1)
			return 1;
		int LeftNum = getNodeNumKthLevel(root.left,k-1);
		int RightNum = getNodeNumKthLevel(root.right,k-1);
		return (LeftNum+RightNum);
	}
	
	/**
	 * get the number of leaves.
	 */
	public int getLeavesNum(TreeNode root){
		if(root == null)
			return 0;
		if(root.left == null && root.right == null)
			return 1;
		int LeftLeaves = getLeavesNum(root.left);
		int RightLeaves = getLeavesNum(root.right);
		return (LeftLeaves+RightLeaves);
	}
	
	/**
	 * get the mirror of this tree
	 */
	public TreeNode getMirror(TreeNode root){
		if(root == null)
			return null;
		TreeNode LEFT = getMirror(root.left);
		TreeNode RIGHT = getMirror(root.right);
		root.right = LEFT;
		root.left = RIGHT;
		return root;
	}
	
	/**
	 * get the mirror of this tree without recursion
	 * 非递归翻转二叉树
	 */
	public void getMirror_noRecursion(TreeNode root){
			if(root == null)
				return;
			Queue<TreeNode> q = new LinkedList<TreeNode>();
			int q_size = 0;
			q.offer(root);
			while(!q.isEmpty()){
				q_size = q.size();
				int i=0;
				while(i<q_size){
					i++;
					root = q.poll();
					TreeNode tmp = root.left;
					root.left = root.right;
					root.right = tmp;
					if(root.left != null){
						q.offer(root.left);
					}
					if(root.right != null){
						q.offer(root.right);
					}
				}
			}
	}
	
	/**
	 * judge whether two trees have the same structure
	 */
	public boolean cmpStructure(TreeNode root1,TreeNode root2){
		if(root1 == null && root2 == null)
			return true;
		else if(root1 == null || root2 == null)
			return false;
		boolean left = cmpStructure(root1.left,root2.left);
		boolean rigth = cmpStructure(root1.right,root2.right);
		return (left && rigth);
	}
	
	/**
	 * judge whether the tree is AVL(the tree is balanced)
	 * 平衡二叉树：左右子树的高度差不大于1
	 */
	public boolean isBalanced(TreeNode root){
		if(root == null)
			return true;
		
		int LeftDepth = getDepth(root.left);
		int RightDepth = getDepth(root.right);
		int diff = LeftDepth - RightDepth;
		if(diff>1 || diff<-1){
			return false;
		}
		return isBalanced(root.left) && isBalanced(root.right);
		
	}
	
	/**
	 * judge the tree is or not balanced using the other
	 *  way(the code is wrong).
	 */
	public boolean isBalanced_otherway(TreeNode root,int height){
		if(root == null){
			height = 0;
			return true;
		}
		int LeftHeight=0,RightHeight=0;//初始化为0是错误的，但java中又必须初始化，直接借鉴c++代码。 
		boolean LeftResult = isBalanced_otherway(root.left,LeftHeight);
		boolean RightResult = isBalanced_otherway(root.right,RightHeight);
		if(LeftResult && RightResult && Math.abs(LeftHeight-RightHeight)<=1){
			height = Math.max(LeftHeight,RightHeight)+1;
			return true;
		}else{
			height = Math.max(LeftHeight,RightHeight)+1;
			return false;
		}
			
	}
	
	/**
	 * find the last common parents of two nodes.
	 */
	public TreeNode getLastCommonParents(TreeNode root,TreeNode node1,TreeNode node2){
		if(findNode(root.left,node1)){
			if(findNode(root.right,node2)){
				return root;
			}else{
				return getLastCommonParents(root.left,node1,node2);
			}
		}else{
			if(findNode(root.left,node2)){
				return root;
			}else{
				return getLastCommonParents(root.right,node1,node2);
			}
		} 
	}
	/**
	 * the assist function of getLastCommonParents
	 */
	public boolean findNode(TreeNode root,TreeNode node){
		if(root == null || node == null)
			return false;
		if(root == node)
			return true;
		boolean find = findNode(root.left,node);
		if(!find)
			find = findNode(root.right,node);
		return find;
	}
	
	/**
	 * find the last common parents without recursion
	 */
	public TreeNode getLastCommonParents_path(TreeNode root,TreeNode node1,TreeNode node2){
		if(root == null || node1 == null || node2 == null)
			return null;
		Stack<TreeNode> path1 = new Stack<TreeNode>();
		Stack<TreeNode> path2 = new Stack<TreeNode>();
		boolean res1 = getNodePath(root,node1,path1);
		boolean res2 = getNodePath(root,node2,path2);
		if(!res1 || !res2)
			return null;
		TreeNode resnode = null;
		TreeNode node_path1 = path1.pop();
		TreeNode node_path2 = path1.pop();
		while(node_path1 != null && node_path2 != null){
			if(node_path1 == node_path2){
				resnode = node_path1;
				break;
			}
			node_path1 = path1.pop();
			node_path2 = path2.pop();
		}
		return resnode;
	}
	/**
	 * the assist function of getLastCommonParents_path
	 */
	public boolean getNodePath(TreeNode root,TreeNode node,Stack<TreeNode> path){
		if(root == node){
			path.push(root);
			return true;
		}
		if(root == null)
			return false;
		path.push(root);
		boolean find = false;
		find = getNodePath(root.left,node,path) || getNodePath(root.right,node,path);
		if(!find)
			path.pop();
		return false;		
	}
	
	/**
	 * get the max distance of the tree by depth
	 */
	public int getMaxDist(TreeNode root,int MaxDist){
		if(root == null)
			return 0;
		else if(root.left == null && root.right == null)
			return 0;
		int Distance = Math.max(getDepth(root.left)+getDepth(root.right), 
				Math.max(getMaxDist(root.left,MaxDist), getMaxDist(root.right,MaxDist)));
		if(MaxDist<Distance)
			MaxDist = Distance;
		return Distance;
		
	}
	
	/**
	 * get the max distance of the tree
	 * the wrong code
	 */
	public int getMaxDistance(TreeNode root,int maxLeft,int maxRight){
		if(root == null){
			maxLeft = 0;
			maxRight = 0;
			return 0;
		}
		int maxLL=0,maxLR=0,maxRL=0,maxRR=0; //这里的初始化操作是错误的，借鉴c++代码但java必须要初始化，应该不。
		int maxDistLeft=0,maxDistRight=0;
		if(root.left != null){
			maxDistLeft = getMaxDistance(root.left,maxLL,maxLR);
			maxLeft = Math.max(maxLL, maxLR)+1;
		}else{
			maxDistLeft = 0;
			maxLeft = 0;
		}
		if(root.right != null){
			maxDistRight = getMaxDistance(root.right,maxRL,maxRR);
			maxRight = Math.max(maxRL, maxRR)+1;
		}else{
			maxDistRight = 0;
			maxRight = 0;
		}
		return Math.max(Math.max(maxDistLeft, maxDistRight), maxLeft+maxRight);
		
	}
	
	/**
	 * rebuild the tree through PreorderTreeWalk and InorderTreeWalk
	 */
	public TreeNode rebuildTree(int[] Preorder,int[] Inorder,int NodeNum){
		if(Preorder == null || Inorder == null || NodeNum <= 0){
			return null;
		}
		TreeNode root = new TreeNode(Preorder[0]);
		root.left = null;
		root.right = null;
		int RootPosInorder = -1;
		for(int i=0;i<NodeNum;i++){
			if(Inorder[i] == root.value){
				RootPosInorder = i;
				break;
			}
		}
		int NodeNumLeft = RootPosInorder;
		int[] PreorderLeft = Arrays.copyOfRange(Preorder, 1,1+NodeNumLeft);
		int[] InorderLeft = Arrays.copyOfRange(Inorder,0,RootPosInorder);
		root.left = rebuildTree(PreorderLeft,InorderLeft,NodeNumLeft);
		
		int NodeNumRight = NodeNum - NodeNumLeft-1;
		int[] PreorderRight = Arrays.copyOfRange(Preorder, NodeNumLeft+1, Preorder.length);
		int[] InorderRight = Arrays.copyOfRange(Inorder,NodeNumLeft+1,Inorder.length);
		root.right = rebuildTree(PreorderRight,InorderRight,NodeNumRight);
		return root;
	}
	
	/**
	 * judge whether the tree is CompleteBinaryTree
	 */
	public boolean isCompleteBinaryTree(TreeNode root){
		if(root == null)
			return false;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		boolean flag_noChild = false;
		boolean result = false;
		while(!q.isEmpty()){
			TreeNode node = q.poll();
			if(flag_noChild){
				if(node.left != null || node.right != null){
					result = false;
					break;
				}
			}else{
				if(node.left != null && node.right != null){
					q.offer(node.left);
					q.offer(node.right);
				}else if(node.left != null && node.right == null){
					flag_noChild = true;
					q.offer(node.left);
				}else if(node.left == null && node.right != null){
					result = false;
					break;
				}else{
					flag_noChild = true;
				}
			}
		}
		return result;
		
	}

}
