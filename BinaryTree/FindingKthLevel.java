package BInaryTree;

import java.util.*;

public class FindingKthLevel {
	
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
	
	public static void findKthLevel(Node root, int level, int k) {
		if(root == null) {
			return;
		}
		
		if(level == k) {
			System.out.print(root.data+" ");
			return;
		}
		
		findKthLevel(root.left, level + 1, k);
		findKthLevel(root.right, level + 1, k);
	}
	
	
	//using one more method
	static class Info{
		Node node;
		int level;
		public Info(Node node, int level) {
			this.node = node;
			this.level = level;
		}
	}
	
	public static void findNthLevel2(Node root, int k) {
		if(root == null) {
			return;
		}
		
		Queue<Info> q = new LinkedList<>();
		q.add(new Info(root, 1));
		
		
		while(!q.isEmpty()) {
			Info currNode = q.remove();
			
			if(currNode.level == k) {
				System.out.print(currNode.node.data+" ");
				continue;
			} 
			
			if(currNode.node.left != null) {
				q.add(new Info(currNode.node.left, currNode.level + 1));
			}
			
			if(currNode.node.right != null) {
				q.add(new Info(currNode.node.right, currNode.level + 1));
			}
		}
	}
	
	public static void main(String[] args) {
		int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
		BinaryTree bt = new BinaryTree();
		Node root = bt.buildTree(nodes);
		//findKthLevel(root, 1, 3);
		findNthLevel2(root, 3);
	}
}
