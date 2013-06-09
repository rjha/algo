
package test ;

/* educational purpose Binary search tree */
/* @author http://github.com/rjha */

public class bst {
	
	private Node root ;

	public bst(int x) {
		this.root = this.getNewNode(x) ;
	}

	private class Node {
		public int value ;
		public Node left ;
		public Node right ;

	}

	private class bst_printer {
		
		private int prev = Integer.MIN_VALUE ;
		private int current ;
		
		
		public void queue(int x) {
			this.prev = this.current ;
			this.current = x ;
			if(this.current < this.prev ) {
				String message = "This is not a BST \n" ;
				System.out.println(message);
				return false ;
			} else {
				System.out.println(x+ " ");
				return true ;
			}
				
		}
	}

	public Node getRoot() {
		return this.root ;
	}

	private Node getNewNode(int x) {
		String message = String.format("new (%d) \n",x);
		System.out.print(message);
		Node node  = new Node();
		node.value = x ;
		node.left = null ;
		node.right = null ;
		return node ;
	}
	
	private void addLeftNode(Node parent, int x) {
		String message = String.format("(%d) ->left(%d) \n",parent.value,x);
		System.out.print(message);
		Node node = this.getNewNode(x);
		parent.left = node ;
	}

	private void addRightNode(Node parent, int x) {
		String message = String.format("(%d) ->right(%d) \n",parent.value,x);
		System.out.print(message);
		Node node = this.getNewNode(x);
		parent.right = node ;
	}
	

	public void insert(Node node,int x) {
		// @warning node.right and node.left can change between these two lines
		// so either return explicitly or use method scope left/right node.
	
		if(x > node.value && (node.right == null)) { this.addRightNode(node,x); return ;}
		if(x > node.value && (node.right != null)) { this.insert(node.right,x); }

		if(x <= node.value && (node.left == null)) { this.addLeftNode(node,x); return ;}
		if(x <= node.value && (node.left != null)) { this.insert(node.left,x); }

	}

	public boolean lookup(Node node, int x) {
		boolean flag = false ;
		if(node == null) return false ;
		if(x == node.value ) { 
			flag =  true ;
		} else {
			if(x > node.value) { 
				flag = this.lookup(node.right,x); 
			} else { 
				flag = this.lookup(node.left,x); 
			}
		}
		
		return flag ;
	}
	
	public void print_in_order(Node node) {
		if(node == null ) return ;
		if(node != null ){
			print_in_order(node.left);
			System.out.print(node.value + " ");
			print_in_order(node.right);
		}
	}

	public static void main(String[] args) {
		bst tree = new bst(5);
		Node root = tree.getRoot();
		tree.insert(root,8);
		tree.insert(root,3);
		tree.insert(root,1);
		tree.insert(root,11);
		tree.print_in_order(root);
		System.out.println();
		
		System.out.println(tree.lookup(root,10));
		System.out.println(tree.lookup(root,3));

	}
}
