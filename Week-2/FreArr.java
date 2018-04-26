import java.util.*;
public  class FreArr
{
	int [] keys;
	int [] vals;
	int size;
	int count;
	public FreArr(int m)
	{
		keys=new int[m];
		vals=new int[m];
		count=0;
		size=m;
	}
	public void put(int element)
	{
		// if(count==size)
		// 	resize(2*size);
		for(int i=0;i<count;i++)
		{
			if(keys[i]==element)
			{
				vals[i]=vals[i]+1;
				return;
			}	
		}
		keys[count]=element;
		vals[count]=1;
		count++;
		
		
	}
		public int fre()
		{
			System.out.println(Arrays.toString(keys));
			System.out.println(Arrays.toString(vals));
			int high=vals[0];
			int index=0;
			for(int i=0;i<count;i++)
			{
				if(vals[i]>high){
					high=vals[i];
					index=i;
					System.out.println("index,,,,"+index);
				}
			}
			return keys[index];
		}
		// public void resize(int size)
		// {
		// 	int [] temp=new int[size];
		// 	int [] temp1=new int[size];
		// 	temp=Arrays.copyOf(keys,keys.length);
		// 	temp1=Arrays.copyOf(vals,vals.length);
		// 	this.keys=temp;
		// 	this.vals=temp1;
		// }
		public static void main(String[] args) {
			// Scanner sc=new Scanner(System.in);
			// // int n=Integer.parseInt(sc.nextLine());
			// String str=sc.nextLine();
			// String [] ss=str.split(",");
			// int [] arr=new int[ss.length];
			// FreArr ob=new FreArr(arr.length);	
			// for(int i=0;i<arr.length;i++)
			// {
			// 	ob.put(arr[i]);
			// }	System.out.println(ob.fre()+" fre");

			FreArr ob=new FreArr(10);
			ob.put(4);ob.put(4);ob.put(1);ob.put(1);ob.put(2);
			ob.put(3);ob.put(4);ob.put(5);
			System.out.println(ob.fre());
	}
}