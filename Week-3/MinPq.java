//implements min pQ
import java.util.*;
public class MinPq<Key extends Comparable<Key>>
{
	private Key[] pq;
	private int length=0;
	MinPq(int capacity)
	{
		pq=(Key[]) new Comparable[capacity];
	}
	public boolean isEmpty()
	{
		return length==0;
	}
	public int size()
	{
		return length;
	}
	public void insert(Key v)
	{
		pq[++length]=v;
		swim(length);
	}
	public void swim(int k)
	{
		while(k>1 && greater(k/2,k))
		{
			exch(k/2,k);
			k=k/2;
		}
	}
	public Key delMin()
	{
		Key min=pq[1];
		exch(1,length--);
		pq[length+1]=null;
		sink(1);
		return min;
	}
	public boolean greater(int i,int j)
	{
		return pq[i].compareTo(pq[j])>0;
	}
	public void exch(int i,int j)
	{
		Key temp=pq[i];
		pq[i]=pq[j];
		pq[j]=temp;
	}
	public void sink(int k)
	{
		while(2*k<=length)
		{
			int j=2*k;
			if(j<length && greater(j,j+1))
				j++;
			if(!greater(k,j))
				break;
			exch(k,j);
			k=j;
		}
	}
	public String show()
	{
		String str="";
		for(int i=1;i<=length;i++)
			str+=pq[i]+" ";
		return str;
	}
	
	public static void main(String[] args) {
		MinPq<Integer> ob = new MinPq<Integer>(40);
		ob.insert(-10);
		ob.insert(5);
		ob.insert(20);
		ob.insert(45);
		ob.insert(-35);
	
		System.out.println(ob.show());
		

		
	}
}