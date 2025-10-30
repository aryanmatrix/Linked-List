package com.aryan.theorycode;


public class InterviewQuestion {

    // https://leetcode.com/problems/linked-list-cycle
    // Amazon and Microsoft
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

  //find length of the cycle

    public int lengthCycle(ListNode  head){
        ListNode slow  = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow  = slow.next;
            fast = fast.next.next;

            if(fast == slow ){

                ListNode temp = slow;
                int length =0;

                do{
                    temp = temp.next;
                    length++;
                } while (temp != slow);
                return length;
            }
        }

        return  0;
    }

   //wwwwwww
}

  class ListNode{

    int val ;
    ListNode next;

    public ListNode(){

    }

     ListNode(int x){
        val = x;
        next = null;
     }
  }
