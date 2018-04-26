//implement QuickSort using insertion
import java.util.*;
public class QuickInsertion<T extends Comparable<T>>
{
	Comparable [] a;
	int cut_off;
	public QuickInsertion(Comparable[] a,int n)
	{
		this.a=a;
		this.cut_off=n;
	}
	public void sort(Comparable []a,int low,int high)
	{
		if(high<=low+cut_off){
			insertionSort(a);
			return ;
		}
		System.out.println(low+"  "+high);
		int patition_index=partition(a,low,high);
		sort(a,low,patition_index-1);
		sort(a,patition_index+1,high);
		this.a=a;	
	}
	public int partition(Comparable [] a,int low,int high)
	{
		int i=low;
		int j=high-1;
		Comparable pivot=a[high];
		while(true)
		{
			while(less(a[i],pivot))
			{
				i++;
				if(i==high) break;
			}
			while(less(pivot,a[j]))
			{
				j--;
				if(j==low) break;
			}
			if(i>=j)
				break;
			exch(a,i,j);
		}	
		exch(a,i,high);
		return i;
	}
	public boolean less(Comparable a,Comparable b)
	{
		return a.compareTo(b)<0;
	}
	public void exch(Comparable [] a,int i,int j)
	{
		Comparable temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
	public void insertionSort(Comparable []a)
	{
		int n=a.length;
		for(int i=0;i<n;i++)
		{
			for(int j=i;j>0 &&(less(a[j],a[j-1]));j--)
				exch(a,j,j-1);
		}
		this.a=a;
	}
	public void display()
	{
		System.out.println(Arrays.toString(a));
	}
	public static void main(String[] args) {
		Comparable[] a = {6,2,-2,10,55,89,-53,100,-352,0};
		int no=3;
		QuickInsertion ob=new QuickInsertion(a,5);
		ob.sort(a,0,a.length-1);
		ob.display();
	}
}