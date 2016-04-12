import java.util.Queue;
import java.util.Stack;

public class testTree {
	public static void main(String args[]){
		Operation tree = new Operation();
		TreeNode root = tree.creatTree();
		
	    /*********树的节点数*************/
		
		int TreeNodeNum = tree.getNodeNum(root);
		System.out.print("the num of treeNode:");
		System.out.println(TreeNodeNum);
		
		/**********树的深度**********/
		
		int treeDepth = tree.getDepth(root);
		System.out.print("The depth of the tree:");
		System.out.println(treeDepth);
		
		/**************先序遍历*******************/
		
		Stack<Integer> stack_pre = new Stack<Integer>();
		tree.preorderTreeWalk_recursion(root,stack_pre);
		System.out.print("递归实现先序遍历：");
		System.out.println(stack_pre);
		
		Stack<Integer> stack_pre_1 = new Stack<Integer>();
		tree.preorderTreeWalk(root,stack_pre_1);
		System.out.print("非递归实现先序遍历：");
		System.out.println(stack_pre_1);
		
		/**************中序遍历********************/
		
		Stack<Integer> stack_in = new Stack<Integer>();
		tree.inorderTreeWalk_recursion(root,stack_in);
		System.out.print("递归实现中序遍历：");
		System.out.println(stack_in);
		
		Stack<Integer> stack_in_1 = new Stack<Integer>();
		tree.inorderTreeWalk(root,stack_in_1);
		System.out.print("非递归实现中序遍历：");
		System.out.println(stack_in_1);
		
		/**************后序遍历********************/
		
		Stack<Integer> stack_post = new Stack<Integer>();
		tree.postorderTreeWalk_recursion(root,stack_post);
		System.out.print("递归实现后序遍历：");
		System.out.println(stack_post);
		
		Stack<Integer> stack_post_1 = new Stack<Integer>();
		tree.postorderTreeWalk(root,stack_post_1);
		System.out.print("非递归实现后序遍历：");
		System.out.println(stack_post_1);
		
		/************按层输出*************/
		Stack<Integer> result = new Stack<Integer>();
		result = tree.levelWalk(root);
		System.out.print("按层输出：");
		System.out.println(result);
		
		int NodeNumKthLevel = tree.getNodeNumKthLevel(root, 3);
		System.out.printf("第%d层的节点数：",3);
		System.out.println(NodeNumKthLevel);
		
		int LeavesNum = tree.getLeavesNum(root);
		System.out.printf("这棵树共有%d个叶子节点\n",LeavesNum);
		
		/**********树的镜像************/
		TreeNode newtree = tree.getMirror(root);
		Stack<Integer> res = tree.levelWalk(newtree);
		System.out.print("原树的镜像：");
		System.out.println(res);
		
		/**********判断树是否平衡(AVL)***************/
		boolean isbalanced = tree.isBalanced(root);
		System.out.println("Is the tree balanced? "+isbalanced);
		
		/***********求树中节点的最大距离**************/
		int maxdistance = tree.getMaxDist(root,0);
		System.out.print("树中节点的最大距离为：");
		System.out.println(maxdistance);
		
		
	}
}
