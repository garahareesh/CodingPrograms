//implement symbol table using Arrays
import java.util.*;
public class ArrayST
{
	String[] keys;
	int[] val;
	int init_size=4;
	int count=0;
	public ArrayST()
	{
		keys=new String[init_size];
		val=new int[init_size];
	}
	public void resize(int capacity)
	{
		String [] temp=new String[capacity];
		int [] temp1=new int[capacity];
		temp=Arrays.copyOf(keys,capacity);
		temp1=Arrays.copyOf(val,capacity);
		this.keys=temp;
		this.val=temp1;
	}
	public void put(String s,int k)
	{
		if(count>=keys.length)
			resize(2*keys.length);
		if(count==0)
		{
			keys[count]=s;
			val[count]=k;
			count++;
			return ;
		}
		else
		{
			for(int i=0;i<count;i++)
			{
				if(keys[i].equals(s)){
					val[i]=k;
					return ;
				}
			}
		}
		keys[count]=s;
		val[count]=k;
		count++;
	}
	public int get(String k)
	{
		if(k.equals(null))
			System.out.println("wrong ip");
		for(int i=0;i<count;i++)
		{
			if(keys[i].equals(k))
				return val[i];
		}
		return 0;
	}
	public boolean contains(String k)
	{
		if(k.equals(null))
			System.out.println("wrong ip");
		for(int i=0;i<count;i++)
		{
			if(keys[i].equals(k))
				return true;
		}
		return false;
	}
	public boolean isEmpty()
	{
		return count==0;
	}
	public void display()
	{
		for(int i=0;i<count;i++)
		{
			System.out.println(keys[i]+"--->"+val[i]);
		}
	}
	public static void main(String[] args) {
		ArrayST ob=new ArrayST();
		ob.put("e",0);ob.put("a",1);ob.put("s",2);ob.put("y",4);
		ob.display();
		System.out.println("contains s is "+ob.contains("s"));
		System.out.println("contains a is "+ob.contains("a"));
		System.out.println("contains s is "+ob.contains("r"));
		System.out.println("get of y : "+ob.get("y"));
		System.out.println("get of a : "+ob.get("a"));
		System.out.println("get of e : "+ob.get("e"));
	}

}