//weighted QuickUnion adding new Method
import java.util.*;
public class WeightedQU
{
	private int[] parent;
	private int [] size;
	private int count;
	int k;
	public WeightedQU()
	{
		count=0;
		k=1;
		parent=new int[1];
		size=new int[1];
		parent[0]=0;
		size[0]=1;

	}
	public boolean connected(int p,int q)
	{
		return find(p)==find(q);
	}
	public int find(int p)
	{
		if(validate(p)){;
		while(p!=parent[p])
			p=parent[p];
		}
		return p;
	}
	public int count()
	{
		return count;
	}
	public void union(int p,int q)
	{
		newSite(p,q);
		// System.out.println(Arrays.toString(parent));
		// System.out.println(Arrays.toString(size));
		int rootP=find(p);
		int rootQ=find(q);
		if(rootP==rootQ){
		 return ;
		}
		if(size[rootP]<size[rootQ])
		{
			parent[rootP]=rootQ;
			size[rootQ]+=size[rootP];
		}
		else
		{
			parent[rootQ]=rootP;
			size[rootP]+=size[rootQ];
		}count++;
		System.out.println(Arrays.toString(parent));
	}
	public boolean validate(int p)
	{
		int n=parent.length;
		if(p<0 || p>=n)
		{
			throw new IndexOutOfBoundsException("index " + p + " is not between 0 and " + (n-1));
		}return true;
	}
	public void newSite(int p,int q)
	{
		int max=0;
		if(p<q)
			max=q;
		else
			max=p;
		if(k>max)
			max=k;
		int [] arr=new int[max+1];
		int [] arr1=new int[max+1];
		for(int i=0;i<parent.length;i++)
		{
			arr[i]=parent[i];
			arr1[i]=size[i];
		}
		for(int i=parent.length;i<arr.length;i++)
		{
			arr[i]=i;
			arr1[i]=1;
		}
		this.parent=arr;
		this.size=arr1;
		this.k=max;

	}
	public static void main(String[] args) {
		WeightedQU wqu=new WeightedQU();
		wqu.union(4,3);
		wqu.union(3,8);
		wqu.union(6,5);
		wqu.union(9,4);
		wqu.union(2,1);
		wqu.union(8,9);
		wqu.union(5,0);
		wqu.union(7,2);
		wqu.union(6,1);
		wqu.union(1,0);
		wqu.union(6,7);
	}
}