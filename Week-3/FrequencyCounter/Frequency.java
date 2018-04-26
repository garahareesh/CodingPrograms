//implement Frequency Counter
import java.util.*;
import java.io.*;
public class Frequency
{
	ArrayST st;
	int n;
	int words;
	int distinct;
	Frequency()
	{
		words=0;
		distinct=0;
		n=0;
		st=new ArrayST();
	}
	public void counter(String str)
	{
		// System.out.println(""+str);
		if(n==0)
		{
			st.put(str,1);
			n++;
			words++;
			distinct++;
			return ;
		}
		else
		{words++;
			for(int i=0;i<n;i++)
			{
				if(st.keys[i].equals(str)){
					st.val[i]+=1;
					return ;
				}
			}
		}
		st.put(str,1);
		distinct++;

		n++;
	}
	public String maximum()
	{
		System.out.println("words..."+words+"  "+"distinct..."+distinct);
		String str="";
		int k=0;
		for(int i=0;i<st.count;i++)
		{
			if(st.val[i]>k){
				k=st.val[i];
				str=st.keys[i];
			}
		}
		return str;
	}
	public void insertion()
	{
		for(int i=0;i<st.count;i++)
		{
			for(int j=i;j>0 && st.val[j]<st.val[j-1];j--)
			{
				exch(j,j-1);
			}
		}
	}
	public void exch(int a,int b)
	{
		int temp=st.val[a];
		st.val[a]=st.val[b];
		st.val[b]=temp;

		String te=st.keys[a];
		st.keys[a]=st.keys[b];
		st.keys[b]=te;

	}
	public void display()
	{
		// System.out.println(Arrays.toString(st.val));
		// System.out.println(Arrays.toString(st.keys));
		st.display();
	}
	public static void main(String[] args) {
		Frequency f=new Frequency();
		// f.counter("I");f.counter("am");f.counter("am");f.counter("HAreesh");f.counter("HAreesh");
		// f.display();
		
		try
		{
			File file=new File("in.txt");
			Scanner sc=new Scanner(file);
				// Scanner sc1=new Scanner(sc.nextLine());
				while(sc.hasNext())
				{
					f.counter(sc.next());
				}
				
			// }
			f.display();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		System.out.println("maximum Frequency is: "+ f.maximum());
		f.insertion();
		f.display();	
	}
}