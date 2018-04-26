//implement program for stack using linked list
// import java.util.*;
class MyException extends Exception
{
	public MyException(String s)
	{
		super(s);
	}
}
class Node<T>
{
	T data;
	Node next;
	public Node(T data)
	{
		this.data=data;
		 this.next=null;
	}
}
public  class stack<T>
{
	Node head;
	int n;
	public stack()
	{
		head=null;
		n=0;
	}
	public void push(T s)
	{
		Node ob=new Node(s);
		if(head==null){
			head=ob;
			n++;
		}
		else
		{
			Node temp=head;
			head=ob;
			head.next=temp;
			n++;
		}
	}
	public T pop() throws MyException
	{
		T temp;
		if(head==null)
			throw new MyException("stack is underFLow");
		else
		{
			temp=(T)head.data;
			head=head.next;
		}n--;
		return  temp;	
	}
	public boolean isEmpty()
	{
		return head==null;
	}
	public int size()
	{
		return n;
	}
	public void display()
	{
		Node temp=head;
		if(head==null)
			System.out.println("[]");
		else{
			System.out.print("[");
			while(temp!=null)
			{
				if(temp.next!=null)
					System.out.print(temp.data+",");
				if(temp.next==null)System.out.print(temp.data+"]");
				temp=temp.next;
			}
		}
	}
	public static void main(String[] args) {
		try{
		stack  ob=new stack();
		ob.push(7);
		ob.push(89);
		ob.push("Hello");
		ob.push("out");
		ob.push("first");
		ob.push("in");
		ob.push("last");
		System.out.println(ob.isEmpty());
		System.out.println(ob.size());
		ob.display();
		ob.pop();
		ob.display();
		ob.pop();
		ob.display();
		ob.pop();
		ob.display();
		ob.pop();
		ob.display();
		ob.pop();
		ob.display();
		ob.pop(); 
		ob.display();
		ob.pop();
		System.out.println(ob.isEmpty());
		ob.pop();
		ob.pop();
		ob.pop();
		ob.push("last");
		ob.display();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}