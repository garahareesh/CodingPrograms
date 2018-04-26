//implements SequentialSearch using Linked list
import java.util.*;
class Node<Key,Value>
{
	Key key;
	Value val;
	Node next;
	public Node(Key k,Value v)
	{
		this.key=k;
		this.val=v;
		this.next=null;
	}
}
public class ST<Key,Value>
{
	Node head;
	int count;
	public ST()
	{
		head=null;
		count=0;
	}
	public void put(Key k, Value v)
	{
		Node ob=new Node(k,v);
		if(head==null)
		{
			head=ob;
			count++;
			return ;
		}
		
		for(int i=0;i<count;i++)
		{
			Node temp=head;
			if(temp.key.equals(k))
			{
				temp.val=v;
				return ;
			}
			temp=temp.next;
		}
		Node te=head;
		head=ob;
		head.next=te;
		count++;
	}
	public Value get(Key k)
	{
		if(k.equals(null))
			System.out.println("wrong ip");
		else
		{
			Node temp=head;
			for(int i=0;i<count;i++)
			{
				if(temp.key.equals(k))
					return (Value)temp.val;
				temp=temp.next;
			}
		}return  null;
	}
	public boolean isEmpty()
	{
		return count==0;
	}
	public int size()
	{
		return  count;
	}
	public boolean contains(Key k)
	{
		// System.out.println(count);
		if(k.equals(null))
			System.out.println("wrong ip");
		else
		{
			// System.out.println("I m here");
			Node temp=head;
			for(int i=0;i<count;i++)
			{
				// System.out.println(temp.key);
				if(temp.key.equals(k)){
					
					return true;
				}temp=temp.next;
			}
		}
		return false;
	}
	public void delete(Key k)
	{
		if(k.equals(null))
			System.out.println("wrong ip");
		else
		{
			Node temp=head;
			for(int i=0;i<count;i++)
			{
				if(temp.key.equals(k))
				{
					temp.val=null;
					return ;
				}
			}
		}
	}
	public void keys()
	{
		Node temp=head;
		while(temp.next!=null)
		{
			System.out.print(temp.key+" : "+temp.val+" ");
			temp=temp.next;
		}
		System.out.print(temp.key+": "+temp.val);
		System.out.println();
	}
	public static void main(String[] args) {
		ST ob=new ST();
		ob.put("e",0);ob.put("a",1);ob.put("s",2);ob.put("y",4);
		ob.keys();
		System.out.println("contains s is "+ob.contains("s"));
		System.out.println("contains a is "+ob.contains("a"));
		System.out.println("contains s is "+ob.contains("r"));
		System.out.println("get of y : "+ob.get("y"));
		System.out.println("get of a : "+ob.get("a"));
		System.out.println("get of e : "+ob.get("e"));
	}
}