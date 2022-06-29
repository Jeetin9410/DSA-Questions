package IntermediateLevelQuestions.LinkedList.SingleLinkedList;

import java.util.LinkedList;

public class TraverseLinkedList {
   static class Node{
        String month;
        Node next;

        Node(String s){
            this.month = s;
            next =null;
        }
    }

    Node head;

   public void printList() {
       Node n = head;                 // creating another pointer that points towards Head(Original node)
                                      // now we will move this pointer to print the linkedList
     /*  while (n.next!=null){
           System.out.println(n.month);
           n = n.next;
       }
       */

       //  The above while loop won't print the last value. So it will print Jan to Nov.
      //   Reason : It is skipping the last node in the current state because obviously when you are at the last node
       //   then n.next ! = NULL
       //   and the loop won't execute even though the node contains a value.

       // Correct loop

       while(n!=null){
           System.out.println(n.month);
           n = n.next;
       }


   }
    public static void main(String[] args) {

        TraverseLinkedList list = new TraverseLinkedList();

        Node firstMonth = new Node("Jan");
        Node secondMonth = new Node("Feb");
        Node thirdMonth = new Node("Mar");
        Node fourthMonth = new Node("Apr");
        Node fifthMonth = new Node("May");
        Node sixthMonth = new Node("Jun");
        Node seventhMonth = new Node("Jul");
        Node eighthMonth = new Node("Aug");
        Node ninthMonth = new Node("Sept");
        Node tenthMonth = new Node("Oct");
        Node eleventhMonth = new Node("Nov");
        Node twelethMonth = new Node("Dec");

        list.head = firstMonth;

        firstMonth.next = secondMonth;
        secondMonth.next  = thirdMonth;
        thirdMonth.next =fourthMonth;
        fourthMonth.next = fifthMonth;
        fifthMonth.next = sixthMonth;
        sixthMonth.next = seventhMonth;
        seventhMonth.next = eighthMonth;
        eighthMonth.next = ninthMonth;
        ninthMonth.next = tenthMonth;
        tenthMonth.next = eleventhMonth;
        eleventhMonth.next = twelethMonth;
        twelethMonth.next = null;

        list.printList();


    }
}
