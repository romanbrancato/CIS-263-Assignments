package com.company;

class SingleOrDoubleLinkedList {

    Node head;
    Node tail;

    static class Node {

        int data;
        Node next;
        Node prev;

        Node(int d) {
            data = d;
            next = null;
            prev = null;
        }
    }

    public static SingleOrDoubleLinkedList insertSingle(SingleOrDoubleLinkedList list, int data) {
        //create node
        Node newNode = new Node(data);

        //if list is empty, new node is head
        if (list.head == null) {
            list.head = newNode;
        } else {
            //else go to last node and make it head
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }

            //insert node at last node
            last.next = newNode;
        }
        return list;
    }

    public static SingleOrDoubleLinkedList insertDouble(SingleOrDoubleLinkedList list, int data) {
        // create node with given data
        Node newNode = new Node(data);

        // if list is empty, new node is head and tail
        if (list.head == null) {
            list.head = newNode;
            list.tail = newNode;
        } else {
            //else go to last node and make it head
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }
            // Insert the node at last node
            last.next = newNode;
            newNode.prev = last;
        }
        return list;
    }

    public static void printSingleLinkedList(SingleOrDoubleLinkedList list) {
        Node currentNode = list.head;

        System.out.print("SingleLinkedList: [");

        while (currentNode != null) {
            //print node's data
            System.out.print(currentNode.data + " ");
            //move to next node
            currentNode = currentNode.next;
        }
        System.out.println("]");
    }

    public static void printDoubleLinkedList(SingleOrDoubleLinkedList list) {
        Node currentNode = list.head;

        System.out.print("DoubleLinkedList: [");

        while (currentNode != null) {
            //print current node data
            System.out.print(currentNode.data + " ");
            //move to next node
            currentNode = currentNode.next;
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        SingleOrDoubleLinkedList singleLinkedList = new SingleOrDoubleLinkedList();
        SingleOrDoubleLinkedList doubleLinkedList = new SingleOrDoubleLinkedList();

        singleLinkedList = insertSingle(singleLinkedList, 3);
        singleLinkedList = insertSingle(singleLinkedList, 5);
        singleLinkedList = insertSingle(singleLinkedList, 7);
        singleLinkedList = insertSingle(singleLinkedList, 9);
        singleLinkedList = insertSingle(singleLinkedList, 11);
        singleLinkedList = insertSingle(singleLinkedList, 13);

        doubleLinkedList = insertDouble(doubleLinkedList, 3);
        doubleLinkedList = insertDouble(doubleLinkedList, 5);
        doubleLinkedList = insertDouble(doubleLinkedList, 7);
        doubleLinkedList = insertDouble(doubleLinkedList, 9);
        doubleLinkedList = insertDouble(doubleLinkedList, 11);
        doubleLinkedList = insertDouble(doubleLinkedList, 13);

        printSingleLinkedList(singleLinkedList);
        printDoubleLinkedList(doubleLinkedList);

    }
}

