import java.util.*;
class Merge3Way
{
	int count;
	Merge3Way(int n){
		this.count=n;
	}
	int[] divide(int[] arr)
	{
		if(arr.length<2)
		{
			return arr;
		}
		else if(arr.length==2)
		{
			if(arr[0]>arr[1]){
				int temp=arr[0];
				arr[0]=arr[1];
				arr[1]=temp;
			}
			return arr;
		}

		int j=0,k=0;
		int mid=arr.length/count;
		if(arr.length<count)
		{
			mid =1;
		}
		int[] left=new int[mid];
		int[] middle=new int[mid];
		int[] right=new int[arr.length-2*mid];
		int[] arr1=new int[left.length+middle.length];
		int[] arr2=new int[arr1.length+right.length];
		for(int i=0;i<mid;i++)
		{
			left[i]=arr[i];
		}
		for(int i=mid;i<2*mid;i++)
		{
			middle[j++]=arr[i];
		}
		for(int i=2*mid;i<arr.length;i++)
		{
			right[k++]=arr[i];
		}
		left=divide(left);
		middle=divide(middle);
		arr1=conquer(left,middle);
		// System.out.println(Arrays.toString(right));
		right=divide(right);
		arr2=conquer(arr1,right);
		return arr2;
	}
	int[] conquer(int[] arr1,int[] arr2)
	{
		int[] arr=new int[arr1.length+arr2.length];
		int i=0,j=0,k=0;
		while(i<arr1.length && j<arr2.length)
		{
			if(arr1[i]<arr2[j])
			{
				arr[k++]=arr1[i];
				i++;
			}
			else
			{
				arr[k++]=arr2[j];
				j++;
			}
		}
		while(i<arr1.length)
		{
			arr[k++]=arr1[i++];
		}
		while(j<arr2.length)
		{
			arr[k++]=arr2[j++];
		}
		return arr;
	}
	public static void main(String[] args) {
		int s=5;
		Merge3Way m=new Merge3Way(2);
		int[] a={6,2,-2,10,5,-3666};
		System.out.println(Arrays.toString(m.divide(a)));
	}
}



