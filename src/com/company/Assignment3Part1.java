package com.company;

class SingleOrDoubleLinkedList {

    Node head;

    static class Node {

        int data;
        Node next;
        Node prev;

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

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

        // if list is empty, new node is head
        if (list.head == null) {
            list.head = newNode;
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

        //swapping nodes

        int key1 = 9;
        int key2 = 11;

        System.out.println("After Swapping " + key1 + " and " + key2);

        ////////////////////////////////////////FOR SINGLE LINKED LIST
        Node singleCurrNode1 = singleLinkedList.head;
        Node singlePrev1 = null;
        Node singleCurrNode2 = singleLinkedList.head;
        Node singlePrev2 = null;
        //searching for node with key1
        while(singleCurrNode1.data != key1 && singleCurrNode1 != null){
            singlePrev1 = singleCurrNode1;
            singleCurrNode1 = singleCurrNode1.next;
        }
        //searching for node with key2
        while(singleCurrNode2.data != key2 && singleCurrNode2 != null){
            singlePrev2 = singleCurrNode2;
            singleCurrNode2 = singleCurrNode2.next;
        }
        //swapping next pointers of nodes
        singlePrev1.next = singleCurrNode2;
        singlePrev2.next = singleCurrNode1;
        Node singleTemp = singleCurrNode1.next;
        singleCurrNode1.next = singleCurrNode2.next;
        singleCurrNode2.next=singleTemp;

        printSingleLinkedList(singleLinkedList);

        ////////////////////////////////////////FOR DOUBLE LINKED LIST

        Node doubleCurrNode1 = doubleLinkedList.head;
        Node doublePrev1 = null;
        Node doubleCurrNode2 = doubleLinkedList.head;
        Node doublePrev2 = null;
        //searching for node with key1
        while(doubleCurrNode1.data != key1 && doubleCurrNode1 != null){
            doublePrev1 = doubleCurrNode1;
            doubleCurrNode1 = doubleCurrNode1.next;
        }
        //searching for node with key2
        while(doubleCurrNode2.data != key2 && doubleCurrNode2 != null){
            doublePrev2 = doubleCurrNode2;
            doubleCurrNode2 = doubleCurrNode2.next;
        }
        //swapping pointers of nodes
        doublePrev1.next = doubleCurrNode2;
        doublePrev2.next = doubleCurrNode1;
        Node doubleTemp = doubleCurrNode1.next;
        doubleCurrNode1.next = doubleCurrNode2.next;
        doubleCurrNode2.next=doubleTemp;

        printDoubleLinkedList(doubleLinkedList);







    }
}

