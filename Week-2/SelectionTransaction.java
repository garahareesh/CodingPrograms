//implementing Selection Sort Transactions
import java.util.*;
class Transaction
{
	String item;
	Double amount;
	public Transaction(String item,Double amount)
	{
		this.item=item;
		this.amount=amount;
	}
	public String toString()
	{
		String s="";
		return s+item+": "+amount;
	}
}
public class SelectionTransaction
{
	ArrayList<Transaction>t=new ArrayList<Transaction>();
	public SelectionTransaction(){}
	public void addTransaction(Transaction a)
	{
		t.add(a);
	}
	public void sort()
	{
		int n=t.size();
		for(int i=0;i<n;i++)
		{
			int min=i;
			for(int j=i+1;j<n;j++)
			{
				if(less(t.get(j).amount,t.get(min).amount))
					min=j;
			}
			exch(t,i,min);
		}
	}
	public boolean less(Comparable a,Comparable b)
	{
		return a.compareTo(b)<1;
	}
	public void exch(ArrayList t,int a,int b)
	{
		Transaction p=(Transaction)t.get(a);
		Transaction q=(Transaction)t.get(b);
		t.set(b,p);
		t.set(a,q);
	}
	public void display()
	{
		for(int i=0;i<t.size();i++)
		{
			System.out.print(t.get(i)+"  ");
		}System.out.println();
	}
	public static void main(String[] args) {
		Transaction ob=new Transaction("pen",10.0);
		Transaction ob3=new Transaction("pencil",5.0);Transaction ob1=new Transaction("book",25.0);Transaction ob2=new Transaction("Slate",45.5);
		SelectionTransaction st=new SelectionTransaction();
		st.addTransaction(ob);
		st.addTransaction(ob1);
		st.addTransaction(ob2);
		st.addTransaction(ob3);
		st.sort();
		st.display();
	}
}