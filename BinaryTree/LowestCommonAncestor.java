package BInaryTree;
import java.util.ArrayList;

public class LowestCommonAncestor {

	static class Node{
		int data;
		Node left;
		Node right;
		public Node(int data) {
			this.data =data;
			this.left = null;
			this.right = null;
		}
	}
	
	static class BinaryTree{
		static int idx = -1;
		
		//preOrder tree root -> left -> right
		public Node buildTree(int node[]) {
			idx++;
			
			if(node[idx] == -1) {
				return null;
			}
			
			Node newNode = new Node(node[idx]);
			newNode.left = buildTree(node);
			newNode.right = buildTree(node);
			
			return newNode;
		}
	}
	
	public static boolean getPath(Node root, int n, ArrayList<Integer> path) {
		if(root == null) {
			return false;
		}
		
		path.add(root.data);
		
		if(root.data == n) {
			return true;
		}
		
		boolean leftPath = getPath(root.left, n, path);
		boolean rightPath = getPath(root.right, n, path);
		
		if(leftPath || rightPath) {
			return true;
		}
		
		path.remove(path.size() - 1);
		return false;
	}
	
	
	public static int LCA(Node root, int n1, int n2) {
		ArrayList<Integer> path1 = new ArrayList<>();
		ArrayList<Integer> path2 = new ArrayList<>();
		
		getPath(root, n1, path1);
		getPath(root, n2, path2);
		
		int i=0; 
		for( ; i<path1.size() && i<path2.size(); i++) {
			if(path1.get(i) != path2.get(i)) {
				break;
			}
		}
		
		return path1.get(i-1);
	}
	
	//method to find the lowest common accestor
	public static Node LCA2(Node root, int n1, int n2) {
		//base case
		if(root == null || root.data == n1 || root.data == n2 ) {
			return root;
		}
		
		Node leftLCA = LCA2(root.left, n1, n2);
		Node rightLCA = LCA2(root.right, n1, n2);
		
		if(leftLCA == null) {
			return rightLCA;
		}
		
		if(rightLCA == null) {
			return leftLCA;
		}
		
		return root;
	}
	
	//function to write code for minDistance between nodes
	public static int minDis(Node root, int n1, int n2) {
		Node lca = LCA2(root, n1, n2);
		int dist1 = findDis(lca, n1);
		int dist2 = findDis(lca, n2);
		
		return dist1 + dist2;
	}
	
	//function to find dis
	public static int findDis(Node lca, int n) {
		if(lca == null) {
			return -1;
		}
		
		if(lca.data == n) {
			return 0;
		}
		
		int leftDis = findDis(lca.left, n);
		int rightDis = findDis(lca.right, n);
		
		if(leftDis == -1 && rightDis == -1) {
			return - 1;
		} else if(leftDis == -1){
			return rightDis + 1;
		} else {
			return leftDis + 1;
		}
	}
	
	public static void main(String[] args) {
		int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
		BinaryTree bt = new BinaryTree();
		Node root = bt.buildTree(nodes);
		//System.out.println(LCA(root, 4, 5));
		System.out.println(LCA2(root, 4, 6).data);
		System.out.println(minDis(root, 4, 6));
	}
}
