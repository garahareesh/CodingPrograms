import java.util.*;
class MyException extends Exception
{
	public MyException(String s)
	{
		super(s);
	}
}
class MyQueue<Item>
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
		// last=0;
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
		// last=n;
	}
	public void enqueue(Item element)
	{
		if(n==temp.length)
		{
			resize(2*temp.length);
		}
		temp[n++]=element;
		// n++;
	}
	public Item dequeue() 
	{
		if(isEmpty())
		{
			throw new IllegalArgumentException("Queue is underflow ");
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
}
public class deqSort
{
	MyQueue q;
	public deqSort(int size)
	{
		q=new MyQueue(size);
	}
	public void add(int element)
	{
		q.enqueue(element);
	}
	public void sort()
	{
		q.display();
		
		
		while(true){
			int k=0;
			int index=0;
		while(index<q.n-1)
		{
			if((int)q.temp[0]>(int)q.temp[1])
			{
				exch(q,0,1);
				k++;
				// q.display();
			}
			q.enqueue(q.dequeue());
			System.out.println("after..............");
			q.display();
			index++;
		}
		q.enqueue(q.dequeue());
		q.display();
		if(k==0){
			q.display();
			break;
		}
		q.display();
	}

	}
	public void exch(MyQueue q,int a,int b)
	{
		int swap=(int)q.temp[0];
		q.temp[0]=q.temp[1];
		q.temp[1]=swap;
	}
	public static void main(String[] args) {
		MyQueue obj=new MyQueue(10);
		deqSort ob=new deqSort(10);
		ob.add(4);
		ob.add(3);ob.add(1);ob.add(5);ob.add(6);
		ob.sort();
	}
}