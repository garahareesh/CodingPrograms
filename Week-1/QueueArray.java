import java.util.*;
class MyException extends Exception
{
	public MyException(String s)
	{
		super(s);
	}
}
class QueueArray<Item>
{
int front;
int end;
int n;
Item[] array;
public QueueArray(int size)
{
	n=0;
	front=-1;
	end=-1;
	array =(Item[])new Object[size];
} 
public void enqueue(Item ele)
{
	// System.out.println(Arrays.toString(array));
	if(n>=array.length)
		resize(2*array.length);
	if(front==-1&&end==-1)
	{
		front=0;
		end=0;
		array[end]=ele;
		n++;
		return;

	}
	else
	{
		end++;
		array[end]=ele;
		n++;
		return;
	}
}
public Item dequeue() throws MyException
{
	Item temp;
	if(front==-1&&end==-1)
	{
		throw new MyException("Queue is underFlow");
	}
	else{
		temp=array[front];
		front=front+1;
		// n--;
	}
	// if(n<=array.length/4)
	// 	resize(array.length/2);
	return temp;
}
public void resize(int capacity)
{
	Item[] arr=(Item[]) new Object[capacity];
	arr=Arrays.copyOf(array,capacity);
	this.array=arr;
}
public  void display()
{	
	if(front==-1 && front>end){System.out.println("your queue is empty ");return;}
	// System.out.println(array[front]+"ghjk,");
	for(int i=front ;i<=end;i++)
	{
		System.out.println(array[i]);
	}
	// System.out.println(Arrays.toString(array));
	System.out.println();
}

public static void main(String[] args)
{
	try
	{
		QueueArray Q1=new QueueArray(10);
		Q1.enqueue(10);
		Q1.enqueue(20);
		Q1.enqueue("Queue");
		Q1.enqueue(100);
		// Q1.display();
		System.out.println(Q1.dequeue());
		System.out.println(Q1.dequeue());
		System.out.println(Q1.dequeue());
		System.out.println(Q1.dequeue());
		// Q1.dequeue();
		Q1.display();
		// Q1.dequeue();
		Q1.display();
		// Q1.dequeue();
		Q1.display();
	}
	catch (Exception e)
	{
		System.out.println(e.getMessage());
	}
}
}