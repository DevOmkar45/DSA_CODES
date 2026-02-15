package BInaryTree;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeAllBasic {
		
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
			
			//traversal preOrder traversal  root -> left -> right
			public void preOrder(Node root) {
				
				if(root == null) {
					return;
				}
				
				System.out.print(root.data+" ");
				preOrder(root.left);
				preOrder(root.right);
			}
			
			//traversal inOrder traversal left -> root -> right
			public void inOrder(Node root) {
				if(root == null) {
					return;
				}
				
				inOrder(root.left);
				System.out.print(root.data+" ");
				inOrder(root.right);
			}
			
			//traversal postOrder left -> right -> root
			public void postOrder(Node root) {
				if(root == null) {
					return;
				}
				
				postOrder(root.left);
				postOrder(root.right);
				System.out.print(root.data+" ");
			}
			
			//traversal levelOrder level wise we store value
			public void levelOrder(Node root) {
				if(root == null) {
					return;
				}
				
				//take one queue to store nodes
				Queue<Node> q1 = new LinkedList<>();
				q1.add(root);
				q1.add(null);			//we have to push null after root 
				
				while(!q1.isEmpty()) {
					Node currNode = q1.remove();
					
					if(currNode == null) {
						System.out.println();	//next line
						
						if(q1.isEmpty()) {
							break;
						} else {
							q1.add(null);
						}
					} else {
						System.out.print(currNode.data+" ");
						
						if(currNode.left != null) {
							q1.add(currNode.left);
						}
						
						if(currNode.right != null) {
							q1.add(currNode.right);
						}
					}
				}
				
			}
			
			//function to find height of tree (max dist bet root and leaf)
			public int heightTree(Node root) {
				if(root == null) {
					return 0;
				}
				
				int lh = heightTree(root.left);
				int rh = heightTree(root.right);
				
				return Math.max(lh, rh) + 1;
			}
			
			//function to count number of nodes 
			public int countNode(Node root) {
				//this is base case
				if(root == null) {
					return 0;
				}
				
				//operation we are doing on every node 
				int leftCount = countNode(root.left);
				int rightCount = countNode(root.right);
				
				//hm current node ko uska rightCount and leftCount + 1 uska khudka count dere 
				return leftCount + rightCount + 1;
			}
			
			//function to count sum of node
			public int sumNode(Node root) {
				//base case
				if(root == null) {
					return 0;
				}
				
				//we kept faith on our sumNode that it will bring leftSum and rightSum and after bring both we just need to add l r and currnode value
				int leftSum = sumNode(root.left);
				int rightSum = sumNode(root.right);
				
				return leftSum + rightSum + root.data;			//we add both left tree sum and right tree sum and then we also add value of current node
			}
		}

		public static void main(String[] args) {
			int node[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
			BinaryTree bt = new BinaryTree();
			Node root = bt.buildTree(node);		//here pura tree bn gya
			System.out.println("preorder traversal");
			bt.preOrder(root);
			System.out.println("inorder traversal");
			bt.inOrder(root);
			System.out.println("postOrder traversal");
			bt.postOrder(root);
			System.out.println("levelOrder traversal");
			bt.levelOrder(root);
			System.out.println("height of tree  is :" + bt.heightTree(root));
			System.out.println("count to Nodes is : "+ bt.countNode(root));
			System.out.println("sum of all Nodes is : "+ bt.sumNode(root));
		}

}
