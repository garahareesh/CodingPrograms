//implement BST
import java.util.*;

public class BST<Key extends Comparable<Key>,Value>
{
	Node root;
	private class Node
	{
		private Key key;
		private Value val;
		Node left,right;
		private int count;
		public Node(Key k, Value v,int count)
		{
			this.key=k;
			this.val=v;
			this.count=count;
		}
	}
	public BST()
	{
		root=null;
	}
	public void put(Key k,Value v)
	{
		root=put(root,k,v);
	}
	public Node put(Node x,Key k, Value v)
	{
		if(x==null) return new Node(k,v,1);
		int cmp=k.compareTo(x.key);
		if(cmp<0) x.left=put(x.left,k,v);
		else if(cmp>0) x.right=put(x.right,k,v);
		else x.val=v;
		x.count=1+size(x.left)+size(x.right);
		return x;
	}
	public Value get(Key k)
	{
		return get(root,k);
	}
	// private Value get(Node x,Key k)
	// {
	// 	Node x=root;
	// 	while(x!=null)
	// 	{
	// 		int cmp=k.compareTo(x.key);
	// 		if(cmp<0) x=x.left;
	// 		else if(cmp>0) x=x.right;
	// 		else return x.val;
	// 	}
	// 	return null;
	// }
	private Value get(Node x, Key k)
	{
		if (k == null) throw new IllegalArgumentException("argument to get() is null");
		if(x==null) return null;
		int cmp=k.compareTo(x.key);
		if(cmp<0) return get(x.left,k);
		else if(cmp>0) return get(x.right,k);
		else return x.val;
	}
	public boolean contains(Key k)
	{
		if (k == null) throw new IllegalArgumentException("argument to contains() is null");
		return get(k)!=null;
	}
	public boolean isEmpty()
	{
		return size()==0;
	}
	public int size()
	{
		return size(root);
	}
	private int size(Node x)
	{
		if(x==null) return 0;
		else return (x.count);
	}
	public int rank(Key k)
	{
		if(k==null) throw new IllegalArgumentException("key is null");
		return rank(root,k);
	}
	private int rank(Node x, Key k)
	{
		if(x==null) return 0;
		int cmp=k.compareTo(x.key);
		if(cmp<0) return rank(x.left,k);
		else if(cmp>0) return 1+size(x.left)+rank(x.right,k);
		else return size(x.left);

	}
	public Key floor(Key k)
	{
		Node x=floor(root,k);
		if(k==null) throw new IllegalArgumentException("calling floor() argument is null");
		return x.key;
	}
	private Node floor(Node x, Key k)
	{
		
		if(x==null) return null;
		int cmp=k.compareTo(x.key);
		if(cmp==0) return x;
		if(cmp<0) return floor(x.left,k);
		Node t=floor(x.right,k);
		if(t!=null) return t;
		else return x;
	}
	public Key ceiling(Key k)
	{
		Node x=ceiling(root,k);
		if(k==null) throw new IllegalArgumentException("calling ceiling() argument is null");
		return x.key;
	}	
	private Node ceiling(Node x, Key k)
	{
		if(x==null) return null;
		int cmp=k.compareTo(x.key);
		if(cmp==0) return x;
		if(cmp>0) return ceiling(x.right,k);
		Node t=ceiling(x.left,k);
		if(t!=null) return t;
		else return x;
	}
	public void delete(Key k)
	{
		if(k==null) throw new IllegalArgumentException("delete key is null");
		root=delete(root,k);
	}
	public Node delete(Node x, Key k)
	{
		if(x==null) return null;
		int cmp=k.compareTo(x.key);
		if(cmp<0) x.left=delete(x.left,k);
		else if(cmp>0) x.right=delete(x.right,k);
		else
		{
			if(x.left==null) return x.right;
			if(x.right==null) return x.left;
			Node t=x;
			x=min(t.right);
			x.right=deleteMin(t.right);
			x.left=t.left;
		}
		x.count=1+size(x.left)+size(x.right);
		return x;
	}
	public Key max()
	{
		if(isEmpty()) throw new IllegalArgumentException("No such element found");
		return max(root).key;
	}
	public Node max(Node x)
	{
		if(x.right==null) return x;
		else
			return max(x.right);
	}
	public Key min()
	{
		if(isEmpty()) throw new IllegalArgumentException("No such element found");
		return min(root).key;
	}
	private Node min(Node x)
	{
		if(x.left==null) return x;
		else
			return min(x.left);
	}
	public void deleteMin()
	{
		if(isEmpty()) throw new IllegalArgumentException("No such element found");
		root=deleteMin(root);
	}
	private Node deleteMin(Node x)
	{
		if(x.left==null) return x.right;
		x.left=deleteMin(x.left);
		x.count=1+size(x.left)+size(x.right);
		return x;
	}
	public void deleteMax()
	{
		if(isEmpty()) throw new IllegalArgumentException("No such element found");
		root=deleteMax(root);
	}
	private Node deleteMax(Node x)
	{
		if(x.right==null) return x.left;
		x.right=deleteMax(x.right);
		x.count=1+size(x.left)+size(x.right);
		return x;
	}
	public void inorder()
	{
		inorder(root);
		System.out.println();
	}
	private void inorder(Node x)
	{
		if(x==null) return;
		inorder(x.left);
		System.out.print(x.key+" ");
		inorder(x.right);
		// System.out.println();
	}
	public static void main(String[] args) {
		BST ob=new BST();
		ob.put("s",1); ob.put("e",2); ob.put("a",3); ob.put("r",4);ob.put("c",5);ob.put("h",6);
		ob.inorder();
		System.out.println("ceiling of c..."+ob.ceiling("c"));
		ob.deleteMin();
		ob.inorder();
		ob.deleteMax();
		ob.inorder();
	}
}