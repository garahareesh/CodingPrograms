//implements minPq
import java.util.*;
public class MinPq<Key extends Comparable<Key>>
{
	Key[] pq;
	int n;
	public MinPq(int size)
	{
		pq=(Key[])new Comparable[size+1];
		n=0; 
	}
	public boolean greater(int a,int b)
	{
		return pq[a].compareTo(pq[b])>0;
	}
	public int size()
	{
		return n;
	}
	public void exch(int a,int b)
	{
		Key temp=pq[b];
		pq[b]=pq[a];
		pq[a]=temp;
	}
	public void resize(int capacity)
	{
		Key[] temp=(Key[]) new Comparable[capacity];
		temp=Arrays.copyOf(pq,capacity);
		this.pq=temp;
	}
	public void insert(Key element)
	{
		if(n>=pq.length-1)
			resize(2*pq.length);
		pq[++n]=element;
		swim(n);
	}
	public void swim (int k) {	
		while(k>1 && greater(k/2,k))
		{
			exch(k,k/2);
			k=k/2;
		}

	}
	public void sink(int k)
	{
		while(2*k<=n)
		{
			int j=2*k;
			if(j<n && greater(j,j+1))
				j++;
			if(!greater(k,j))
				break;
			exch(k,j);
			k=j;
		}
	}
	public Key delMin()
	{
		Key k=pq[1];
		exch(1,n--);
		pq[n+1]=null;
		// n--;
		sink(1);
		return k;

	}
	public void display()
	{
		System.out.println("elements in MinPq");
		for(int i=1;i<=n;i++)
			System.out.print(pq[i]+" ");
		System.out.println();
		
	}
	public static void main(String[] args) {
		MinPq ob=new MinPq(10);
		ob.insert(9);
		ob.insert(7);
		ob.insert(12);
		ob.insert(14);
		ob.insert(6);
		ob.insert(2);
		ob.insert(18);
		ob.insert(11);
		// ob.delMin();
		ob.display();
	}
}




