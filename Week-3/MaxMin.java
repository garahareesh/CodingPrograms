//implements maxPq and finding min element
import java.util.*;
public class MaxMin<Key extends Comparable<Key>>
{
	Key [] pq;
	int len;
	Key k;
	public MaxMin(int size)
	{
		pq=(Key[]) new Comparable[size];
		len=0;
		k=null;
	}
	public boolean less(int a,int b)
	{
		return ((Comparable<Key>) pq[a]).compareTo(pq[b]) < 0;
	}
	public void exch(int i,int j)
	{
		Key temp=pq[i];
		pq[i]=pq[j];
		pq[j]=temp;
	}
	public void resize(int capacity)
	{
		Key [] temp=(Key[]) new Comparable[capacity];
		temp=Arrays.copyOf(pq,pq.length);
		this.pq=temp;
	}
	public void insert(Key element)
	{
		if(len==pq.length-1)
			resize(2*len);
		pq[++len]=element;
		swim(len);
		min(element);
	}
	public Key min(Key element)
	{
		if(k==null)
			k=element;
		else
		{
			if(k.compareTo(element)>0)
			k=element;
		}
		
		System.out.println("min--> "+k);
		return k;
	}
	public void swim(int k)
	{
		while(k>1 && less(k/2,k))
		{
			exch(k/2,k);
			k=k/2;
		}
	}
	public void display()
	{
		System.out.println(Arrays.toString(pq));
	}
	public void sink(int k)
	{
		while(2*k<=len)
		{
			int j=2*k;
			if(j<len && less(j,j+1))
				j++;
			if(!less(k,j))
				break;
			exch(k,j);
			k=j;
		}
	}
	public static void main(String[] args) {
		MaxMin ob=new MaxMin(10);
		ob.insert(-10);
		ob.insert(5);
		ob.insert(20);
		ob.insert(45);
		ob.insert(-35);
		ob.display();
		// System.out.println(ob.min());
	}
}