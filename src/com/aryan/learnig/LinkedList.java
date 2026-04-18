package com.aryan.learnig;


class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
    }

}

public class LinkedList {

    public static   Node insertAtFirst(Node head ,int val){

        Node new_Node = new Node(val);

        if(head == null){
            return new_Node;
        }

        new_Node.next = head;

        head = new_Node;

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

        int[] arr = {8,5,4,24,89,6,4,67,8};

        Node head = convertArrayToLL(arr);
//        System.out.println(head.data);
//        System.out.println(head.next.data);
        transverse(head);

        int c = countTotalNodes(head);
        System.out.println(c);

        Boolean b = search(head ,15);
        System.out.println(b);

       // head = deleteHead(head);

        //head = deleteTail(head);


       // head = deleteKthNode(head,18);

        head = insertAtFirst(head,79);
        transverse(head);

    }
}
