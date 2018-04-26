import java.util.*;
public class Solution
{
	String [] keys;
	int [] vals;
	private int size=2;
	int len;
	Solution()
	{
		len=0;
		keys=new String[2];
		vals=new int[2];
	}
	public void resize(int capacity)
	{
		String [] temp=new String[capacity];
		int [] temp1=new int[capacity];
		temp=Arrays.copyOf(keys,capacity);
		temp1=Arrays.copyOf(vals,capacity);
	}
	public void insert(String str,int v)
	{
		if(len==keys.length)
			resize(2*keys.length);
		int r=rank(str);
		if(r<len && str.equals(keys[r]))
		{
			vals[r]=v;
			return ;
		}
		// System.out.println("in insert  "+r);
		keys[r]=str;
		vals[r]=v;
		len++;

	}
	public int size()
	{
		return len;
	}
	public String min()
	{

		return keys[0];
	}
	public String max()
	{
		return keys[len];
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
			System.out.println("wromg ip");
			return ;
		}
		for(int i=r;i<len-1;i++)
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
		}
		else
		{
			delete(keys[0]);
		}
	}
	public void deleteMax()
	{
		if(len==0)
		{
			System.out.println("Symbol table underflow error");
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
		}
		// System.out.println("in display"+s);
		// return s.substring(0,s.length()-2);
	}
	public String select(int k)
	{
		if(len==0)
			return "called select() with invalid argument: 1";
		return keys[k];
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int noOftestcases=Integer.parseInt(sc.nextLine());
		for(int i=0;i<noOftestcases;i++)
		{
			int n=Integer.parseInt(sc.nextLine());
			for(int k=0;k<n;k++)
			{
			String str=sc.nextLine();
			String ss[]=str.split(" ");
			Solution ob=new Solution();
			if(ss[0].equals("contains"))
			{
				System.out.println(ob.contains(ss[1]));
				// return;	
			}
			if(ss[0].equals("size"))
			{
				System.out.println(ob.size());
			}
			if(ss[0].equals("insert"))
			{
				ob.insert(ss[1],Integer.parseInt(ss[2]));
				// System.out.println(ob.display());
				ob.display();
				// return;	
			}
			if(ss[0].equals("min")){
				System.out.println(ob.min());
				// return;
			}
			if(ss[0].equals("max")){
				System.out.println(ob.max());
				// return;
			}
			if(ss[0].equals("select")){
				System.out.println(ob.select(Integer.parseInt(ss[1])));
				// return;
			}
			
			if(ss[0].equals("deleteMin")){
				ob.deleteMin();
				// return;
			}
			if(ss[0].equals("deleteMax")){
				ob.deleteMax();
				// return;
			}
			if(ss[0].equals("floor")){
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