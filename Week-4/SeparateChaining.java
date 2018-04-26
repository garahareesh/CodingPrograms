//implement HashTable using Separate chaining
import java.util.*;
class Node<Key extends Comparable<Key>,Value>
{
	Key key;
	Value val;
	Node next;
	Node(Key key, Value val)
	{
		this.key=key;
		this.val=val;
		next=null;
	}
}
class LinkedList<Key extends Comparable<Key>,Value>
{
	Node head;
	int n;
	LinkedList()
	{
		head=null;
		n=0;
	}
	public void put(Key k, Value v)
	{
		Node ob=new Node(k,v);
		if(!contains(k))
		{
			ob.next=head;
			head=ob;
			n++;
			return ;
		}
		Node temp=head;
		while(temp.key.compareTo(k)!=0)
			temp=temp.next;
		temp.val=v;
	}
	public boolean contains(Key k)
	{
		if(k==null) throw new IllegalArgumentException("contains key() argumnt is null");
		return get(k)!=null;
	}
	public Value get(Key k)
	{
		if(k==null) throw new IllegalArgumentException("get key() argumnt is null");
		Node temp=head;
		while (temp!=null) {
			if(temp.key.compareTo(k)==0)
				return (Value) temp.val;
			temp=temp.next;
		}return null;
	}
	public void delete(Key k)
	{
		if(k==null) throw new IllegalArgumentException("delete key() argumnt is null");
		Node temp=head;
		if(head.key.compareTo(k)==0)
		{
			head=head.next;
			n--;
			return;
		}
		Node previous=null;
		while(temp!=null)
		{
			previous=temp;
			temp=temp.next;
			if(temp.key.compareTo(k)==0)
			{
				previous.next=temp.next;
				n--;
				return;
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
public class SeparateChaining<S extends Comparable<S>,T>
{
	LinkedList<S,T>[] st;
	int m=10;
	int count=0;
	SeparateChaining()
	{
		st=new LinkedList[m];
		for(int i=0;i<m;i++)
		{
			st[i]=new LinkedList<S,T>();
		}
	}
	public void put(S key, T val)
	{
		if(key==null) throw new IllegalArgumentException("key is null");
		if(val==null)
		{
			delete(key);
			return;
		}
		int h=hash(key);
		if(count==0)
		{
			st[h].put(key,val);
			return;
		}
		if(!st[h].contains(key))
			count++;
		st[h].put(key,val);
	}
	public T get(S key)
	{
		if(key==null) throw new IllegalArgumentException("Key is null");
		int h=hash(key);
		if(!st[h].contains(key))
			return null;
		return st[h].get(key);
	}
	public void delete(S key)
	{
		if(key==null) throw new IllegalArgumentException("Key is null");
		int h=hash(key);
		if(st[h].contains(key)){
			st[h].delete(key);
			count--;
		}
	}
	public int hash(S key)
	{
		return (key.hashCode() & 0x7fffffff)%m;
	}
	public int size()
	{
		return count;
	}
	public boolean contains(S key)
	{
		if(key==null) throw new IllegalArgumentException("Key is null");
		int h=hash(key);
		if(st[h].contains(key))
			return true;
		return false;
	}
	public void display()
	{
		for(int i=0;i<m;i++)
		{
			st[i].display();
			System.out.println();
		}
	}
	public static void main(String[] args) {
		SeparateChaining ob=new SeparateChaining();
		ob.put(22,0);
			ob.put(32,10);
			ob.put(42,1);
			ob.put(52,3);
			ob.put(21,04);
			ob.put(31,50);
			ob.put(41,07);
			ob.put(51,03);
			ob.put(233,80);
			ob.put(23,9);
			ob.put(43,11);
			ob.put(53,4);
			ob.put(4,5);
			ob.put(14,77);
			ob.put(55,4);
			ob.put(65,01);
			ob.put(66,110);
			ob.put(66,011);
			ob.put(27,01);
			ob.put(37,130);
			ob.put(28,120);
			ob.put(38,120);
			ob.display();
	}
}