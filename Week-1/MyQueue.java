import java.util.*;
class MyException extends Exception
{
	public MyException(String s)
	{
		super(s);
	}
}
public class MyQueue<Item>
{
	Item[] temp;
	int n=0;
	int frst;
	int last;
	MyQueue(int size)
	{
		temp=(Item[]) new Object[size];
		n=0;
		frst=0;
		last=0;
	}
	public boolean isEmpty()
	{
		return n==0;
	}

	public int count()
	{
		return n;
	}
	public void resize(int capacity)
	{
		Item[] arr=(Item[]) new Object[capacity];
		for(int i=0;i<n;i++)
		{
			arr[i]=temp[i];
		}
		temp=arr;
		frst=0;
		last=n;
	}
	public void enqueue(Item element)
	{
		if(n==temp.length)
		{
			resize(2*temp.length);
		}
		temp[last++]=element;
		 n++;
	}
	public Item dequeue() throws MyException
	{
		if(isEmpty())
		{
			throw new MyException("Queue is underflow ");
		}
		Item itm=temp[frst];
		re();
		n--;
		return itm;
	}
	public void re()
	{
		for(int i=0;i<n-1;i++)
		{
			temp[i]=temp[i+1];
		}
	}
	public void display()
	{
		for(int i=0;i<n;i++)
		{
			System.out.print(temp[i]+" ");
		}
		System.out.println();

	}
	public static void main(String[] args) {
		try
		{
		MyQueue<Integer> obj= new MyQueue<Integer>(10);
		obj.enqueue(3);
		obj.enqueue(4);
		obj.enqueue(6);
		obj.enqueue(7);
		obj.enqueue(8);
		obj.enqueue(9);
		obj.enqueue(0);
		obj.display();
		obj.dequeue();
		System.out.println(obj.dequeue());
		System.out.println(obj.dequeue());
		System.out.println(obj.dequeue());
		System.out.println(obj.dequeue());
		System.out.println(obj.dequeue());
		System.out.println(obj.dequeue());
		System.out.println(obj.dequeue());
		System.out.println(obj.dequeue());
		obj.display();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}