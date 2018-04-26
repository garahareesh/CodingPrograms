//implementing insertion sort with sentinel
import java.util.*;
public class InsertionWithSentinel
{
	Comparable [] a;
	InsertionWithSentinel(Comparable [] a)
	{
		this.a=a;
	}
	private boolean less(Comparable a,Comparable b)
	{
		return a.compareTo(b)<1;
	}
	public void sort()
	{
		int length=a.length;
		int index=0;
		Comparable min=a[0];
		for(int i=0;i<length;i++)
		{
			if(less(a[i],min)){
				min=a[i];
				index=i;
			}
		}
		Comparable temp=a[0];
		a[0]=a[index];
		a[index]=temp;
		for(int j=2;j<length;j++)
		{
			Comparable t=a[j];
			int b=j-1;
			while(less(t,a[b]))
			{
				a[b+1]=a[b];
				b--;
			}
			a[b+1]=t;
		}
		System.out.println(Arrays.toString(a));
	}
	public static void main(String[] args) {
		Comparable [] a={1000,20,50,5,0,40,5,0,-9,-22,-55,44};
		InsertionWithSentinel ob=new InsertionWithSentinel(a);
		ob.sort();
	}
}