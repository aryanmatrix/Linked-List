package com.aryan.learnig;


import java.util.ArrayList;
import java.util.Collections;

class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
    }

}

public class LinkedList {

     public static Node mergeTwoSortedLL(Node x, Node y){

//         ArrayList<Integer> list = new ArrayList<>();
//
//         while(x != null){
//             list.add(x.data);
//             x = x.next;
//         }
//         while( y != null){
//             list.add(y.data);
//             y = y.next;
//         }
//         Collections.sort(list);
//
//         Node dummy =  new Node(-1);
//         Node temp = dummy;
//
//
//         Node nn = new Node(list.get(0));
//         dummy.next = nn;
//         temp = temp.next;
//
//         for(int i=1; i<list.size(); i++){
//             Node new_node = new Node(list.get(i));
//             temp.next = new_node;
//             temp = temp.next;
//         }
//         return dummy.next;


         Node dummy = new Node(-1);
         Node temp = dummy;

         while(x != null && y!=null){

             if(x.data <= y.data){
                 temp.next = x;
                 x = x.next;
             }
             else {
                 temp.next =y;
                 y =y.next;
             }

             temp = temp.next;
         }

         if(x!=null){
             temp.next = x;

         }
         if(y!=null){
             temp.next = y;

         }

         return dummy.next;
     }

    public static   Node insertAtFirst(Node head ,int val){

        Node new_Node = new Node(val);

        if(head == null){
            return new_Node;
        }

        new_Node.next = head;

        head = new_Node;

        return head;
    }

    public static Node insertAtKthNode(Node head , int k, int val){

        Node new_Node = new Node(val);

        if (k <= 0) {
            System.out.println("Invalid position");
            return head;
        }
        if (k == 1) {
            new_Node.next = head;
            return new_Node;
        }
        Node temp = head;
        for(int i=1; i<k-1  && temp != null; i++){
          temp = temp.next;
        }

        if (temp == null) return head;

        new_Node.next = temp.next;
        temp.next =new_Node;

        return head;
    }

    public  static Node deleteKthNode(Node head, int k){
        if(head == null){
            return null;
        }
        if(k == 1){
            head = head.next;
        }
        Node temp =  head;

            for(int i=0; i<k-2; i++){
                if(temp.next == null){
                    System.out.println("Please enter a valid k");
                    return head;
                }
                temp = temp.next;
            }


        if (temp.next != null) {
            temp.next = temp.next.next;
        }
        return head;
    }

    public static Node deleteHead(Node head){

        if(head == null){
            return null;
        }
        head = head.next;

        return  head;
    }

    public  static Node  deleteTail(Node head){

        if(head == null || head.next ==null){
            return null;
        }

        Node temp =head;

        while(temp.next.next != null){
            temp = temp.next;
        }

        temp.next = null;

        return head;
    }

    public static boolean search(Node head , int val){

        Node temp = head;

        while(temp != null){
            if(temp.data == val){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public static  Node convertArrayToLL(int[] arr){
        Node head = new Node(arr[0]);
        Node temp = head;

        for(int i =1; i<arr.length; i++){
            Node nn = new Node(arr[i]);
            temp.next = nn;
            temp = temp.next;
        }
        return head;
    }


    public static void  transverse(Node head){

        Node temp = head;

        while( temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println(" ");
    }

    public  static  int countTotalNodes(Node head){

        int count =0;
        Node temp = head;

        while(temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }
    public static void main(String[] args) {

//        Node p = new Node(89);
//        System.out.println(p);
//        System.out.println(p.data);
//        System.out.println(p.next);

        int[] arr = {1,3,5,9};

        Node head = convertArrayToLL(arr);

        int[] arr1 = {1,2,4,10};
        Node head1 = convertArrayToLL(arr1);

       Node merge = mergeTwoSortedLL(head,head1);
//        System.out.println(head.data);
//        System.out.println(head.next.data);
       // transverse(head);
        transverse(merge);

        int c = countTotalNodes(head);
        System.out.println(c);

        Boolean b = search(head ,15);
        System.out.println(b);

       // head = deleteHead(head);

        //head = deleteTail(head);


       // head = deleteKthNode(head,18);

//        head = insertAtFirst(head,79);
//        transverse(head);

        head = insertAtKthNode(head,3,69);
        transverse(head);

    }
}
