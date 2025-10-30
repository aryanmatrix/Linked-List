package com.aryan.theorycode;

public class LL {

    private  Node head;
    private  Node tail;
    private int size ;

    public LL() {
        this.size = 0;
    }

    public void insertFirst(int value){
        Node node  = new Node(value);
        node.next = head;
        head = node;
        if(tail==null){
            tail=head;
        }

        size += 1;
    }
    public  int delete(int index){
          if(index == 0){
             return deleteAtFirst();
          }
          if(index == size -1){
              return deleteLast();
          }
           Node prev = get(index-1);
          int val = prev.next.value;

          prev.next = prev.next.next;

          return val;
    }
    public int deleteLast(){
       if(size <= 1){
           return deleteAtFirst();
       }
       Node secondLast = get(size-2);
       int val = tail.value;
       tail = secondLast;
       tail.next = null;

       return val;
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

    public  Node get(int index)
    {
        Node node = head;
        for(int i=0; i<index; i++)
        {
            node = node.next;
        }
        return  node;
    }


    public int deleteAtFirst(){
//        Node temp = head;
//            head = temp.next;
//            temp = null;
        int val = head.value;
        head = head.next;
        if(head == null){
            tail = null;
        }
            size--;
        return val;
    }

    public void display(){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("End");

    }
    public void insertAtPosition(int val,int index){
        if(index == 0){
            insertFirst(val);
            return;
        }
        if(index == size)
        {
            insertLast(val);
            return;
        }
        Node temp = head;
        for(int i =1; i< index ;i++){
            temp = temp.next;
        }

        Node node = new Node(val,temp.next);
        temp.next = node;
        size++;


    }

    public void insertLast(int val){
        if(tail == null){
            insertFirst(val);
            return;
        }
        Node node = new Node( val);
        tail.next = node ;
        tail = node;
        size++;
    }

    private class Node{
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

    }



    //Questions

    public void  removeDublicates(){
        Node node = head;
          while(node.next != null){
              if(node.value == node.next.value){
                  node.next = node.next.next;
                  size--;
              }
              else{
                  node = node.next;
              }
          }
          tail = node;
          tail.next = null;
    }

    //merge

    public static  LL  merge(LL first , LL second){
        Node f = first.head;
        Node s = second.head;

        LL ans  = new LL();

        while(f!=null && s!=null){
            if(f.value < s.value){
                ans.insertLast(f.value);
                f = f.next;
            }
            else{
                ans.insertLast(s.value);
                s = s.next;
            }

        }

        while ( f != null){
            ans.insertLast(f.value);
            f = f.next;
        }

        while ( s != null){
            ans.insertLast(s.value);
            s = s.next;
        }

        return  ans;
    }



    //Checking Cycle




    public static void main(String[] args) {
//        LL list = new LL();
//
//        list.insertLast(1);
//        list.insertLast(1);
//        list.insertLast(2);
//        list.insertLast(4);
//        list.insertLast(4);
//
//        list.display();
//        list.removeDublicates();
//        list.display();


        LL first = new LL();
        LL second = new LL();

        first.insertLast(1);
        first.insertLast(3);
        first.insertLast(5);

        second.insertLast(1);
        second.insertLast(2);
        second.insertLast(9);
        second.insertLast(14);

        LL result  = LL.merge(first,second);
        result.display();


    }

}
