import java.lang.Iterable;
import java.lang.*;
import java.util.*;
import java.io.*;


public class Stack1<Item> {
    private Node<Item> first;     
    private int n;                

    
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }
    public Stack1() {
        first = null;
        n = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public void push(Item item) {
        Node<Item> oldfirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldfirst;
        n++;
    }

    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item = first.item;        
        first = first.next;            
        n--;
        return item;                   
    }

    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        return first.item;
    }
    public void display()
    {
        Node temp=first;
        while(temp.next!=null)
        {
            System.out.println(temp.item);
            temp=temp.next;
        }
        System.out.println(temp.item);
    }

    public static void main(String[] args) {
        Stack1 s= new Stack1();
         s.push(1);
         s.push(2);
         s.push(3);
         s.push(3);
         s.push(4);
         s.push("sffd");

        
        
    }
}
