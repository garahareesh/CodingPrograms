import java.util.*;

class Node<T>
{
	T data;
	Node next;
	public Node(){

	}
	public Node(T data)
	{
	this.data=data;
	this.next=null;
	}
}
class StackImp<T>
{
	Node head;
	int index;
	public StackImp()
	{
		head=null;
		index=0;
	}
	public void push(T e)
	{
		Node ob=new Node(e);
		if(head==null)
			head=ob;
		else{
			Node temp=head;
			head=ob; 
			head.next=temp;
		}index++;
	}
	public T pop(){
			Node temp=head;
			head=head.next;
			index--;
		return (T)temp.data;
	}
	public boolean isEmpty()
	{
		if(head==null)
			return true;
		return false;
	}
	public T peek() {
        
        return (T)head.data;
    }
	public int size()
	{
		return index;
	}
	public void display()
	{
		Node temp=head;
		if(head==null)
			System.out.println("["+temp+"]");
		else{
			System.out.print("[");
			while(temp!=null)
			{
				if(temp.next!=null)
					System.out.print(temp.data+",");
				if(temp.next==null)System.out.print(temp.data+"]");
				temp=temp.next;
			}
		}
	}
}
class method{
	StackImp <Integer> valstack;
	StackImp <Character> opstack;
	method(){
		valstack=new StackImp <Integer>();
		opstack=new StackImp <Character>();
	}
	int opearation(int b,int a,char c){
		int res=0;
		if(c == '*')
			res=a*b;
		else if(c == '/')
			res=a/b;
		else if(c == '+')
			res=a+b;
		else if(c == '-')
			res=a-b;
		return res;
	}
	boolean highPrecedence(char a,char b){
		if(get(a)>=get(b))
			return true;
		return false;
	}
	int get(char a){
		int r=0;
		if(a=='*' || a=='/')
			r=2;
		else if(a=='+' || a=='-')
			r=1;
		return r;
	}
	public void infix(String s){
		for(int i=0;i<s.length();i++){
			String str="";
			if(Character.getNumericValue(s.charAt(i))>=0 && Character.getNumericValue(s.charAt(i))<=9){
				/*while(Character.getNumericValue(s.charAt(i))>=0 && Character.getNumericValue(s.charAt(i))<=9 && i<s.length()){
					str=str+s.charAt(i++);
				}*/
				//i--;
				valstack.push(Integer.parseInt(str));
			}
			else if(s.charAt(i)=='*' || s.charAt(i)=='/' || s.charAt(i)=='+' || s.charAt(i)=='-'){
				while(!opstack.isEmpty() && highPrecedence(opstack.peek(),s.charAt(i)) && opstack.peek()!='('){
					valstack.push(opearation(valstack.pop(),valstack.pop(),opstack.pop()));
				}
				opstack.push(s.charAt(i));
			}
			else if(s.charAt(i)=='('){
				//valstack.display();
				opstack.push(s.charAt(i));
			}
			else if(s.charAt(i)==')')
			{
				while(opstack.peek()!='('){
					valstack.push(opearation(valstack.pop(),valstack.pop(),opstack.pop()));
				}
				opstack.pop();
			}
			
		}
		while(!opstack.isEmpty()){
			valstack.push(opearation(valstack.pop(),valstack.pop(),opstack.pop()));
		}
	}
	
	void display(){
		// System.out.println("hello");
		System.out.println(valstack.pop());
	}
}
class InfixEvaluation{
	public static void main(String[] args) {
		String s="(1+1+4)";
		method ob=new method();
		ob.infix(s);
		ob.display();
	}
}