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
class GeneralizedQueue<T>
{
	Node head;
	int index;
	public GeneralizedQueue()
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
	public T delete(int k)
	{
		T res=null;
		if(k>index)
			throw new IllegalArgumentException("wrong input");
		if(k==1)
		{
			Node temp=head;
			res=(T)temp.data;
			head=temp.next;
			index--;
			return res;
		}
		Node temp=head;
		Node prev=null;
		int n=0;
		while(temp.next!=null && n<k-1)
		{
			prev=temp;
			temp=temp.next;
			n++;
		}
		if(n==k-1)
		{
			res=(T)temp.data;
			prev.next=temp.next;
			index--;
			return res;
		}return res;
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
		}System.out.println();
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
		GeneralizedQueue queue=new GeneralizedQueue();
		// queue.enqueue("First");
		// queue.enqueue("In");
		// queue.enqueue("First");
		// queue.enqueue("Out");
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.display();
		// System.out.println(queue.delete(0));
		// System.out.println(queue.delete(5));
		// System.out.println(queue.delete(1));
		queue.display();
		// System.out.println(queue.delete(2));
		// System.out.println(queue.delete(4));
		// System.out.println(queue.delete(2));
		// System.out.println(queue.delete(2));
		try{
		System.out.println(queue.delete(2));
		System.out.println(queue.delete(2));
		System.out.println(queue.delete(3));
	} catch(Exception e){
		System.out.println(e);
	}

		
		// queue.dequeue();
		queue.display();
	}
}