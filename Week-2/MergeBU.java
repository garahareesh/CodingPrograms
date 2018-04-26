import java.util.*;
public class MergeBU<T extends Comparable<T>>
{
	Comparable[] array;
	Comparable[] aux;
	MergeBU(Comparable[] a)
	{
		this.array = a;
	}
	void sort()
	{
		int n = array.length;
		aux = new Comparable[n];
		for(int sz = 1; sz < n; sz = 2*sz)
		{
			for(int i = 0; i < n-sz; i = i+sz+sz)
			{
				int mid = i+sz-1;
				int  high = Math.min(i+sz+sz-1, n-1);
				mergesort(array,aux,i,mid,high);
			}
			System.out.println("for sz = "+ sz + "  Array-----> "+Arrays.toString(array));
		}
	}
	void mergesort(Comparable[] a,Comparable[] aux,int low,int mid,int high)
	{
		aux = Arrays.copyOf(a,a.length);
		int templow = low;
		int temphigh  = mid+1;
		for(int k = low;k <= high; k++)
		{
			if(templow > mid) array[k] = aux[temphigh++];
			else if(temphigh > high) array[k] = aux[templow++];
			else if(less(aux[templow],aux[temphigh])) array[k] = aux[templow++];
			else array[k] = aux[temphigh++]; 
		}
	}
	private boolean less(Comparable a,Comparable b)
	{
		return a.compareTo(b)<0;
	}
	public static void main(String[] args) {
		// Comparable[] a = {'m','e','r','g','e','s','o','r','t','e','x','a','m','p','l','e'};
		Comparable[] a = {'E','A','S','Y','Q','U','E','S','T','I','O','N'};

		MergeBU bu = new MergeBU(a);
		bu.sort();
	}
}
