import java.util.*;
class Solution
{
	int [] array;
	int count;
	public Solution(int [] a)
	{
		this.array=a;
		// count=0;
	}	
	public boolean less(int a,int b)
	{
		count++;
		return a<b;
	}
	public void exch(int [] a,int i,int j)
	{
		// count=count+4;
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
	public void sort()
	{
		int n=array.length;
		int min=array[0];
		// int index=0;
		for(int i=0;i<n;i++)
		{
			count++;
			if(less(array[i],min))
			{
				int temp=array[i];
				array[min]=array[i];
				array[i]=temp;
				// min=array[i];
				// index=i;

			}
		}
		display();
		// int temp=array[0];
		// array[0]=array[index];
		// array[index]=temp;
		// count=count+4;
		for (int i=1;i<n ;i++ ) {
			count++;
			for (int j=i;less(array[j],array[j-1]) ;j-- ) {
				exch(array,j,j-1);	
			}
			display();
		}
		// 
		System.out.println("Number of comparisons are: "+count);
	}
	public void display()
	{
		int n=array.length;
		for(int i=0;i<n;i++)
		{
			if(i<n-1)
				System.out.print(array[i]+", ");
			if(i==n-1)
				System.out.print(array[i]);
		}System.out.println();
	}
	public static void main(String[] args) {
		// int [] a={1,4,2,5,3};
		// Solution ob=new Solution(a);
		// ob.sort();
		Scanner sc=new Scanner(System.in);
		int noOfTestcases=Integer.parseInt(sc.nextLine());
		for(int i=0;i<noOfTestcases;i++)
		{
			int n=Integer.parseInt(sc.nextLine());
			String str=sc.nextLine();
			String [] ss=str.split(", ");
			int [] arr=new int[ss.length];
			for(int j=0;j<arr.length;j++)
			{
				arr[j]=Integer.parseInt(ss[j]);
			}
			Solution ob=new Solution(arr);
			ob.sort();
			if(sc.hasNextLine())
			{
				sc.nextLine();
				System.out.println();
			}
		}
	}
}