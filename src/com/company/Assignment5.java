package com.company;

class rbNode {
    int val;
    rbNode left;
    rbNode right;
    rbNode parent;
    //RED = false BLACK = true
    boolean color;

    public rbNode(int val) {
        this.val = val;
    }
}
class redBlackTree {

    rbNode root;

    public void rightRotate(rbNode n) {
        //get parent node
        rbNode p = n.parent;
        //get left child
        rbNode left = n.left;

        //set node's left child to its left's right child
        n.left = left.right;
        if (left.right != null) {
            left.right.parent = n;
        }
        //set the left child's right node to n
        left.right = n;
        //set nodes parent to its left child
        n.parent = left;

        replaceParentsChild(p, n, left);
    }

    public void leftRotate(rbNode n) {
        //get parent node
        rbNode p = n.parent;
        //get right child
        rbNode rightC = n.right;

        //set node's right child to its right's left child
        n.right = rightC.left;
        if (rightC.left != null) {
            rightC.left.parent = n;
        }
        //set the right child's left node to n
        rightC.left = n;
        //set nodes parent to its right child
        n.parent = rightC;

        replaceParentsChild(p, n, rightC);
    }

    //sets the parent-child relationships between the parent node of the former root node of the rotated subtree and its new root node
    public void replaceParentsChild(rbNode p, rbNode oC, rbNode nC) {
        if (p == null) {
            root = nC;
            //if the parent node's left child is the same as the old child, then set it to the new child
        } else if (p.left == oC) {
            p.left = nC;
            //if the parent node's right child is teh same as the old child, then set it to the new child
        } else if (p.right == oC) {
            p.right = nC;
        }
        if (nC != null) {
            nC.parent = p;
        }
    }

    public void rbInsert(int val) {
        rbNode n = root;
        rbNode p = null;

        //traverse tree to correct position based on key
        while (n != null) {
            p = n;
            if (val < n.val) {
                n = n.left;
            } else if (val > n.val) {
                n = n.right;
            } else {
                throw new IllegalArgumentException("Duplicate Value: " + val);
            }
        }

        //Insert the new node
        rbNode newNode = new rbNode(val);
        newNode.color = false;
        //if it has no parent then set it to root
        if (p == null) {
            root = newNode;
        //if key is less than the parent's value then set the new node to the left child
        } else if (val < p.val) {
            p.left = newNode;
        //else set it to the right child
        } else {
            p.right = newNode;
        }
        //set the new nodes parent relationship
        newNode.parent = p;

        rbInsertFixUp(newNode);
    }

    //FOLLOWING METHOD IS REFERENCED FROM https://www.happycoders.eu/algorithms/red-black-tree-java/
    //As I had difficulty understanding all the possible cases and what to do
    public void rbInsertFixUp(rbNode n) {
        rbNode p = n.parent;

        //Case 1: Parent is null, reached the root, the end of the recursion
        if (p == null) {
            return;
        }
        if (p.color == true) {
            return;
        }
        //set grandparent node
        rbNode gp = p.parent;

        //Case 2: Not having a grandparent means that parent is the root. If we enforce black roots
        //(rule 2), grandparent will never be null, and the following if-then block can be
        //removed.
        if (gp == null) {
            p.color = true;
            return;
        }
        //get the uncle node
        rbNode uncle = getUncleNode(p);

        //Case 3: Uncle is red -> recolor parent, grandparent and uncle
        if (uncle != null && uncle.color == false) {
            p.color = true;
            gp.color = false;
            uncle.color = true;

            rbInsertFixUp(gp);
        }

        //Parent is left child of grandparent
        else if (p == gp.left) {
            // Case 4a: Uncle is black and node is left->right "inner child" of its grandparent
            if (n == p.right) {
                leftRotate(p);
                p = n;
            }

            //Case 5a: Uncle is black and node is left->left "outer child" of its grandparent
            rightRotate(gp);

            //Recolor original parent and grandparent
            p.color = true;
            gp.color = false;
        }

        //Parent is right child of grandparent
        else {
            // Case 4b: Uncle is black and node is right->left "inner child" of its grandparent
            if (n == p.left) {
                rightRotate(p);
                p = n;
            }
            // Case 5b: Uncle is black and node is right->right "outer child" of its grandparent
            leftRotate(gp);

            //Recolor original parent black and grandparent red
            p.color = true;
            gp.color = false;
        }
    }

    public rbNode getUncleNode(rbNode p) {
        //get grandparent node
        rbNode gp = p.parent;
        if (gp.left == p) {
            return gp.right;
        } else if (gp.right == p) {
            return gp.left;
        } else {
            throw new IllegalStateException("Parent is not a child of its grandparent");
        }
    }

    public static void printPreOrder(rbNode n) {
        if (n != null) {
            //"prints the root before the values in either subtree"
            System.out.print(" " + n.val);
            if(n.color == true){
                System.out.print("B");
            }else{
                System.out.print("R");
            }
            printPreOrder(n.left);
            printPreOrder(n.right);
        }
    }

    public static void main(String[] args) {
        redBlackTree tree = new redBlackTree();
        tree.rbInsert(26);
        tree.rbInsert(17);
        tree.rbInsert(41);
        tree.rbInsert(14);
        tree.rbInsert(21);
        tree.rbInsert(30);
        tree.rbInsert(47);
        tree.rbInsert(10);
        tree.rbInsert(16);
        tree.rbInsert(19);
        tree.rbInsert(23);
        tree.rbInsert(28);
        tree.rbInsert(38);
        tree.rbInsert(7);
        tree.rbInsert(12);
        tree.rbInsert(15);
        tree.rbInsert(20);
        tree.rbInsert(35);
        tree.rbInsert(39);
        tree.rbInsert(3);

        printPreOrder(tree.root);
    }
}
