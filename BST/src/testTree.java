import java.util.Queue;
import java.util.Stack;

public class testTree {
	public static void main(String args[]){
		Operation tree = new Operation();
		TreeNode root = tree.creatTree();
		
	    /*********���Ľڵ���*************/
		
		int TreeNodeNum = tree.getNodeNum(root);
		System.out.print("the num of treeNode:");
		System.out.println(TreeNodeNum);
		
		/**********�������**********/
		
		int treeDepth = tree.getDepth(root);
		System.out.print("The depth of the tree:");
		System.out.println(treeDepth);
		
		/**************�������*******************/
		
		Stack<Integer> stack_pre = new Stack<Integer>();
		tree.preorderTreeWalk_recursion(root,stack_pre);
		System.out.print("�ݹ�ʵ�����������");
		System.out.println(stack_pre);
		
		Stack<Integer> stack_pre_1 = new Stack<Integer>();
		tree.preorderTreeWalk(root,stack_pre_1);
		System.out.print("�ǵݹ�ʵ�����������");
		System.out.println(stack_pre_1);
		
		/**************�������********************/
		
		Stack<Integer> stack_in = new Stack<Integer>();
		tree.inorderTreeWalk_recursion(root,stack_in);
		System.out.print("�ݹ�ʵ�����������");
		System.out.println(stack_in);
		
		Stack<Integer> stack_in_1 = new Stack<Integer>();
		tree.inorderTreeWalk(root,stack_in_1);
		System.out.print("�ǵݹ�ʵ�����������");
		System.out.println(stack_in_1);
		
		/**************�������********************/
		
		Stack<Integer> stack_post = new Stack<Integer>();
		tree.postorderTreeWalk_recursion(root,stack_post);
		System.out.print("�ݹ�ʵ�ֺ��������");
		System.out.println(stack_post);
		
		Stack<Integer> stack_post_1 = new Stack<Integer>();
		tree.postorderTreeWalk(root,stack_post_1);
		System.out.print("�ǵݹ�ʵ�ֺ��������");
		System.out.println(stack_post_1);
		
		/************�������*************/
		Stack<Integer> result = new Stack<Integer>();
		result = tree.levelWalk(root);
		System.out.print("���������");
		System.out.println(result);
		
		int NodeNumKthLevel = tree.getNodeNumKthLevel(root, 3);
		System.out.printf("��%d��Ľڵ�����",3);
		System.out.println(NodeNumKthLevel);
		
		int LeavesNum = tree.getLeavesNum(root);
		System.out.printf("���������%d��Ҷ�ӽڵ�\n",LeavesNum);
		
		/**********���ľ���************/
		TreeNode newtree = tree.getMirror(root);
		Stack<Integer> res = tree.levelWalk(newtree);
		System.out.print("ԭ���ľ���");
		System.out.println(res);
		
		/**********�ж����Ƿ�ƽ��(AVL)***************/
		boolean isbalanced = tree.isBalanced(root);
		System.out.println("Is the tree balanced? "+isbalanced);
		
		/***********�����нڵ��������**************/
		int maxdistance = tree.getMaxDist(root,0);
		System.out.print("���нڵ��������Ϊ��");
		System.out.println(maxdistance);
		
		
	}
}
