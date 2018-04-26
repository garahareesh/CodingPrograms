//implementing Insertion Sort
import java.util.*;

class InsertionSort
{
	public InsertionSort()
	{

	}	
	private boolean less(Comparable a,Comparable b)
	{
		return a.compareTo(b)<=0;
	}
	public void sort(Comparable []a)
	{
		int length=a.length;
		for(int i=0;i<length;i++)
		{
			for(int j=i;j>0 && less(a[j],a[j-1]);j--)
				exch(a,j,j-1);
		}
		System.out.println(Arrays.toString(a));
	}
	public void exch(Comparable[] a, int i,int j)
	{
		Comparable swap=a[i];
		a[i]=a[j];
		a[j]=swap;
	}
	public boolean isSorted(Comparable []a)
	{
		for(int i=0;i<a.length-1;i++)
		{
			if(!less(a[i],a[i+1]))
				return false;
		}return true;
	}
	public static void main(String[] args) {
		// Comparable [] a={100,2,3,56,1,1,4,1111,2000,-1,-89,-99};
		// Comparable [] b={'a','x','b'};
		// InsertionSort is=new InsertionSort();
		// System.out.println(is.isSorted(b));
		// is.sort(b);
		// System.out.println(is.isSorted(b));
		Scanner sc=new Scanner(System.in);
		System.out.println("ntr no:");
		int no=Integer.parseInt(sc.nextLine());
		int k=0;
		for(int i=0;i<no;i++)
		{
			Comparable [] a;
			System.out.println("entrre len:");
			int len=Integer.parseInt(sc.nextLine());
			a=new Comparable[len];
			int s=0;
			InsertionSort is=new InsertionSort();
			while(s<len)
			{
				System.out.println("entrre str:");
				// String str=sc.nextLine();
				a[s]=Integer.parseInt(sc.nextLine());
				s++;
				System.out.println();
			}
			is.sort(a);
		}
	}
}