//implement longest chain and smallest in separate chaining
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
		next=null;
	}
}
class Linked<K extends Comparable<K>,V>
{
	Node head;
	int n;
	Linked()
	{
		head=null;
		n=0;
	}
	public void put(K key, V val)
	{
		Node ob=new Node(key,val);
		if(!contains(key))
		{
			ob.next=head;
			head=ob;
			n++;
			return ;
		}
		Node temp=head;
		while(!temp.key.equals(key))
			temp=temp.next;
		temp.val=val;
	}
	public V get(K key)
	{
		if(key==null) throw new IllegalArgumentException("key is null");
		Node temp=head;
		while(temp!=null)
		{
			if(temp.key.equals(key))
				return (V)temp.val;
			temp=temp.next;
		}
		return null;
	}
	public boolean contains(K key)
	{
		return get(key)!=null;
	}
	public void delete(K key)
	{
		if(key==null) throw new IllegalArgumentException("key is null");
		if(head.key.equals(key))
		{
			head=head.next;
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
	public void display()
	{
		Node temp=head;
		while(temp!=null)
		{
			System.out.println(temp.key+" : "+temp.val);
			temp=temp.next;
		}
	}
}
public class Sep<K extends Comparable<K>,V>
{
	Linked<K,V>[] st;
	int n;
	int m=10;
	int [] countArray;
	public Sep()
	{
		n=0;
		countArray=new int[m];
		st=new Linked[m];
		for(int i=0;i<m;i++)
		{
			st[i]=new Linked();
			countArray[i]=0;
		}
		

	}
	public int hash(K key)
	{
		return (key.hashCode() & 0x7fffffff)%m;
	}
	public void put(K key, V val)
	{
		if(key==null) throw new IllegalArgumentException("key is null");
		if(val==null)
		{
			delete(key);
			return ;
		}
		int h=hash(key);
		if(n==0)
		{
			st[h].put(key,val);
			countArray[h]=countArray[h]+1;
			n++;
			return; 	
		}
		if(!st[h].contains(key)){
			countArray[h]=countArray[h]+1;
			n++;
		}
		st[h].put(key,val);
	}
	public V get(K key)
	{
		if(key==null) throw new IllegalArgumentException("key is null");
		int h=hash(key);
		if(st[h].contains(key))
			return st[h].get(key);
		return null;
	}
	public void delete(K key)
	{
		if(key==null) throw new IllegalArgumentException("key is null");
		int h=hash(key);
		if(!st[h].contains(key)) return ;
		else st[h].delete(key);
		countArray[h]=countArray[h]-1;
		n--;
	}
	public void display()
	{
		for(int i=0;i<m;i++)
		{
			st[i].display();
			System.out.println();
		}
	}
	public void max()
	{
		int max=countArray[0];
		for(int i=0;i<m;i++)
		{
			if(countArray[i]>max)
				max=countArray[i];
		}
		int min=countArray[0];
		for(int j=0;j<m;j++)
		{
			if(countArray[j]<min)
				min=countArray[j];
		}
		System.out.println(min);
		System.out.println(max);
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=Integer.parseInt(sc.nextLine());
		for(int i=0;i<n;i++)
		{
			Sep ob=new Sep();
			String str=sc.nextLine();
			String [] ss=str.split(", ");
			for(int j=0;j<ss.length;j++)
			{
				String [] s=ss[j].split(" ");
				if(s[0].equals("put"))
					ob.put(Integer.parseInt(ss[1]),Integer.parseInt(ss[2]));
				ob.max();
			}
		}
	}
}