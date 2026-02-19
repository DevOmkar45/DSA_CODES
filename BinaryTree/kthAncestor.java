package BInaryTree;

public class kthAncestor {

	static class Node{
		int data;
		Node left;
		Node right;
		public Node(int data){
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	static class BinaryTree{
		static int idx = -1;
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
	
	//function to find kthAncetor
	public static int kthAncestor1(Node root, int n, int k) {
		//base case
		if(root == null) {
			return -1;
		}
		
		if(root.data == n) {
			return 0;
		}
		
		int leftDis = kthAncestor1(root.left, n, k);
		int rightDis = kthAncestor1(root.right, n, k);
		
		if(leftDis == -1 && rightDis == -1) {
			//that mean root ke dono side to nahi vo n value wala node
			return -1;
		}
		
		int max = Math.max(leftDis, rightDis);			//otherwise check krlo dono side me se max side konsi hai max vhi aye hogi jha element mila hoga
		
		if(max+1 == k) {
			System.out.println(root.data);
		}
		
		return max+1;
	}
	
	//function for transfer sum tree from binary tree -> leftsubTree and rightSubTree ka sum curr root me overwrite krna hai
	public static int sumTree(Node root) {
		if(root == null) {
			return 0;
		}
		
		int leftSum = sumTree(root.left);
		int rightSum = sumTree(root.right);
		
		int currRootNo = root.data;
		root.data = leftSum + rightSum;
		
		return root.data + currRootNo;
	}
	
	public static void main(String[] args) {
		int node[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1};
		BinaryTree bt = new BinaryTree();
		Node root = bt.buildTree(node);
		//kthAncestor(root, 5, 2);
		System.out.println(sumTree(root));
		
	}
}
