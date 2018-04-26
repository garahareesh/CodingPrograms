//Queue implementation
class Node<T>
{
	T data;
	Node next;
	public Node(T data)
	{
	this.data=data;
	this.next=null;
	}
}
class QueueImp<T>
{
	Node head;
	int index;
	public QueueImp()
	{
		head=null;
		index=0;
	} 
	public void enqueue(T e)
	{
		Node ob=new Node(e);
		if(head==null)
			head=ob;
		else{
			Node temp=head;
			while(temp.next!=null)
			{
				temp=temp.next;
			}
			temp.next=ob;
		}index++;
	}
	public void dequeue()
	{
		if(head==null)
			System.out.println("Queue is Empty");
		else{
			Node temp=head;
			head=temp.next;
		}index--;
	}
	public void display()
	{
		Node temp=head;
		if(head==null)
			System.out.println("[]");
		else{System.out.print("[");
			while(temp!=null){
			if(temp.next!=null)System.out.print(temp.data+",");
			if(temp.next==null)System.out.print(temp.data+"]");
			temp=temp.next;}
		}
	}
	public boolean isEmpty()
	{
		if(head==null)
			return true;
		return false;
	}
	public int size()
	{
		return index;
	}
	public static void main(String[] args) {
		QueueImp queue=new QueueImp();
		queue.enqueue("First");
		queue.enqueue("In");
		queue.enqueue("First");
		queue.enqueue("Out");
		queue.display();
		queue.dequeue();
		queue.display();
	}
}