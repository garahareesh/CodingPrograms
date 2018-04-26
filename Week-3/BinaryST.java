//implement Binary Search Symbol table
import java.util.*;
public class BinaryST<Key extends Comparable<Key>,Value>
{
	private Key[] keys;
	private Value[] vals;
	private int n;
	BinaryST(int size)
	{
		keys=(Key[]) new Comparable[size];
		vals=(Value[]) new Object[size];
		n=0;
	}
	public void resize(int capacity)
	{
		Key[] temp=(Key[]) new Object[capacity];
		Value[] temp1=(Value[]) new Object[capacity];
		temp=Arrays.copyOf(keys,capacity);
		temp1=Arrays.copyOf(vals,capacity);
		this.keys=temp;
		this.vals=temp1;
	}
	public int rank(Key k)
	{
		int lo=0,hi=n-1;
		while(lo<=hi)
		{
			int mid=(hi+lo)/2;
			int cmp=k.compareTo(keys[mid]);
			if(cmp>0) lo=mid+1;
			else if(cmp<0) hi=mid-1;
			else 
				return mid;
		}
		return lo;
	}
	public void put(Key k, Value v)
	{

		if(n==keys.length)
			resize(2*keys.length);
		int i=rank(k);
		if(i<n && keys[i].compareTo(k)==0)
		{
			vals[i]=v;
			return ;
		}
		for(int j=n;j>i;j--)
		{
			keys[j]=keys[j-1];
			vals[j]=vals[j-1];
		}
		keys[i]=k;
		vals[i]=v;
		n++;
	}
	public Value get(Key k)
	{
		if(isEmpty())
			return null;
		int i=rank(k);
		if(i<n && keys[i].compareTo(k)==0)
			return vals[i];
		return null;
	}
	public int size()
	{
		return n;
	} 
	public Key min()
	{
		return keys[0];
	}
	public Key max()
	{
		return keys[n-1];
	}
	public boolean isEmpty()
	{
		return n==0;
	}
	public void delete(Key k)
	{
		int i=rank(k);
		if(i<n && keys[i].compareTo(k)!=0){
			System.out.println("No such element found:");
			return ;
		}
		for(int j=i;j<n-1;j++)
		{
			keys[j]=keys[j+1];
			vals[j]=vals[j+1];
		}
		keys[n-1]=null;
		vals[n-1]=null;
		n--;
	}
	public Key select(int k)
	{
		return keys[k];
	}
	public Key ceiling(Key k)
	{
		int i=rank(k);
		return keys[i];
	}
	public Key floor(Key k)
	{
		int i=rank(k);
		if(i<n && k.compareTo(keys[i])==0)
			return keys[i];
		else
			return keys[i-1];
	}
	public void delMin()
	{
		Key min=min();
		delete(min);
	}
	public void delMax()
	{
		Key max=max();
		delete(max);
	}
	public void display()
	{
		for(int i=0;i<n;i++)
		{
			System.out.println(keys[i]+"--->"+vals[i]);
		}System.out.println();
	}
	public int size(Key lo,Key hi)
	{
		if(lo==null)
			System.out.println("wrong");
		if(hi==null)
			System.out.println("wrong");
		if(lo.compareTo(hi)>0) return 0;
		if(contains(hi))
			return rank(hi)-rank(lo)+1;
		else
			return rank(hi)-rank(lo);
	}
	public static void main(String[] args) {
		BinaryST ob=new BinaryST(4);
		ob.put("A",1);ob.put("Z",4);ob.put("S",11);ob.put("H",3);
		ob.display();
		ob.delete("S");
		ob.display();
		// ob.delete("K");
		System.out.println("floor of H.. "+ob.floor("H"));
		System.out.println("floor of I.. "+ob.floor("I"));
		System.out.println("floor of C.. "+ob.floor("C"));
		System.out.println("ceiling of H..."+ob.ceiling("H"));
		System.out.println("ceiling of Z..."+ob.ceiling("Z"));
		ob.display();
		ob.delMax();
		ob.display();
		ob.delMin();
		ob.display();
	}
}