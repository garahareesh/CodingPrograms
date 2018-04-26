import java.util.*;
public class Solution<K extends Comparable<K>,V>
{
	private class Node
	{
		K key;
		V val;
		Node left,right;
		int count;
		public Node(K key, V val, int count)
		{
			this.key=key;
			this.val=val;
			this.count=count;
		}
	}
	Node root;
	public Solution()
	{
		root=null;
	}
	public void insert(K key, V val)
	{
		if(key==null) throw new IllegalArgumentException("key is null");
		if(val==null)
			return ;
		root=insert(root,key,val);
	}
	public Node insert(Node x, K key, V val)
	{
		if(x==null) return new Node(key,val,1);
		int cmp=key.compareTo(x.key);
		if(cmp<0) x.left=insert(x.left,key,val);
		else if(cmp>0) x.right=insert(x.right,key,val);
		else x.val=val;
		x.count=1+size(x.left)+size(x.right);
		return x;
	}
	public V get(K key)
	{
		if(key==null) throw new IllegalArgumentException("key is null");
		Node x=get(root,key);
		if(x==null) return null;
		else return x.val;
	}
	public Node get(Node x, K key)
	{
		if(x==null) return null;
		int cmp=key.compareTo(x.key);
		if(cmp<0) return get(x.left,key);
		if(cmp>0) return  get(x.right,key);
		else return x;
	}
	public String min()
	{
		if(root==null) return "called min() with empty symbol table";
		return ""+min(root).key+":"+min(root).val;
	}
	public Node min(Node x)
	{
		if(x.left==null) return x;
		else return min(x.left);
	}
	public String max()
	{
		if(root==null) return "called max() with empty symbol table";
		return ""+max(root).key+":"+max(root).val;
	}
	public Node max(Node x)
	{
		if(x.right==null) return x;
		else return max(x.right);
	}
	public int size()
	{
		if(root==null) return 0;
		else return size(root);
	}
	public int size(Node x)
	{
		if(x==null) return 0;
		else return x.count;
	}
	public void display()
	{
		display(root);
		System.out.println();
	}
	public void display(Node x)
	{
		if(x==null) return ;
		display(x.left);
		String[] ar = max().split(":");
		if(x.key.equals(ar[0])){
			System.out.print(x.key+":"+x.val);
		}
		else{
			System.out.print(x.key+":"+x.val+",");

		}
		display(x.right);
	}
	public int rank(K key)
	{
		if(root==null) return 0;
		else return rank(root,key);
	}
	public int rank(Node x, K key)
	{
		if(x==null) return 0;
		int cmp=key.compareTo(x.key);
		if(cmp<0) return rank(x.left,key);
		if(cmp>0) return  1+size(x.left)+rank(x.right,key);
		return size(x.left);
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=Integer.parseInt(sc.nextLine());
		for(int i=0;i<n;i++)
		{
			Solution<String, Integer> ob=new Solution<String,Integer>();

			int k=Integer.parseInt(sc.nextLine());
			for(int j=0;j<k;j++)
			{
			String str=sc.nextLine();
			String [] ss=str.split(" ");
			int h=ss.length;
			if(h==3 && ss[0].equals("insert"))
			{
				ob.insert(ss[1],Integer.parseInt( ss[2]));
				ob.display();
			}
			if(h==1 && ss[0].equals("min"))
				System.out.println(ob.min());
			if(h==1 && ss[0].equals("max"))
				System.out.println(ob.max());
			if(h==2 && ss[0].equals("get")){
				if(ob.get(ss[1])==null)
					System.out.println("no such key");
				else
					System.out.println(ob.get(ss[1]));
			}
			if(h==2 && ss[0].equals("rank"))
				System.out.println(ob.rank(ss[1]));
			if(h==1 && ss[0].equals("size"))
				System.out.println(ob.size());
			}
			if(sc.hasNextLine())
			{
				sc.nextLine();
				System.out.println();
			}
		}
	}
}