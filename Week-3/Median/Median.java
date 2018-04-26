import java.util.*;
public class Median
{
	MaxPq maxpq;
	MinPq minpq;
	double median;
	Median(int x)
	{
		maxpq=new MaxPq(x);
		minpq=new MinPq(x);
		median=0.0;
	}
	public double add(double element)
	{
		if(minpq.size()==0 && maxpq.size()==0)
			minpq.insert(element);
		else if(minpq.size()-maxpq.size()==1 && element>=median)
		{
			maxpq.insert(minpq.delMin());
			minpq.insert(element);
		}
		else if(minpq.size()-maxpq.size()==1 && element<median)
			maxpq.insert(element);
		else if(maxpq.size()-minpq.size()==1 && element>=median)
			minpq.insert(element);
		else if(maxpq.size()-minpq.size()==1 && element<median)
		{
			minpq.insert(maxpq.delMax());
			maxpq.insert(element);
		}
		else if(minpq.size()==maxpq.size() && element<median)
			maxpq.insert(element);
		else
			minpq.insert(element);
		if((minpq.size()+maxpq.size())%2==0)
			median=((double)maxpq.pq[1]+(double)minpq.pq[1])/2.0;
		else if(maxpq.size()>minpq.size())
			median=(double)maxpq.pq[1];
		else
			median=(double)minpq.pq[1];
		return median;
	}
	public double delete()
	{
		if(minpq.size()==0 && maxpq.size()==0){
			System.out.println("No elements are found");
			return 0.0;
		}
		else if(minpq.size()>maxpq.size() && minpq.size()==1)
		{
			minpq.delMin();
			return 0.0;
		}
		else if(maxpq.size()>minpq.size() && maxpq.size()==1)
		{
			maxpq.delMax();
			return 0.0;
		}
		else if(minpq.size()>maxpq.size())
		{
			minpq.delMin();
			median=((double)minpq.pq[1]+(double)maxpq.pq[1])/2.0;
		}
		else if(maxpq.size()>minpq.size())
		{
			maxpq.delMax();
			median=((double)minpq.pq[1]+(double)maxpq.pq[1])/2.0;
		}
		else if(minpq.size()==maxpq.size())
		{
			if((double)minpq.pq[1].compareTo((double)maxpq.pq[1])<0)
			{
				minpq.delMin();
				median=(double)maxpq.pq[1];
			}
			else
			{
				maxpq.delMax();
				median=(double)minpq.pq[1];
			}
		}
		return median;
	}
	public void display()
	{
		maxpq.display();
		minpq.display();
	}
	public static void main(String[] args) {
		Median m=new Median(4);
		m.add(5);
		m.add(6);
		m.add(1);
		m.add(4);
		System.out.println("Median ---"+m.add(3));
		// System.out.println("delete----"+m.delete());
		m.display();
	}
}
