
package test ;

/* -------------------------------------  
  educational purpose Binary search tree 
  @author http://github.com/rjha 
  @see http://cslibrary.stanford.edu/110/ 
  -------------------------------------  */

public class bst {
	
	private Node root ;
	private BSTCallback callback ;

	public bst(int x) {
		this.root = this.getNewNode(x) ;
		this.callback = new BSTCallback();
	}

	public Node getRoot() {
		return this.root ;
	}

	public BSTCallback getCallback() {
		return this.callback ;
	}

	private class Node {
		public int value ;
		public Node left ;
		public Node right ;

	}

	private class BSTCallback {
		
		private int prev = Integer.MIN_VALUE ;
		private int current ;
		
		public boolean queue(int x) {
			this.prev = this.current ;
			this.current = x ;
			if(this.current < this.prev ) {
				return false ;
			} else {
				System.out.print(x+ " ");
				return true ;
			}
				
		}
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

	public static bst build(int[] input) {
		if(input == null || input.length <= 0 ) { return null ; }
		bst tree = new bst(input[0]);
		Node root = tree.getRoot();
		for(int i = 1 ; i < input.length ; i++)
			tree.insert(root,input[i]);
		return tree ;
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
	
	public void print_in_order(Node node, BSTCallback callback) {
		if(node == null ) return ;
		if(node != null ){
			print_in_order(node.left,callback);
			callback.queue(node.value);
			print_in_order(node.right,callback);
		}
	}

	public boolean isBST1(Node node, BSTCallback callback) {
		if(node == null ) return false;

		if(node != null ){
			print_in_order(node.left,callback);
			if(!callback.queue(node.value)){
				return false ;
			}
			print_in_order(node.right,callback);
		}
		return true ;

	}
	
	public int size(Node node) {
		if(node != null )
			return 1 + this.size(node.left) + this.size(node.right) ;
		else
			return 0 ;
	}

	public int depth(Node node) {
		if(node != null) {
			int left = 1 + this.depth(node.left);
			int right = 1 + this.depth(node.right);
			if(left > right ) 
				return left ;
			else
				return right ;
		} else {
			return 0 ;
		}

	}

	public static void main(String[] args) {
		//int[] input = {5,8,11,3,6,1,7,5,4,13,8,9,0} ;
		int[] input = {1,2,3} ;
		bst tree = null ;
		tree = tree.build(input);
		Node root = tree.getRoot();

		System.out.println(" size of tree = " + tree.size(root));
		System.out.println(" depth of tree = " + tree.depth(root));
	
		BSTCallback callback = tree.getCallback();
		tree.print_in_order(root,callback);
		System.out.println();
		
		System.out.println(tree.lookup(root,10));
		System.out.println(tree.lookup(root,3));

	}
}
