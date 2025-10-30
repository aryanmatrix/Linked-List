package com.aryan.theorycode;

import org.w3c.dom.Node;

public class DLL {

     private Node head;



    public void insertAtFirst(int value){
        Node node = new Node(value);
        node.next = head;
        node.prev = null;
        if(head != null)
        {
            head.prev = node;
        }
        head = node;
    }


    public void display(){
        Node node = head;
        Node last = null;
        while (node != null){
            System.out.print(node.value + " -> ");
            last = node;
            node = node.next;
        }
        System.out.println("End");

        System.out.println("Print in Reverse");

        while (last  != null){
            System.out.print(last.value + " -> " );
            last = last.prev;
        }

        System.out.println("Start");

    }

  public void insertLast(int val){
        Node node = new Node(val);
        Node last = head;
         node.next = null;

        if(head == null){
            node.prev = null;
            head = node;
            return;
        }

        while (last.next != null){
            last = last.next;
        }

        last.next = node;
        node.prev = last;
        last = node;

  }
    public Node find(int value) {
        Node node = head;
        while (node != null) {
            if (node.value == value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

  public void insert(int after, int val){
        Node p = find(after);

        if(p == null){
            System.out.println("Does not Exist");
            return;
        }
        Node node = new Node(val);
        node.next = p.next;
        p.next = node;
        node.prev = p;
        if(node.next != null){
            node.next.prev = node;
        }

  }

    private class Node{
        private int value;
        private Node next;
        private Node prev;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node prev, Node next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }
}
