//implement symbol table using Arrays
import java.util.*;
public class ArraySTSearch
{
	String[] keys;
	int[] val;
	int init_size=4;
	int count=0;
	public ArraySTSearch()
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
		int value=0;
		if(k.equals(null))
			System.out.println("wrong ip");
		for(int i=0;i<count;i++)
		{
			if(keys[i].equals(k)){
				value=val[i];
				self_search(i);
				// return val[i];
			}
		}
		return value;
	}
	public void self_search(int index)
	{
		String [] temp=new String[count];
		int [] arr=new int[count];
		if(index==0)
			return ;
		int j=1;
		for(int i=0;i<index;i++)
		{
			temp[j]=keys[i];
			arr[j]=val[i];
			j++;
		}
		for(int k=index+1;k<count;k++)
		{
			temp[j]=keys[k];
			arr[j]=val[k];
			j++;
		}
		temp[0]=keys[index];
		arr[0]=val[index];
		this.keys=temp;
		this.val=arr;
	}
	public void delete(String str)
	{
		if(str.equals(null)){
			System.out.println("wrong ip:");
			return;
		}
		for(int i=0;i<count;i++)
		{
			if(keys[i].equals(str))
			{
				keys[i]=keys[count-1];
				val[i]=val[count-1];
				keys[count-1]=null;
				val[count-1]=-1;
				count--;
				return;
			}
		}

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
		}System.out.println();
	}
	public static void main(String[] args) {
		ArraySTSearch ob=new ArraySTSearch();
		ob.put("e",0);ob.put("a",1);ob.put("s",2);ob.put("y",4);
		ob.display();
		// System.out.println("contains s is "+ob.contains("s"));
		// System.out.println("contains a is "+ob.contains("a"));
		// System.out.println("contains s is "+ob.contains("r"));
		// System.out.println("get of y : "+ob.get("y"));
		// ob.display();
		// System.out.println("get of a : "+ob.get("a"));
		// ob.display();
		// System.out.println("get of e : "+ob.get("e"));
		// ob.display();
		// System.out.println("get of e : "+ob.get("e"));
		// ob.display();
		ob.delete("e");
		ob.display();
	}

}