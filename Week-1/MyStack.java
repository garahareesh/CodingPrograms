//implemnt stack using arrays
import java.util.*;
class MyException extends Exception
{
	MyException(String s)
	{
		super(s);
	}
}
class MyStack<T>
{
	int n;
	T [] arr;

	public MyStack(int size)
	{
		n=0; 
		arr=(T[])new Object[size];
	}
	public void push(T element)
	{
		if(n>=arr.length/2)
			resize(2*arr.length);
		arr[n++]=element;
	}
	public T pop() throws MyException
	{
		if(n==0)
			throw new MyException("stack is underflow");
		T temp=arr[n-1];
		arr[n]=null;
		n--;
		if(n<=arr.length/4)
			resize(arr.length/2);
		return temp;

	}
	public void resize(int capacity)
	{
		T [] arr1=(T[])new Object[capacity];
		// arr1=Arrays.copyOf(arr,capacity);
		for(int i=0;i<n;i++)
		{
			arr1[i]=arr[i];
		}


		this.arr=arr1;
	}
	public String toString()
	{
		String s=""+"[";
			for(int i=0;i<n;i++)
			{
				if(i<n-1)
					s+=arr[i]+",";
				if(i==n-1)
					s+=arr[i]+"]";
			}
		return s;
	}
	public static void main(String[] args) {
		try{
			 MyStack stack=new MyStack(10);
			 stack.push(9);
			 stack.push("3");
			 stack.push("4");
			 stack.push("2");
			 stack.push(1);
			 stack.push(0);
			 System.out.println(stack);
			 // stack.pop();
			 // stack.pop();
			 
			 // stack.pop();
			 // stack.pop();
			 // stack.pop();
			 // stack.pop();
			 // stack.pop();
			 System.out.println(stack.pop());
			 System.out.println(stack.pop());
			 System.out.println(stack.pop());
			 System.out.println(stack.pop());
			 System.out.println(stack.pop());
			 System.out.println(stack.pop());
			 System.out.println(stack.pop());
			System.out.println(stack);
			}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}