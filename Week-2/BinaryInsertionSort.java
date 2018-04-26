//implementing BinaryInsertionSort
import java.util.*;
public class BinaryInsertionSort
{
	Comparable []a;
	public BinaryInsertionSort(Comparable [] a)
	{
		this.a=a;
	}
	private boolean less(Comparable a,Comparable b)
	{
		return a.compareTo(b)<1;
	}
	public void sort()
	{
		int n=a.length;
		for(int i=1;i<n;i++)
		{
			Comparable temp=a[i];
			int low=0;int high=i;
			while(low<high)
			{
				int mid=(low+high)/2;
				if(less(temp,a[mid]))
					high=mid;
				else
					low=mid+1;
			}
			for(int j=i;j>low;j--)
				a[j]=a[j-1];
			a[low]=temp;
		}
		System.out.println(Arrays.toString(a));
	}
	public static void main(String[] args) {
		Comparable [] a={1000,20,50,5,0,40,5,0,-9,-22,-55,44};
		BinaryInsertionSort ob=new BinaryInsertionSort(a);
		ob.sort();
	}
}