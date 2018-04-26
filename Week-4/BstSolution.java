//implement BST
import java.util.*;
public class BstSolution<Key extends Comparable<Key>,Value>
{
	private class Node
	{
		Key key;
		Value val;
		Node left,right;
		int count;
		public Node(Key k, Value v,int count)
		{
			this.key=k;
			this.val=v;
			this.count=count;
		}
	}
	Node root;
	public BstSolution()
	{
		 root=null;
	}
	public int size()
	{
		return size(root);
	}
	private int size(Node x)
	{
		if(x==null) return 0;
		else return x.count;
	}
	public int rank(Key k)
	{
		if(k==null) throw new IllegalArgumentException("calling rank() is null");
		return rank(root,k);
	}
	private int rank(Node x, Key k)
	{
		if(root==null) return 0;
		int cmp=k.compareTo(x.key);
		if(cmp<0) return rank(x.left,k);
		else if(cmp>0) return 1+size(x.left)+rank(x.right,k);
		else return size(x.left);
	}
	public void put(Key k, Value v)
	{
		if(k==null) throw new IllegalArgumentException("calling put() argument is null");
		if(v==null)
		{
			delete(k);
			return;
		}
		root=put(root,k,v);
	}
	private Node put(Node x,Key k, Value v)
	{
		if(x==null) return  new Node(k,v,1);
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
	private Value get(Node x, Key k)
	{
		if(k==null) throw new IllegalArgumentException("calling get() argument is null");
		if(x==null) return null;
		int cmp=k.compareTo(x.key);
		if(cmp<0) return get(x.left,k);
		else if(cmp>0) return get(x.right,k);
		else return x.val;
	}
	public boolean contains(Key k)
	{
		if(k==null) throw new IllegalArgumentException("calling get() argument is null");
		return get(k)!=null;
	} 
	public boolean isEmpty()
	{
		return size()==0;
	}
	public Key floor(Key k)
	{
		if(k==null) throw new IllegalArgumentException("calling floor() argument is null");
		if(isEmpty()) throw new NoSuchElementException("called floor() with empty symbol table");
		Node x=floor(root,k);
		if(x==null) return null;
		else return x.key;
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
		if(k==null) throw new IllegalArgumentException("calling ceiling() argument is null");
		if(isEmpty()) throw new NoSuchElementException("called ceiling with empty symbol table");
		Node x=ceiling(root,k);
		if(x==null) return null;
		else return x.key;
	}
	private Node ceiling(Node x, Key k)
	{
		if(x==null) return null;
		int cmp=k.compareTo(x.key);
		if(cmp==0) return x;
		else if(cmp>0) return ceiling(x.right,k);
		Node t=ceiling(x.left,k);
		if(t!=null) return t;
		else return x;
	}
	public void delete(Key k)
	{
		if(k==null) throw new IllegalArgumentException("calling delete() argument is null");
		if(isEmpty()) throw new NoSuchElementException("called delete with empty symbol table");
		root=delete(root,k);
	}
	private Node delete(Node x, Key k)
	{
		if(k==null) throw new IllegalArgumentException("calling delete() argument is null");
		int cmp=k.compareTo(x.key);
		if(cmp<0) x.left=delete(x.left,k);
		if(cmp>0) x.right=delete(x.right,k);
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
	public Key min()
	{
		if(isEmpty()) throw new NoSuchElementException("called min with empty symbol table");
		return min(root).key;
	}
	private Node min(Node x)
	{
		if(x.left==null) return x;
		else return min(x.left);
	}
	public Key max()
	{
		if(isEmpty()) throw new NoSuchElementException("called max() with empty symbol table");
		return max(root).key;
	}
	private Node max(Node x)
	{
		if(x.right==null) return x;
		else return max(x.right);
	}
	public void deleteMin()
	{
		if(isEmpty()) throw new NoSuchElementException("called deleteMin() with empty symbol table");
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
		if(isEmpty()) throw new NoSuchElementException("called deleteMax() with empty symbol table");
		root=deleteMax(root);
	}
	private Node deleteMax(Node x)
	{
		if(x.right==null) return x.left;
		x.right=deleteMax(x.right);
		x.count=1+size(x.left)+size(x.right);
		return x;
	}
	public Key select(int k)
	{
		if(k<0 || k>=size()) throw new IllegalArgumentException("called select () key is null");
		Node x= select(root,k);
		return x.key;
	}
	private Node select(Node x, int k)
	{
		if(x==null) return  null;
		int t=size(x.left);
		if(t<k) return select(x.right,k-t-1);
		if(t>k) return select(x.left,k);
		else return  x;
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
		System.out.print(x.key+" ");
		inorder(x.right);
	}
	public void preorder()
	{
		preorder(root);
		System.out.println();
	}
	private void preorder(Node x)
	{
		if(x==null) return ;
		System.out.print(x.key+" ");
		preorder(x.left);
		preorder(x.right);
	}
	public void postorder()
	{
		postorder(root);
		System.out.println();
	}
	private void postorder(Node x)
	{
		if(x==null) return  ;
		postorder(x.left);
		postorder(x.right);
		System.out.print(x.key+" ");
	}
	public static void main(String[] args) {
		BstSolution ob=new BstSolution();
		ob.put("s",1); ob.put("e",2); ob.put("a",3); ob.put("r",4);ob.put("c",5);ob.put("h",6);
		// ob.display();
		// System.out.println("ceiling of c..."+ob.ceiling("c"));
		// ob.deleteMin();
		// ob.display();
		// ob.deleteMax();
		// ob.display();
		// ob.deleteMin();ob.deleteMin();ob.display();ob.deleteMin();ob.deleteMin();
		ob.display();
		ob.preorder();
		ob.postorder();
	}
}