package com.aryan.theorycode;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
//        LL list = new LL();
//        list.insertFirst(20);
//        list.insertFirst(34);
//        list.insertFirst(56);
//        list.insertFirst(5);
//        list.insertFirst(70);
//        list.insertLast(45);
//        list.display();
//        list.insertAtPosition(13,4);
//        list.display();
//
//        System.out.println("Delete at First");
//        System.out.println(list.deleteAtFirst());
//        list.display();
//        System.out.println(list.deleteLast());
//        list.display();
//        System.out.println(list.delete(4));
//        list.display();

        DLL list1 = new DLL();
        list1.insertAtFirst(34);
        list1.insertAtFirst(38);
        list1.insertAtFirst(87);
        list1.insertAtFirst(99);
        list1.display();
        list1.insertLast(89);
        list1.display();
        list1.insert(87,101);
        list1.display();


        CLL list = new CLL();
        list.insert(23);
        list.insert(3);
        list.insert(19);
        list.insert(75);
        list.display();
        list.delete(19);
        list.display();




    }
}
