package BInaryTree;

public class SubTreeOfAnotheTree {
	
	public static boolean isIdentical(BinaryTreeAllBasic.Node root, BinaryTreeAllBasic.Node subRoot) {
		if(root == null && subRoot == null) {
			return true;
		} else if(root == null || subRoot == null || root.data != subRoot.data) {
			return false;
		}
		
		if(!isIdentical(root.left, subRoot.left)) {
			return false;
		}
		if(!isIdentical(root.right, subRoot.right)) {
			return false;
		}
		
		return true;
	}
	
	public static boolean isSubTree(BinaryTreeAllBasic.Node root, BinaryTreeAllBasic.Node subRoot) {
		
		if(root == null) {
			return false;
		}
		
		if(root.data == subRoot.data) {
			if(isIdentical(root, subRoot)) {
				return true;
			}
		}
		
		return isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot);
	}
	
	public static void main(String[] args) {
		int node[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
		//making one binaryTree
		BinaryTreeAllBasic.BinaryTree bt = new BinaryTreeAllBasic.BinaryTree();
		BinaryTreeAllBasic.Node root = bt.buildTree(node);
		
		
		//making another tree
		int node2[] = {3, 4, -1, -1, 5, -1, -1};
		
		BinaryTreeAllBasic.BinaryTree.idx = -1;
		
		BinaryTreeAllBasic.BinaryTree bt2 = new BinaryTreeAllBasic.BinaryTree();
		BinaryTreeAllBasic.Node subRoot = bt2.buildTree(node2);
		
		bt2.preOrder(subRoot);
		
		System.out.println(isSubTree(root, subRoot));
	}
}
