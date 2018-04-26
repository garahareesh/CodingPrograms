import java.util.*;
class Solution<T extends Comparable<T>>
{
	T [] a;
	Solution()
	{
		// this.a=array;
	}
	// public void sort(T [] a)
	// {
	// 	sort(a,0,a.length-1);
	// }
	public T[] divide(T [] a)
	{
		// T [] a=new T[a.length];
		if(a.length<2)
			return a;
		if(a.length==2)
		{
			if(a[0].compareTo(a[1])>0)
			{
				T temp=a[0];
				a[0]=a[1];
				a[1]=temp;
			}
			return a;
		}
		int mid=a.length/3;
		// System.out.println("mid.."+mid);
		T [] left=(T[])new Comparable[mid];
		T [] middle=(T[])new Comparable[mid];
		T [] right=(T[])new Comparable[a.length-2*mid];
		T [] arr1=(T[])new Comparable[left.length+middle.length];
		T [] arr2=(T[])new Comparable[arr1.length+right.length];
		int k=0,r=0;
		for(int i=0;i<mid;i++)
		{
			left[i]=a[i];
		}
		for(int j=mid;j<2*mid;j++)
		{
			middle[k++]=a[j];
		}
		for(int s=2*mid;s<a.length;s++)
		{
			right[r++]=a[s];
		}
		left=divide(left);
		middle=divide(middle);
		arr1=conquer(left,middle);
		right=divide(right);
		arr2=conquer(arr1,right);
		this.a=arr2;
		return arr2;
	}
	public T[] conquer(T [] a,T [] b)
	{
		T [] aa=(T[])new Comparable[a.length+b.length];
		int i=0,j=0,k=0;
		while(i<a.length && j<b.length)
		{
			if(a[i].compareTo(b[j])<0)
			{
				aa[k++]=a[i];
				i++;
			}
			else
			{
				aa[k++]=b[j];
				j++;
			}
		}
		while(i<a.length)
			aa[k++]=a[i++];
		while(j<b.length)
			aa[k++]=b[j++];
		return aa;
	}
	public void display()
	{
		// System.out.println(Arrays.toString(a));
		// if(a.length==0)
		// 	return ;
		// else
		// {
		System.out.print("[");
		for(int i=0;i<a.length;i++)
		{
			
			if(i<a.length-1)
				System.out.print(a[i]+", ");
			if(i==a.length-1)
				System.out.print(a[i]+"]");
		}System.out.println();
		// }
	}
	public static void main(String[] args) {
		// Comparable [] a={1,10,100,1001,-1};
		// Solution ob=new Solution();
		
		// ob.divide(a);
		// ob.display();
		Scanner sc=new Scanner(System.in);
		int n=Integer.parseInt(sc.nextLine());
		for(int i=0;i<n;i++)
		{
			Solution ob=new Solution();
			String str=sc.nextLine();
				String [] ss=str.split(", ");
				Comparable[] aa=new Comparable[ss.length];
				for(int j=0;j<ss.length;j++)
				{
					aa[j]=ss[j];
				}
				
				ob.divide(aa);
				ob.display();
				if(sc.hasNextLine()){
					sc.nextLine();

				System.out.println();
				}		
			
		}
	}
}
