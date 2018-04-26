//implementing dequeue sort
class Node
{
	int num;
	Node next;
	public Node(int num,next)
	{
		this.num=num;
		this.next=null;
	}
}
class queue
{
	Node head;
	int n;
	public queue()
	{
		head=null;
		n=0;
	}
	public void enqueue(int element)
	{
		Node ob=new Node(element);
		if(head!=null)
			head.next=ob;
		head=ob;
	}
	public int dequeue()
	{
		if(head==null)
			System.out.println("empty");
		int temp=head.data;
		head=head.next;
		return temp;		
	}
}
public class dequeueSort
{
	queue q;
	public dequeueSort()
	{
		q=new queue();
	}
	public void sort()
	{
		if(q.head.num>q.head.next.num)
		{
			Node temp=head;
			Node ob=head.next;
			
		}
	}
}