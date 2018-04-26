//implement Sequential search using arrays
import java.util.*;
public class SeqSearchArray
{
	String [] keys;
	int [] vals;
	private int init_size=4;
	int n;
	SeqSearchArray()
	{
		n=0;
		keys=new String[init_size];
		vals=new int[init_size];
	}
	public void resize(int capacity)
	{
		String []temp1=new String[capacity];
		int [] temp=new int[capacity];
		temp1=Arrays.copyOf(keys,capacity);
		temp=Arrays.copyOf(vals,capacity);
		this.keys=temp1;
		this.vals=temp;
	}
	public void put(String str, int v)
	{
		if(n==keys.length)
			resize(2*keys.length);
		for(int k=0;k<n;k++)
		{
			if(keys[k].compareTo(str)==0){
				vals[k]=v;
				return;
			}


		}
		int i=0;
		for(;i<n;i++)
		{
			if(keys[i].compareTo(str)>0)
				break;
		}
		for(int j=n;j>i;j--)
		{
			keys[j]=keys[j-1];
			vals[j]=vals[j-1];
		}
		keys[i]=str;
		vals[i]=v;
		n++;
	}
	public int get(String s)
	{
		for(int i=0;i<n;i++)
		{
			if(keys[i].equals(s))
				return vals[i];
		}
		return -1;
	}
	public void display()
	{
		for(int i=0;i<n;i++)
		{
			System.out.println(keys[i]+"--->"+vals[i]);
		}System.out.println();
	}
	public static void main(String[] args) {
		SeqSearchArray ob=new SeqSearchArray();
		ob.put("H",1);ob.put("A",11);ob.put("Z",3);ob.put("K",15);
		ob.put("B",2);ob.put("H",9);ob.put("C",89);ob.put("x",100);
		ob.display();
		System.out.println("get of Z"+ ob.get("Z"));
	}
}