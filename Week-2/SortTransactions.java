import java.util.*;
import java.text.*;
class Transaction{
	Date date;
	String id;
	float amount;
	public Transaction(Date date, String id, float amount)
	{
		this.date = date;
		this.id = id;
		this.amount = amount;
	}

	public String toString()
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String s = dateFormat.format(date);
		return s = s+","+id+","+amount;
	}
}
public 	class SortTransactions{
		ArrayList<Transaction> a = new ArrayList<Transaction>();
		public void addTransaction(Transaction t)
		{
			a.add(t);
		}
		public void sortTransactionUsingInsertionSort()
		{
			for(int i=0;i<a.size();i++)
			{
				for(int j=i;j>0;j--)
				{
					if(a.get(j).date.compareTo(a.get(j-1).date)<0)
					{
						Transaction p=a.get(j);
						Transaction q=a.get(j-1);
						a.set(j-1,p);
						a.set(j,q);
					}
				}
			}
	}
	public void display()
	{
		for(int i=0;i<a.size();i++)
		{
			System.out.print(a.get(i)+"   ");
		}System.out.println();
	}
	public static void main(String[] args) {
		SortTransactions st = new SortTransactions();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try
		{
			st.addTransaction(new Transaction(sdf.parse("12/10/2016"),"Grossery",10.08f));
			st.addTransaction(new Transaction(sdf.parse("15/10/2012"),"Grossery",60.08f));
			st.addTransaction(new Transaction(sdf.parse("13/10/2011"),"Grossery",30.08f));
			st.addTransaction(new Transaction(sdf.parse("16/10/2010"),"Grossery",40.08f));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		st.sortTransactionUsingInsertionSort();
		st.display();
	}
}
