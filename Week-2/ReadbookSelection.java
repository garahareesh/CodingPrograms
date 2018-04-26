//implementing readbook
import java.util.*;
import java.text.*;
class Readbook
{
	String book;
	int kb;
	Time time;
	public Readbook(String book,int kb,Time time)
	{
		this.book=book;
		this.kb=kb;
		this.time=time;
	}
	public String toString()
	{
		String s="";
		return s+book+":"+kb+"--"+time;
	}
	public int compareTo(Readbook rb)
	{
		if(this.time>rb.time) return 1;
		else if(this.time<rb.time) return -1;
		else if(this.time==rb.time)
		{
			if(this.kb>rb.kb) return 1;
			else if(this.kb<rb.kb) return -1;
		} return 0;
	}
}
public class ReadbookSelection
{
	ArrayList<Readbook> aa=new ArrayList<Readbook>();
	public ReadbookSelection(){}
	public  void addReadbook(Readbook r)
	{
		aa.add(r);
	}
	public void sort()
	{
		int n=aa.size();
		for(int i=0;i<n;i++)
		{
			int min=i;
			for(int j=i+1;j<n;j++)
			{
				if(aa.get(i).compareTo(aa.get(min))<1)
					min=j;
			}exch(aa,i,min);
		}
	}
	public void exch(ArrayList aa,int i,int j)
	{
		Readbook p=(Readbook)aa.get(i);
		Readbook q=(Readbook)aa.get(j);
		aa.set(j,p);
		aa.set(i,q);
	}
	public static void main(String[] args) {
		ReadbookSelection rs=new ReadbookSelection();

	}
}