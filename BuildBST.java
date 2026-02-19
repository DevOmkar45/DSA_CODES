package BInarySearchTree;

public class BuildBST {

	static class Node{
		int data;
		Node left;
		Node right;
		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	static class BST{
	
		public Node buildBST(Node root, int val) { 
			//base case
			if(root == null) {
				root = new Node(val);
				return root;
			}
			
			if(root.data > val) {
				//that mean root ke left me val ayega
				root.left = buildBST(root.left, val);
			} else {
				root.right = buildBST(root.right, val);
			}
			
			return root;
		}
	}
	
	public static void main(String[] args) {
		int nodes[] = {5, 1, 3, 4, 2, 7};
		
		BST bst = new BST();
		Node root = null;
		
		for(int i=0; i<nodes.length; i++) {
			root = bst.buildBST(root, nodes[i]);
		}
		
		System.out.println(root.data+" "+ root.left.data+" "+ root.left.right.data);
	}
}
