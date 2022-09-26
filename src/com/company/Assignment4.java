package com.company;

class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
        right = null;
        left = null;
    }
}
class binarySearchTree {

    Node root;

    public static void printInOrder(Node n) {
        if (n != null) {
            //"prints the key of the root of a subtree
            //between printing the values in its left subtree and printing those in its right subtree"
            printInOrder(n.left);
            System.out.print(" " + n.val);
            printInOrder(n.right);
        }
    }

    public static void printPreOrder(Node n) {
        if (n != null) {
            //"prints the root before the values in either subtree"
            System.out.print(" " + n.val);
            printPreOrder(n.left);
            printPreOrder(n.right);
        }
    }
    public static void printPostOrder(Node n) {
        if (n != null) {
            //"prints the root after the values in either subtree"
            printPostOrder(n.left);
            printPostOrder(n.right);
            System.out.print(" " + n.val);
        }
    }
    //following method referenced from https://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/
    static boolean isBinarySearchTree(Node n)
    {
        if (n == null) {
            return true;
        }

        //check if left child is greater than parent
        if (n.left != null && n.left.val > n.val) {
            return false;
        }

        //check if right node is less than parent
        if (n.right != null && n.right.val < n.val) {
            return false;
        }

        //check if either of the sides fails the tree fails
        if (!isBinarySearchTree(n.left) || !isBinarySearchTree(n.right)) {
            return false;
        }

        //else it is a binary search tree
        return true;
    }

    public static void main(String[] args) {
        binarySearchTree tree = new binarySearchTree();
        tree.root = new Node(5);
        tree.root.left = new Node(4);
        tree.root.right = new Node(6);

        tree.root.left.left = new Node(2);
        tree.root.left.left.left = new Node(1);
        tree.root.left.right = new Node(3);

        tree.root.right.right = new Node(8);
        tree.root.right.left = new Node(7);

        System.out.println("In Order: ");
        printInOrder(tree.root);
        System.out.println();

        System.out.println("Pre Order: ");
        printPreOrder(tree.root);
        System.out.println();

        System.out.println("Post Order: ");
        printPostOrder(tree.root);
        System.out.println();

        if(isBinarySearchTree(tree.root)){
            System.out.println("Is a binary search tree");
        }else{
            System.out.println("Is NOT a binary search tree");
        }
    }
}

