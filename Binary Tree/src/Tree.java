

public class Tree {
	Node root;
	int count =0;
	class Node {    
	    int data; 
	        Node left, right; 
	          
	        Node(int value){ 
	            this.data = value; 
	            left = null; 
	            right = null; 
	        } 
	}
	public void add( int d) {
		
		Node new_node = new Node(d); 
		if (root == null) { 
			root = new_node; 
			count++;
		} 
		else { 
				Node last =root;
				Node prev =root;
				while(last!=null)
				{
				prev=last;
				if(last.data > d)
					last=last.left;
		    	else
		    		last=last.right;
		    	}
		    	if(prev.data > d) {
		    		prev.left=new_node;
		    		count++;
		    	}
		    	else {
		    		prev.right=new_node;
		    		count++;
		    	}
		    }
	} 
	
	public boolean search(int val) {
		return find(root, val);
		
	}
	
	boolean find(Node p, int vals) {
		if(p!=null) 
		{
			if(p.data == vals)
				return true;
			else if(p.data>vals)
				return find(p.left,vals);
			else 
				return find(p.right,vals);
		}
		return false;
	}
	
	int countNodes(Node p) {
		
		if(p!=null)
		{
			return 1+countNodes(p.right)+countNodes(p.left);
		}
		return 0;
		
	}
	
	boolean isEmpty()
	{
		if (root == null)
			return true;
		else
			return false;
	}
	
	public void TreePrint(int printChoice)
	{
		if(printChoice == 1)
			inorder(root);
		else if(printChoice == 2)
			preorder(root);
		else if(printChoice == 3)
			postorder(root);
		else
			System.out.println("wrong choice!!!");
			
	}
	
	void inorder(Node p)
	{
		
		if(p!=null)
		{
		inorder(p.right);
		System.out.println(p.data);
		inorder(p.left);
		
		}
	}

	void preorder(Node p)
	{
		if(p!=null)
		{
		System.out.println(p.data);
		preorder(p.left);
		preorder(p.right);
		}
	}
	void postorder(Node p)
	{
		if(p!=null)
		{
		postorder(p.left);
		postorder(p.right);
		System.out.println(p.data);
		}
	}
} 

