//implement QuickSort using Median
import java.util.*;
class QuickMedian<T extends Comparable<T>>
{
	Comparable [] arr;
	public QuickMedian(Comparable [] a)
	{
		this.arr=a;
	}
	public void sort(Comparable [] a)
	{
		sort(a,0,a.length-1);
	}
	public void sort(Comparable [] a,int low,int high)
	{
		int size=high-low+1;
		if(size<=3)
			general_sort(a,low,high);
		else
		{
			Comparable pivot=median(a,low,high);
			int partition_index=partition(a,low,high,pivot);
			sort(a,low,partition_index-1);
			sort(a,partition_index+1,high);
		}
	}
	public int partition(Comparable [] a,int low,int high,Comparable pivot)
	{
		int i=low;
		int j=high-1;
		while(true)
		{
			while (less(a[++i],pivot)) {
				
			}
			while(less(pivot,a[--j])){}
			if(i>=j) break;
			else exch(a,i,j);
		}	
		exch(a,i,high-1);
		return i;
	}
	public boolean less(Comparable a, Comparable b)
	{
		return (a.compareTo(b)<0);
	}
	public void exch(Comparable [] a,int i,int j)
	{
		Comparable swap=a[i];
		a[i]=a[j];
		a[j]=swap;
	}
	public void general_sort(Comparable [] a,int low,int high)
	{
		int len=high-low+1;
		if(len<=1) return;
		else if(len==2)
		{
			if(a[low].compareTo(a[high])>0){
				exch(a,low,high);
				return;
			}
		}
		else 
		{
			if(a[low].compareTo(a[high-1])>0 ) exch(a,low,high-1);
			if(a[high-1].compareTo(a[high])>0) exch(a,high-1,high);
			if(a[low].compareTo(a[high])>0)    exch(a,low,high);
			return;
		}
	}
	public Comparable median(Comparable [] a,int i,int j)
	{
		int k=(i+j)/2;
		if(a[i].compareTo(a[j])>0) exch(a,i,j);
		if(a[i].compareTo(a[k])>0) exch(a,i,k);
		if(a[k].compareTo(a[j])>0) exch(a,k,j);
		// System.out.println("in median    "+Arrays.toString(a));
		exch(a,k,j-1);
		// System.out.println("in median after exch  "+Arrays.toString(a));
		return a[j-1];
	}
	public void display()
	{
		System.out.println(Arrays.toString(arr));
	}
	public static void main(String[] args) {
		Comparable[] a = {6,2,-2,10,55,89,-53,100,-352};
		QuickMedian obj = new QuickMedian(a);
		obj.sort(a);
		obj.display();
	}
}