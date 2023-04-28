package AdvanceLevelQuestions.LinkedList;

public class AddTwoNumbers {
    /*
    You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.



Example 1:


Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]


Constraints:

The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.

     */

    public static void main(String[] args) {

        /*  Tricky points in this question :
        1) we can make final answer LinkedList to start with 0, and then add all the sum we calculate in the process.
        2) the while condition...i,e head1!=null || head2!=null will give wrong answer ,it is an edge case as well
           why? suppose maximum size between these list is m,
           so acc to above condition the loop will run till there only. and if the carry at the last position is suppose 1
           then that will be exculded from answer.

           So we will


         */
        ListNode l1 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(3);
        ListNode l14 = new ListNode(1);
        ListNode l15 = new ListNode(1);
        l1.next = l12;
        l12.next = l13;
        l13.next = l14;
        l14.next = l15;

        ListNode l2 = new ListNode(5);
        ListNode l22 = new ListNode(6);
        ListNode l23 = new ListNode(4);
        l2.next = l22;
        l22.next = l23;

        ListNode head1 = l1;
        ListNode head2 = l2;

        int carry = 0;
        ListNode ans = new ListNode(0);
        ListNode start = ans,temp = ans;
        while(head1!=null || head2!=null || carry!=0){
            int digit1 = (head1 == null)?0:head1.val;
            int digit2 = (head2 == null)?0:head2.val;

            System.out.println(digit1+ " "+digit2);

            int sum = digit1 + digit2 + carry;
            if(sum > 9){
               // carry = 1;
                int rem = sum % 10;
                carry = sum / 10;
                temp.next = new ListNode(rem);
                temp = temp.next;
            }else{
                carry = 0;
             //   System.out.println(sum);
                temp.next = new ListNode(sum);
                temp = temp.next;
            }

            if(head1!=null){
                head1 = head1.next;
            }
            if(head2!=null){
                head2 = head2.next;
            }
        }

        ListNode head3 = start.next;
        while (head3!=null){
            System.out.println(head3.val);
            head3 = head3.next;
        }

    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

