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
		int index=0;
		for(int i=0;i<n;i++)
		{
			count++;
			if(less(array[i],min))
			{
				// int temp=array[i];
				// array[min]=array[i];
				// array[i]=temp;
				min=array[i];
				index=i;

			}
		}
		
		int temp=array[0];
		array[0]=array[index];
		array[index]=temp;
		display();
		// count=count+4;
		for (int i=1;i<n ;i++ ) {
			count++;
			for (int j=i;less(array[j],array[j-1]) ;j-- ) {
				exch(array,j,j-1);	
			}
			display();
		}
		// for(int j=2;j<array.length;j++)
		// {
		// 	int t=array[j];
		// 	int b=j-1;
		// 	while(less(t,array[b]))
		// 	{
		// 		array[b+1]=array[b];
		// 		b--;
		// 	}
		// 	array[b+1]=t;
		// 	display();
		// }
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
		}//System.out.println();
	}
	public static void main(String[] args) {
		// int [] a={51, 27, 53, 99, 53, 45, 1, 58, 54, 94, 30, 86, 15, 90, 33, 6, 63, 26, 96, 5, 11, 97, 83, 40, 28, 36, 26, 32, 60, 67, 41, 85, 70, 0, 13, 61, 17, 4, 80, 19, 27, 25, 86, 48, 18, 85, 20, 19, 65, 2, 36, 8, 85, 0, 77, 55, 93, 54, 98, 86, 8, 100, 4, 0, 34, 39, 20, 37, 68, 51, 74, 76, 95, 95, 30, 41, 8, 80, 69, 68, 12, 85, 21, 39, 42, 12, 86, 45, 40, 31, 27, 89, 33, 80, 98, 83, 93, 52, 90, 30};
		// Solution ob=new Solution(a);
		// ob.sort();
		Scanner sc=new Scanner(System.in);
		// System.out.println("Enter noOfTestcases");
		int noOfTestcases=Integer.parseInt(sc.nextLine());
		for(int i=0;i<noOfTestcases;i++)
		{
			// System.out.println("Enter n:");
			int n=Integer.parseInt(sc.nextLine());
			// System.out.println("Enter String");
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