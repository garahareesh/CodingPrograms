//implementing Selection Sort
import java.util.*;
public class SelectionSort
{
	public SelectionSort()
	{
	}
	public void sort(Comparable [] a)
	{
		int n=a.length;
		for(int i=0;i<n;i++)
		{
			int min=i;
			for(int j=i+1;j<n;j++)
			{
				if(less(a[j],a[min]))
					min=j;
			}
			exch(a,i,min);
		}
		System.out.println(Arrays.toString(a));
	}
	public boolean less(Comparable a, Comparable b)
	{
		return a.compareTo(b)<1;
	}
	public void exch(Comparable [] a,int i,int j)
	{
		Comparable swap=a[i];
		a[i]=a[j];
		a[j]=swap;
	}
	public boolean isSorted(Comparable [] a)
	{
		int n=a.length;
		for(int i=0;i<n-1;i++)
		{
			if(!less(a[i],a[i+1]))
				return false;
		}return true;
	}
	public static void main(String[] args) {
		// Comparable [] a={100,50,520,60,60,-9,-555,555};
		// SelectionSort ob=new SelectionSort(a);
		// System.out.println(ob.isSorted());
		// ob.Sort();
		// System.out.println(ob.isSorted());
		Scanner scan=new Scanner(System.in);
		int no=Integer.parseInt(scan.nextLine());
		for(int i=0;i<no;i++)
		{
			SelectionSort ob=new SelectionSort();
			int len=Integer.parseInt(scan.nextLine());
			Comparable [] a=new Comparable[len];
			int k=0;
			while(k<len)
			{
				a[k++]=Integer.parseInt(scan.nextLine());
			}ob.sort(a);
			System.out.println();
		}

	}
}