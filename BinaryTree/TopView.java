package BInaryTree;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;

public class TopView {

	public static class Node{
		int data;
		Node left;
		Node right;
		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	static class Info{
		int hd;
		Node node;
		public Info(Node root, int pos) {
			this.hd = pos;
			this.node = root;
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
		
		//this is one method to do it
		//function to find top view of tree
		static HashMap<Integer, Integer> map = new HashMap<>();
		//two variable to track min and max postion
		static int min = 0;
		static int max = 0;
		
		public void topView(Node root, int pos) {
			if(root == null) {
				return;
			}
			
			min = Math.min(min, pos); 
			max = Math.max(max, pos);
			//or first we will check wheather current position exist in hashmap or not
			if(!map.containsKey(pos)){
				map.put(pos, root.data);
			}
			
			topView(root.left, pos - 1);		//if already exist or not we move to right 
			topView(root.right, pos + 1);		//then we move to right because we have to traverse whole tree
			
			return;
		}
		
		public void printTopView() {
			for(int i=min ; i<=max; i++) {
				System.out.print(map.get(i)+" ");
			}
		}
		
		
		//another method to find topView by using bfs
		public void topView2(Node root, int pos) {
			//now create hashMap and queue
			Queue<Info> q = new LinkedList<>();
			HashMap<Integer, Node> map = new HashMap<>();
			int min = 0, max = 0;
			q.add(new Info(root, 0));
			q.add(null);
			
			while(!q.isEmpty()) {
				Info currNode = q.remove();
				
				if(currNode == null) {
					if(q.isEmpty()) {
						break;
					} else {
						q.add(null);
					}
				} else {
					if(!map.containsKey(currNode.hd)) {
						map.put(currNode.hd, currNode.node);
					}
					
					if(currNode.node.left != null) {
						q.add(new Info(currNode.node.left, currNode.hd - 1));
						min = Math.min(min, currNode.hd - 1);
					}
					
					if(currNode.node.right != null) {
						q.add(new Info(currNode.node.right, currNode.hd + 1));
						max = Math.max(max, currNode.hd + 1);
					}
				}
			}
			
			for(int i=min; i<=max; i++) {
				System.out.print(map.get(i).data+" ");
			}
		}
	}
	
	public static void main(String[] args) {
		int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
		BinaryTree bt = new BinaryTree();
		Node root = bt.buildTree(nodes);
		//bt.topView(root, 0);
		//bt.printTopView();
		bt.topView2(root, 0);
		
	}
}
