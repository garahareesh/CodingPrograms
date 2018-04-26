//implment ordered symbol table using Linked list
class Node
{
	String keys;
	int vals;
	Node next;
	Node(String keys, int vals)
	{
		this.keys=keys;
		this.vals=vals;
		next=null;
	}
}
public class OrderLinked
{
	Node head;
	Node tail;
	int n;
	OrderLinked()
	{
		head=null;
		tail=null;
		n=0;
	}
	public int rank(String s)
	{
		int lo=0,hi=n-1;
		while(lo<=hi)
		{
			int mid=(lo+hi)/2;
			Node temp=head;
			int i=0;
			for(;i<mid;i++)
			{
				temp=temp.next;
			}
			if(s.compareTo(temp.keys)<0)
				hi=mid-1;
			else if(s.compareTo(temp.keys)>0)
				lo=mid+1;
			else
				return mid;
		}
		return lo;
	}
	public void put(String str,int v)
	{
		Node ob=new Node(str,v);
		if(head==null)
		{
			head=ob;
			n++;
			return ;
		}
		else if(n==1)
		{
			Node t=head;
			if(t.keys.compareTo(str)>0)
			{
				head=ob;
				head.next=t;
				n++;
				return;
			}
			else
			{
				t.next=ob;
				n++;
				return;
			}
		}
		else
		{
			int i=rank(str);
			Node temp=head;
			for(int j=0;j<i-1;j++){
				temp=temp.next;
			}
			Node previous=temp;
			Node obj=temp.next;
			previous.next=ob;
			previous.next.next=obj;
			n++;
			return;
		}
	}
	public int get(String s)
	{
		int i=rank(s);
		Node temp=head;
		for(int j=0;j<i;j++)
			temp=temp.next;
		return temp.vals;
	}
	public boolean isEmpty()
	{
		return n==0;
	}
	public int size()
	{
		return n;
	}
	public String min()
	{
		return head.keys;
	}
	public String max()
	{
		Node temp=head;
		for(int i=0;i<n-1;i++)
			temp=temp.next;
		return temp.keys;
	}
	public void delete(String str)
	{
		int i=rank(str);
		System.out.println("rank in delete"+i);
		if(i==0)
		{
			head=head.next;
			return;
		}
		Node temp=head;
		for(int j=0;j<i-1;j++)
		{
			temp=temp.next;
		}
		System.out.println("in delete----"+temp.keys);
		Node previous=temp;
		previous.next=temp.next.next;
	}
	public void display()
	{
		Node temp=head;
		while(temp!=null)
		{
			System.out.println(temp.keys+" : "+temp.vals);
			temp=temp.next;
		}System.out.println();
	}
	public static void main(String[] args) {
		OrderLinked ol=new OrderLinked();
		ol.put("H",1);ol.put("A",11);ol.put("Z",3);ol.put("K",15);
		ol.put("B",2);ol.put("H",9);ol.put("C",89);ol.put("x",100);
		ol.display();
		System.out.println("get of Z.."+ol.get("Z"));
		System.out.println("get of x.."+ol.get("x"));
		System.out.println("get of A.."+ol.get("A"));
		System.out.println("max element..."+ol.max());
		// System.out.println("delete---"+ol.delete("B"));
		// ol.delete("B");
		// ol.display();
		ol.delete("A");
		ol.display();
		ol.delete("x");
		ol.display();
	}

}