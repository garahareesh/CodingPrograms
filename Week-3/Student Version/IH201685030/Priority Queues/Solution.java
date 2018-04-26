import java.util.*;
class Solution
{
	int [] pq;
	int n;
	Solution(int size)
	{
		pq=new int[size];
		n=pq.length;
	}
	public void insert(int [] aa)
	{
		this.pq=aa;
		// System.out.println(Arrays.toString(pq));
	}
	public boolean greater(int a,int b)
	{
		return pq[a]>pq[b];
	}
	// public void exch(int a,int b)
	// {
	// 	int temp=pq[a];
	// 	pq[a]=pq[b];
	// 	pq[b]=temp;
	// }
	// public void swim(int k)
	// {
	// 	while(k>1 && greater(k/2,k))
	// 	{
	// 		exch(k/2,k);
	// 		k=k/2;
	// 	}
	// }
	public void isMin()
	{
		int k=0;
		while(k<n)
		{
			int j=2*k+1;
			if(j<n && greater(j,j+1))
				j++;
			if(j<n && greater(k,j))
			{
				System.out.println("false.");
				return;
			}
			k=j;
		}
		System.out.println("true.");
		return;
	}
	public static void main(String[] args) {
		// Solution ob=new Solution(5);
		// ob.insert(5);ob.insert(4);ob.insert(3);ob.insert(2);ob.insert(1);
		// ob.isMin();
		Scanner sc=new Scanner(System.in);
		int noOfTestcases=Integer.parseInt(sc.nextLine());
		for(int k=0;k<noOfTestcases;k++)
		{
			int n=Integer.parseInt(sc.nextLine());
			String str=sc.nextLine();
			String [] ss=str.split(", ");
			int [] arr=new int[ss.length];
			Solution ob=new Solution(arr.length);
			for(int i=0;i<arr.length;i++)
			{
				arr[i]=Integer.parseInt(ss[i]);
			}
			ob.insert(arr);
			ob.isMin();
			if(sc.hasNextLine())
			{
				sc.nextLine();
				System.out.println();
			}
		}
	}
}