//implementing readbook
import java.util.*;
import java.text.*;
class LeaderBoard
{
	String name;
	int kb;
	Double time;
	public LeaderBoard(String name,int kb,Double time)
	{
		this.name=name;
		this.kb=kb;
		this.time=time;
	}
	public String toString()
	{
		String s="";
		return s+name+":"+kb+"--"+time;
	}
	public int compareTo(LeaderBoard lb)
	{
		if(this.time>lb.time) return 1;
		else if(this.time<lb.time) return -1;
		else if(this.time==lb.time)
		{
			if(this.kb>lb.kb) return 1;
			else if(this.kb<lb.kb) return -1;
		} return 0;
	}
}
public class LeaderBoardSelection
{
	ArrayList<LeaderBoard> aa=new ArrayList<LeaderBoard>();
	public LeaderBoardSelection(){}
	public  void addLeaderBoard(LeaderBoard r)
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
				if(aa.get(j).compareTo(aa.get(min))<1)
					min=j;
			}exch(aa,i,min);
		}
	}
	public void exch(ArrayList aa,int i,int j)
	{
		LeaderBoard p=(LeaderBoard)aa.get(i);
		LeaderBoard q=(LeaderBoard)aa.get(j);
		aa.set(j,p);
		aa.set(i,q);
	}
	public void display()
	{
		for(int i=0;i<aa.size();i++)
		{
			System.out.print(aa.get(i)+"  ");
		}System.out.println();
	}
	public static void main(String[] args) {
		LeaderBoardSelection ls=new LeaderBoardSelection();
		LeaderBoard ob=new LeaderBoard("kiran",100,0.55);
		LeaderBoard ob1=new LeaderBoard("Ram",200,0.55);
		LeaderBoard ob2=new LeaderBoard("John",300,0.45);
		LeaderBoard ob3=new LeaderBoard("Patel",400,2.55);
		ls.addLeaderBoard(ob);
		ls.addLeaderBoard(ob1);
		ls.addLeaderBoard(ob2);
		ls.addLeaderBoard(ob3);
		ls.sort();
		ls.display();

	}
}