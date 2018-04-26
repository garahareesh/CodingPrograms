import java.util.*;
class Node<K extends Comparable<K>,V>
{
	K key;
	V val;
	Node next;
	public Node(K key, V val)
	{
		this.key=key;
		this.val=val;
		this.next=null;
	}
}
class LinkedList<K extends Comparable<K>,V>
{
	Node head;
	int n;
	LinkedList()
	{
		head=null;
		n=0;
	}
	public void put(K key, V val)
	{
		Node ob=new Node(key,val);
		if(head==null)
		{
			head=ob;
			n++;
			return ;
		}
		else
		{
			Node temp=head;
			while(temp!=null)
			{
				if(temp.key.equals(key)){
					temp.val=val;
					return ;
				}
				temp=temp.next;
			}
		}
		ob.next=head;
		head=ob;
		n++;
	}
	public V get(K key)
	{
		Node hareesh=head;
		while(hareesh!=null)
		{
			if(hareesh.key.equals(key))
				return (V) hareesh.val;
			hareesh=hareesh.next;
		}return null;
	}
	public boolean contains(K key)
	{
		// Node temp=head;
		// while(temp!=null)
		// {
		// 	if(temp.key.equals(key))
		// 		return true;
		// } return false;
		// System.out.println("hi hello");
		return get(key)!=null;
	}
	public void delete(K key)
	{
		if(head.key.equals(key))
		{
			head=head.next;
			n--;
			return ;
		}
		Node temp=head;
		Node prev=null;
		while(temp!=null)
		{
			prev=temp;
			temp=temp.next;
			if(temp.key.equals(key))
			{
				prev.next=temp.next;
				n--;
				return ;
			}
		}
	}
	public int size()
	{
		return n;
	}
	public void display()
	{
		Node temp=head;
		while(temp!=null)
		{
			if(temp.next!=null)
				System.out.print(temp.key+":"+temp.val+", ");
			else if(temp.next==null)
				System.out.print(temp.key+":"+temp.val);
		}
	}
}
public class Solution<K extends Comparable<K>,V>
{
	LinkedList<K,V> [] st;
	int len;
	int m=30;
	public Solution()
	{
		st=new LinkedList[m];
		for(int i=0;i<m;i++)
		{
			st[i]=new LinkedList();
		}
		len=0;
	}
	public int size()
	{
		return len;
	}
	public int hash(K key)
	{
		return (key.hashCode() & 0x7fffffff)%m;
	}
	public void put(K key, V val)
	{
		if(key==null) throw new IllegalArgumentException("key is not found");
		if(val==null)
		{
			delete(key);
			return ;
		}
		int h=hash(key);
		if(len==0)
		{
			st[h].put(key,val);
			len++;
			return ;
		}
		if(!st[h].contains(key))
			len++;
		st[h].put(key,val);
	}
	public V get(K key)
	{
		if(key==null) throw new IllegalArgumentException("key is not found");
		int h=hash(key);
		// String s="Key not found.";
		if(!st[h].contains(key)) return  null;
		else return st[h].get(key);
	}
	public boolean contains(K key)
	{
		int h=hash(key);
		return st[h].get(key)!=null;
	}
	public void delete(K key)
	{
		int h=hash(key);
		if(!st[h].contains(key))
		{
			System.out.println("Key not found.");
			return ;
		}
		st[h].delete(key);
		len--;
	}
	public void display()
	{
		if(len==0)
		{
			System.out.println("Hashtable is empty.");
			return ;
		}
		for(int i=0;i<len;i++)
		{
			st[i].display();
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int noOftestcases=Integer.parseInt(sc.nextLine());
		for(int i=0;i<noOftestcases;i++)
		{
			int n=Integer.parseInt(sc.nextLine());
			Solution ob=new Solution();
			for(int j=0;j<n;j++){
				
				String str=sc.nextLine();
				String [] ss=str.split(" ");
				int k=ss.length;
				if(k==1 && ss[0].equals("size"))
					System.out.println(ob.size());
				if(k==2 && ss[0].equals("get"))
					System.out.println(ob.get(ss[1]));
				if(k==2 && ss[0].equals("delete")){
					ob.delete(ss[1]);
					ob.display();
				}
				if(k==2 && ss[0].equals("put"))
				{
					String [] ip=ss[1].split(",");
					ob.put(ip[0],ip[1]);
					ob.display();
				}
			}

		}
	}
}