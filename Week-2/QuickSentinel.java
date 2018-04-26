class QuickSentinel
{
	int []arr;
	QuickSentinel(int []arr)
	{
		this.arr=arr;
	}

	public void sort(int []a)
	{
		int max=0;
		int index = 0;
		for(int i=0;i<a.length-1;i++)
		{
			// for(int j=i+1;j<a.length;j++)
			// {
				if(greater(a[i],max)){
					max=a[i];
					index = i;
				}

			// }
			// System.out.println(max);
			// display(a);
		}
		// System.out.println(max);


		// T temp=a[0];
		// a[0]=a[min];
		// a[min]=temp;
		display(a);
		exch(a,a.length-1,index);
		// display(a);
		// dis(a);

		sort(a,0,a.length-2);
	}

	public boolean greater(int v,int w)
	{
		return v>=w;
	}

	public void sort(int []a,int lo,int hi)
	{
		if(hi<=lo) return;
		int j=partition(a,lo,hi);
		sort(a,lo,j-1);
		sort(a,j+1,hi);
	}

	public int partition(int []a,int lo,int hi)
	{
		int i=lo,j=hi+1;
		int pivot=a[lo];
		while(true)
		{
			while(less(a[++i],pivot))
			{
				// if(i==hi) break;
			}

			while(less(pivot,a[--j]))
			{
				// if(j==lo) break;
			}

			if(i>=j)
				break;
			exch(a,i,j);
		}display(a);
		exch(a,lo,j);
		return j;
	}

	public boolean less(int v,int w)
	{
		return v<w;
	}

	public void exch(int []a,int i,int j)
	{
		int te=a[i];
		a[i]=a[j];
		a[j]=te;
	}

	public void display(int []a)
	{
		for(int i=0;i<a.length;i++)
		{
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		int[] a = {6,2,-2,10,55,89,-53,100,-352,6};
		QuickSentinel obj = new QuickSentinel(a);
		obj.sort(a);
		obj.display(a);
	}
}