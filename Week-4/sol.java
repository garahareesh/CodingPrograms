import java.util.*;
public class sol<Key extends Comparable<Key>,Value>
{
	private class Node
	{
		private Key keys;
		private Value val;
		Node left, right;
		int count;
		public Node(Key keys, Value val,int count)
		{
			this.keys=keys;
			this.val=val;
			this.count=count;
		}
	}
	Node root;
	public sol()
	{
		this.root=null;
	}
	public void put(Key k, Value v)
	{
		root=put(root,k,v);
	}
	private Node put(Node x, Key k, Value v)
	{
		if(x==null) return  new Node(k,v,1);
		int cmp=k.compareTo(x.keys);
		if(cmp<0) x.left=put(x.left,k,v);
		else if(cmp>0) x.right=put(x.right,k,v);
		else x.val=v;
		x.count=1+size(x.left)+size(x.right);
		return  x;
	}
	public int rank(Key k)
	{
		return rank(root,k);
	}
	private int rank(Node x, Key k)
	{
		if(root==null) return 0;
		if(k==null) throw new IllegalArgumentException("key is null");
		int cmp=k.compareTo(x.keys);
		if(cmp<0) return rank(x.left,k);
		else if(cmp>0) return 1+size(x.left)+rank(x.right,k);
		else return size(x.left);
	}
	public int size()
	{
		return size(root);
	}
	private int size(Node x)
	{
		if(x==null) return  0;
		else return (x.count);
	}
	public boolean isEmpty()
	{
		return size()==0;
	}
	public Value get(Key k)
	{
		if(k==null) throw new IllegalArgumentException("keys is null");
		 return get(root,k);
	}
	private Value get(Node x, Key k)
	{
		if(x==null) return null;
		int cmp=k.compareTo(x.keys);
		if(cmp<0) return get(x.left,k);
		if(cmp>0) return  get(x.right,k);
		else return x.val;
	}
	public Key floor(Key k)
	{
		if(k==null) throw new IllegalArgumentException("key is null");
		Node x=floor(root,k);
		if(x==null) return  null;
		else return  x.keys;
	}
	private Node floor(Node x, Key k)
	{
		if(x==null) return  null;
		int cmp=k.compareTo(x.keys);
		if(cmp==0) return  x;
		else if(cmp<0) return floor(x.left,k);
		Node t=floor(x.right,k);
		if(t!=null) return t;
		else return x;
	}
	public Key ceiling(Key k)
	{
		if(k==null) throw new IllegalArgumentException("key is null");
		Node x=ceiling(root,k);
		if(x==null) return  null;
		else return x.keys;
	}
	private Node ceiling(Node x, Key k)
	{
		if(x==null) return null;
		int cmp=k.compareTo(x.keys);
		if(cmp==0) return x;
		if(cmp>0) return ceiling(x.right,k);
		Node t=ceiling(x.left,k);
		if(t!=null) return t;
		else return x;
	}
	public void delete(Key k)
	{
		if(k==null) throw new IllegalArgumentException("key is null");
		root=delete(root,k);
	}
	private Node delete(Node x,Key k)
	{
		int cmp=k.compareTo(x.keys);
		if(cmp<0) x.left=delete(x.left,k);
		else if(cmp>0) x.right=delete(x.right,k);
		else
		{
			if(x.left==null) return x.right;
			if(x.right==null) return  x.left;
			Node t=x;
			x=min(t.right);
			x.right=deleteMin(t.right);
			x.left=t.left;
		}
		x.count=1+size(x.left)+size(x.right);
		return x;
	}
	public Key min()
	{
		if(isEmpty()) throw new IllegalArgumentException("key is null");
		return  min(root).keys;
	}
	private Node min(Node x)
	{
		if(x.left==null) return x;
		else return min(x.left); 
	}
	public Key max()
	{
		if(isEmpty()) throw new IllegalArgumentException("key is null");
		return max(root).keys;
	}
	private Node max(Node x)
	{
		if(x.right==null) return x;
		else return  max(x.right);
	}
	public void deleteMin()
	{
		if(isEmpty()) throw new IllegalArgumentException("key is null");
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
		if(isEmpty()) throw new NoSuchElementException("isEmpty");
		root=deleteMax(root);
	}
	private Node deleteMax(Node x)
	{
		if(x.right==null) return x.left;
		x.right=deleteMax(x.right);
		x.count=1+size(x.left)+size(x.right);
		return x;
	}
	public void display()
	{
		inorder(root);
		System.out.println();
	}
	public void inorder(Node x)
	{
		if(x==null) return ;
		inorder(x.left);
		System.out.print(x.keys+" ");
		inorder(x.right);
	}
	public static void main(String[] args) {
		sol ob=new sol();
		ob.put("s",1); ob.put("e",2); ob.put("a",3); ob.put("r",4);ob.put("c",5);ob.put("h",6);
		ob.display();
		System.out.println("rank of e.."+ob.rank("e"));
		System.out.println("ceiling of c..."+ob.ceiling("c"));
		ob.deleteMin();
		ob.display();
		ob.deleteMax();
		ob.display();
		ob.deleteMin();ob.deleteMin();ob.display();ob.deleteMin();ob.deleteMin();
		ob.display();
	}
}