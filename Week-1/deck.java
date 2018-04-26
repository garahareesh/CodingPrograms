// deque
import java.util.*;
class Node<Item>
{
	Item data;
	Node next;
	Node prev;
	public Node(Item data,Node next,Node prev)
	{
		this.data=data;
		this.next=next;
		this.prev=prev;
	}
}
public class deck<Item>
{
	Node head;
	Node tail;
	int count;
	public deck()
	{
		head=null;
		tail=null;
		count=0;
	}
	public boolean isEmpty()
	{
		return count==0;
	}
	public int size()
	{
		return count;
	}
	public void pushLeft(Item element)
	{
		Node ob=new Node(element,head,null);
		if(head!=null)
		{
			head.prev=ob;
		}head=ob;
		if(tail==null)
			tail=ob;
		count++;
	}
	public void pushRight(Item element)
	{
		Node ob=new Node(element,null,tail);
		if(tail!=null)
			tail.next=ob;
		tail=ob;
		if(head==null)
			head=ob;
		count++;
	}
	public void displayLeft()
	{
		System.out.println("displayLeft..");
		Node temp=head;
		while(temp!=null)
		{
			System.out.print(temp.data+" ");
			temp=temp.next;
		}System.out.println();
	}
	public void displayRight()
	{
		System.out.println("displayRight..");
		Node temp=tail;
		while(temp!=null)
		{
			System.out.print(temp.data+" ");
			temp=temp.prev;
		}
		System.out.println();
	}
	public Item popLeft()
	{
		if(count==0)
			throw new NoSuchElementException();
		Node temp=head;
		head=head.next;
		head.prev=null;
		count--;
		return (Item)temp.data;
	}
	public Item popRight()
	{
		if(count==0)
			throw new NoSuchElementException();
		Node temp=tail;
		tail=tail.prev;
		tail.next=null;
		count--;
		return (Item)temp.data;
	}
	public static void main(String[] args) {
		deck ob=new deck();
		ob.pushLeft(10);
		ob.pushLeft(20);
		// ob.pushLeft(30);
		// ob.pushLeft(40);
		ob.pushRight(100);
		ob.pushRight(200);
		// ob.pushRight(300);
		// ob.pushRight(400);
		ob.displayLeft();
		System.out.println(ob.popLeft());
		System.out.println(ob.popRight());
		// System.out.println(ob.popLeft());
		ob.displayRight();
	}
}