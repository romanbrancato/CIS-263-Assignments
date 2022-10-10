package com.company;

class BTree{
    //minimum degree
    int T;

    bNode root;

    class bNode{
        //# of keys currently stored by node
        int n;
        char key[] = new char[2 * T - 1];
        bNode childNode[] = new bNode[2 * T];
        boolean isLeaf = true;
    }

    public BTree(int t){
        T = t;
        root = new bNode();
        root.n = 0;
        root.isLeaf = true;
    }

    //FOLLOWING CODE IS REFERENCED FROM https://www.programiz.com/dsa/insertion-into-a-b-tree
    public void splitChild(bNode x, int pos, bNode y){
        //create node z and "give it the largest t - 1 keys and corresponding t children of y"
        bNode z = new bNode();
        z.isLeaf = y.isLeaf;
        z.n = T - 1;
        for(int j = 0; j < T - 1; j++){
            z.key[j] = y.key[j + T];
        }
        if(y.isLeaf != true){
            for(int j = 0; j < T; j++){
                z.childNode[j] = y.childNode[j + T];
            }
        }
        //adjust key count
        y.n = T - 1;
        for(int j = x.n; j >= pos + 1; j--){
            x.childNode[j + 1] = x.childNode[j];
        }
        x.childNode[pos + 1] = z;

        for(int j = x.n - 1; j >= pos; j--){
            x.key[j + 1] = x.key[j];
        }
        x.key[pos] = y.key[T - 1];
        x.n = x.n + 1;
    }

    //FOLLOWING CODE IS REFERENCED FROM https://www.programiz.com/dsa/insertion-into-a-b-tree
    public void insertKey(char key){
        //handle the case in which the root node r is full: the root splits and a new node s (having two children) becomes the root
        bNode r = root;
        if(r.n == 2 * T - 1){
            bNode s = new bNode();
            root = s;
            s.isLeaf = false;
            s.n = 0;
            s.childNode[0] = r;
            splitChild(s, 0, r);
            insertNonFull(s, key);
        }else{
            insertNonFull(r, key);
        }
    }

    //FOLLOWING CODE IS REFERENCED FROM https://www.programiz.com/dsa/insertion-into-a-b-tree
    public void insertNonFull(bNode x, char k){
        //handle the case in which x is a leaf node by inserting key k into x.
        if(x.isLeaf == true){
            int i;
            for(i = x.n - 1; i >= 0 && k < x.key[i]; i--){
                x.key[i + 1] = x.key[i];
            }
            x.key[i + 1] = k;
            x.n = x.n + 1;
            //If x is not a leaf node, then we must insert k into the appropriate leaf node in the subtree rooted at internal node x
        }else{
            int i;
            for(i = x.n - 1; i >= 0 && k < x.key[i]; i--){
            }
            i++;
            bNode tmp = x.childNode[i];
            //detects whether the recursion would descend to a full child
            if(tmp.n == 2 * T - 1){
                splitChild(x, i, tmp);
                if(k > x.key[i]){
                    i++;
                }
            }
            insertNonFull(x.childNode[i], k);
        }
    }

    public static void printTree(bNode x){
        for(int i = 0; i < x.n; i++){
            System.out.print(x.key[i] + " ");
        }
        if(x.isLeaf != true){
            for(int i = 0; i < x.n + 1; i++){
                printTree(x.childNode[i]);
            }
        }
    }

    public static void main(String[] args){
        BTree btree2 = new BTree(2);
        btree2.insertKey('a');
        btree2.insertKey('b');
        btree2.insertKey('c');
        btree2.insertKey('d');
        btree2.insertKey('e');
        btree2.insertKey('f');
        btree2.insertKey('g');
        btree2.insertKey('h');
        btree2.insertKey('i');
        btree2.insertKey('j');
        btree2.insertKey('k');
        btree2.insertKey('l');
        btree2.insertKey('m');
        btree2.insertKey('n');
        btree2.insertKey('o');
        btree2.insertKey('p');
        btree2.insertKey('q');
        btree2.insertKey('r');
        btree2.insertKey('s');
        btree2.insertKey('t');
        btree2.insertKey('u');
        btree2.insertKey('v');
        btree2.insertKey('w');
        btree2.insertKey('x');
        btree2.insertKey('y');
        btree2.insertKey('z');

        System.out.println("When T = " + btree2.T);
        printTree(btree2.root);

        BTree btree3 = new BTree(3);

        btree3.insertKey('a');
        btree3.insertKey('b');
        btree3.insertKey('c');
        btree3.insertKey('d');
        btree3.insertKey('e');
        btree3.insertKey('f');
        btree3.insertKey('g');
        btree3.insertKey('h');
        btree3.insertKey('i');
        btree3.insertKey('j');
        btree3.insertKey('k');
        btree3.insertKey('l');
        btree3.insertKey('m');
        btree3.insertKey('n');
        btree3.insertKey('o');
        btree3.insertKey('p');
        btree3.insertKey('q');
        btree3.insertKey('r');
        btree3.insertKey('s');
        btree3.insertKey('t');
        btree3.insertKey('u');
        btree3.insertKey('v');
        btree3.insertKey('w');
        btree3.insertKey('x');
        btree3.insertKey('y');
        btree3.insertKey('z');

        System.out.println();
        System.out.println("When T = " + btree3.T);
        printTree(btree3.root);
    }
}