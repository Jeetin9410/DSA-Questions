package old.IntermediateLevelQuestions.LinkedList.SingleLinkedList;

import java.util.LinkedList;
import java.util.Scanner;

public class InsertionInLinkedList {
   static class Node{
        int data;
        Node next;

        Node(int d){
            data = d;
            next = null;
        }
    }

    Node head;


   public void printList(){
       Node n = head;
       while(n!=null){
           System.out.print(n.data+" ");
           n = n.next;
       }
   }

    public static void main(String[] args) {

        System.out.println("***************** LinkedList Program *******************");

        InsertionInLinkedList list = new InsertionInLinkedList();

        Node node1 = new Node(1);

        list.head = node1;

        Node node2 = new Node(2);

        Node node3 = new Node(3);

        node1.next = node2;
        node2.next = node3;


        System.out.println("Original List");
        list.printList();

        System.out.println("\nEnter the value to be inserted at beginning");
        Scanner sc = new Scanner(System.in);

        int value = sc.nextInt();

        System.out.println("List after inserting "+value+ " at the beginning of the list");

        list.insertionAtBeginning(value);

        System.out.println("\nLength : "+ list.getListLength());

        System.out.println("\nEnter the value to be inserted at middle");
        int middle = sc.nextInt();

        list.insertionAtMiddle(middle);


        System.out.println("\nEnter the value to be inserted at end");
        int end = sc.nextInt();

        list.insertionAtEnd(end);


    }

    public void insertionAtBeginning(int value){
       Node node = new Node(value);

       node.next = head;

       head = node;

       printList();
    }

    public void insertionAtMiddle(int value){
        System.out.println("List before insertion :\n");
        printList();
       int len = getListLength();
       Node node = new Node(value);
       Node n = head;
       int count = 1;
       while(count!=(len/2)){
           count++;
           n = n.next;
       }

       node.next = n.next;
       n.next = node;

        System.out.println("List after insertion in middle :\n");

        printList();

    }

    public void insertionAtEnd(int value){
       Node n = head;
       while(n.next!=null){
           n = n.next;
       }

       Node end = new Node(value);

       n.next = end;

        System.out.println("After Insertion at end \n");

       printList();

    }

    public int getListLength(){
       int length =0;
       Node temp = head;
       while(temp!=null){
           length++;
           temp = temp.next;
       }
       return length;
    }
}
