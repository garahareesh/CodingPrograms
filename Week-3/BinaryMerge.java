//implement Array Node
import java.util.*;
class Array<Key, Value>
{
	Key key;
	Value val;
	Array(Key k,Value v)
	{
		this.key=k;
		this.val=v;
	}
	public String toString()
	{
		String s="";
		return s=s+key+":"+val;
	}
}
public class BinaryMerge<Key,Value>
{
	Array[] aa;
	int size=4;
	int n;
	Array []aux;
	BinaryMerge()
	{
		n=0;
		aa=new Array[size];
	}
	public void add(Key k, Value v)
	{
		Array ob=new Array(k,v);
		aa[n++]=ob;
	}
	public void sort()
	{
		// System.out.println(aa.length+":::::"+aux.length);
		aux=new Array[size];
		// System.out.println(aa.length+":::::"+aux.length);
		sort(aa,aux,0,n-1);

	}
	public void sort(Array []aa, Array []aux, int lo, int hi)
	{
		if(hi<=lo) return ;
		if(aa.length==0 || aa.length==1) return;
		int mid=(lo+hi)/2;
		sort(aa,aux,lo,mid);
		sort(aa,aux,mid+1,hi);
		merge(aa,aux,lo,mid,hi);
	}
	public void merge(Array[] aa, Array []aux,int low,int mid, int hi)
	{
		int lo=low;
		int mi=mid+1;
		for(int i=0;i<aa.length;i++)
		{
			aux[i]=aa[i];
		}
		for(int k=lo;k<=hi;k++)
		{
			if(lo>mid) aa[k]=aux[mi++];
			else if(mi>hi) aa[k]=aux[lo++];
			else if(less((String)aux[lo].key,(String)aux[mi].key)) aa[k]=aux[lo++];
			else aa[k]=aux[mi++];

		}
	}
	public boolean less(String a, String b)
	{
		return a.compareTo(b)<0;
	}
	public void display()
	{
		System.out.println(Arrays.toString(aa));
	}
	public static void main(String[] args) {
		BinaryMerge ob=new BinaryMerge();
		ob.add("A",1);ob.add("X",1);ob.add("S",1);ob.add("U",1);
		ob.display();
		ob.sort();
		ob.display();
	}
}