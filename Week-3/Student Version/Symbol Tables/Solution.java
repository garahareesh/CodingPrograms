import java.util.*;
public class Solution
{
	String [] keys;
	int [] vals;
	// private int size=2;
	int len;
	Solution()
	{
		len=0;
		keys=new String[100];
		vals=new int[100];
	}
	// public void resize(int capacity)
	// {
	// 	String [] temp=new String[capacity];
	// 	int [] temp1=new int[capacity];
	// 	temp=Arrays.copyOf(keys,capacity);
	// 	temp1=Arrays.copyOf(vals,capacity);
	// 	this.keys=temp;
	// 	this.vals=temp1;
	// }
	public void insert(String str,int v)
	{
		// if(len>=keys.length)
		// 	resize(2*keys.length);
		int r=rank(str);

		if(r<len && str.equals(keys[r]))
		{
			vals[r]=v;
			return ;
		}
		// System.out.println("in insert  "+r);
		for(int j=len;j>r;j--)
		{
			keys[j]=keys[j-1];
			vals[j]=vals[j-1];
		}
		keys[r]=str;
		vals[r]=v;
		len++;
		// System.out.println(Arrays.toString(keys));

	}
	public int size()
	{
		return len;
	}
	public String min()
	{
		// System.out.println(len);
		return keys[0];
	}
	public String max()
	{
		// System.out.println(len);
		return keys[len-1];
	}
	public int rank(String str)
	{
		int lo=0;int hi=len-1;
		while(lo<=hi)
		{
			int mid=(lo+hi)/2;
			int cmp=str.compareTo(keys[mid]);
			if(cmp>0) lo=mid+1;
			else if(cmp<0) hi=mid-1;
			else 
				return mid;
		}
		return lo;
	}
	public boolean contains(String str)
	{
		for(int i=0;i<len;i++)
		{
			if(keys[i].equals(str))
				return true;
		}
		return false;
	}
	public void delete(String str)
	{
		int r=rank(str);
		if(r==len || keys[r].compareTo(str)!=0){
			System.out.println("Symbol table underflow error");
			return ;
		}
		for(int i=r;i<len;i++)
		{
			keys[i]=keys[i+1];
			vals[i]=vals[i+1];
		}

		keys[len-1]=null;
		vals[len-1]=0;
		len--;
		
	}
	public void deleteMin()
	{
		if(len==0)
		{
			System.out.println("Symbol table underflow error");
			return; 
		}
		else if(len==1)
		{

			delete(keys[0]);
			System.out.println("Symbol table underflow error");
			return;
		}
		else
			delete(keys[0]);
	}
	public void deleteMax()
	{
		// System.out.println("heyyyyy");
		if(len==0)
		{
			System.out.println("Symbol table underflow error");
			return;
		}
		else
		{
			delete(keys[len-1]);
		}
	}
	public String floor(String str)
	{
		int r=rank(str);
		if(len==0)
			return null;
		if(keys[r].compareTo(str)==0)
			return keys[r];
		if(r==0) return null;
		else 
			return keys[r-1];
	}
	public String ceiling(String str)
	{
		int r=rank(str);
		if(len==0)
			return null;
		if(keys[r].compareTo(str)==0)
			return keys[r];
		if(r==len)
			return null;
		else
			return keys[r];
	}
	public void display()
	{
		if(len==0) return;
		if(len==1)
		{
			System.out.println(keys[0]);
			return;
		} 
		for(int i=0;i<len;i++)
		{
			if(i<len-1)
				System.out.print(keys[i]+", ");
			else if(i==len-1)
				System.out.print(keys[i]);
		}System.out.println();
		// System.out.println("in display"+s);
		// return s.substring(0,s.length()-2);
	}
	public String select(int k)
	{
		if(size()==0 || k>=size()){
			String s="called select() with invalid argument: 1";
			return s;
		}
		return keys[k];
	}
	public static void main(String[] args) {
		// Solution ob=new Solution();
		// System.out.println(ob.contains("hello"));
		// ob.insert("hello",5);
		// ob.display();
		// System.out.println(ob.min());
		// System.out.println(ob.max());
		
		// System.out.println(ob.select(1));
		// ob.deleteMin();
		// ob.deleteMin();
		// ob.deleteMax();
		// System.out.println(ob.floor("hello"));
		// System.out.println(ob.ceiling("hello"));
		

		Scanner sc=new Scanner(System.in);
		int noOftestcases=Integer.parseInt(sc.nextLine());
		for(int i=0;i<noOftestcases;i++)
		{
			Solution ob=new Solution();
			int n=Integer.parseInt(sc.nextLine());
			for(int k=0;k<n;k++)
			{
			String str=sc.nextLine();
			String ss[]=str.split(" ");
			
			if(ss[0].equals("contains"))
			{
				System.out.println(ob.contains(ss[1]));
				// return;	
			}
			else if(ss[0].equals("size"))
			{
				System.out.println(ob.size());
			}
			else if(ss[0].equals("insert"))
			{
				ob.insert(ss[1],Integer.parseInt(ss[2]));
				// System.out.println(ob.display());
				ob.display();
				// return;	
			}
			else if(ss[0].equals("min")){
				System.out.println(ob.min());
				// return;
			}
			else if(ss[0].equals("max")){
				System.out.println(ob.max());
				// return;
			}
			else if(ss[0].equals("select")){
				System.out.println(ob.select(Integer.parseInt(ss[1])));
				// return;
			}
			
			else if(ss[0].equals("deleteMin")){
				ob.deleteMin();
				ob.display();
				// return;
			}
			else if(ss[0].equals("deleteMax")){
				ob.deleteMax();
				ob.display();
				// return;
			}
			else if(ss[0].equals("floor")){
				System.out.println(ob.floor(ss[1]));
				// return;
			}
			if(ss[0].equals("ceiling")){
				System.out.println(ob.ceiling(ss[1]));
				// return;
			}
			
		}
		}
	}
}