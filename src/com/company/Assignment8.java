package com.company;

class minHeap {
    int[] Heap;
    int size;
    int max;

    public minHeap(int max) {
        this.max = max;
        this.size = 0;

        Heap = new int[this.max + 1];
        Heap[0] = Integer.MIN_VALUE;
    }

    //Returns the position of parent
    private int parent(int pos) {
        return pos / 2;
    }

    //swaps the position of 2 nodes
    private void swap(int fp, int sp){
        int temp;
        temp = Heap[fp];

        Heap[fp] = Heap[sp];
        Heap[sp] = temp;
    }

    //CODE REFERENCED FROM: https://www.geeksforgeeks.org/building-heap-from-array/
    //heapifies node in array
    public void heapify(int arr[], int N, int pos){
        int smallest = pos;
        int left = 2 * pos + 1;
        int right = 2 * pos + 2;

        //If left child is larger than root
        if (left < N && arr[left] < arr[smallest])
            smallest = left;

        //If right child is smaller than smallest
        if (right < N && arr[right] < arr[smallest])
            smallest = right;

        //If smallest is not root then swap nodes
        if (smallest != pos) {
            int swap = arr[pos];
            arr[pos] = arr[smallest];
            arr[smallest] = swap;

            //Recursively heapify the affected sub-tree
            heapify(arr, N, smallest);
        }
    }

    //CODE REFERENCED FROM: https://www.geeksforgeeks.org/min-heap-in-java/
    //builds heap from singular insertions
    public void insert(int element){
        if (size >= max){
            return;
        }

        Heap[++size] = element;
        int currPos = size;

        while (Heap[currPos] < Heap[parent(currPos)]){
            swap(currPos, parent(currPos));
            currPos = parent(currPos);
        }
    }
    //builds heap from array
    public void buildHeap(int arr[], int N){
        //Index of last non-leaf node
        int startPos = (N / 2) - 1;

        for (int i = startPos; i >= 0; i--) {
            heapify(arr, N, i);
        }
    }

    public void print(){
        for (int i = 1; i <= size / 2; i++) {
            System.out.print(" PARENT: " + Heap[i] + " LEFT: " + Heap[2 * i] + " RIGHT:" + Heap[2 * i + 1]);
            System.out.println();
        }
    }

    public void printArray(int arr[], int N){
        for (int i = 0; i < N; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
    }

    public static void main(String[] arg) {
        System.out.println("Min Heap Smallest To Largest Single Insertion ");
        long startTime = System.nanoTime();
        minHeap minHeap = new minHeap(6);

        minHeap.insert(1);
        minHeap.insert(2);
        minHeap.insert(3);
        minHeap.insert(4);
        minHeap.insert(5);

        long elapsedTime = System.nanoTime() - startTime;

        minHeap.print();

        System.out.println("Execution Time: " + elapsedTime + "ns");
        //////////////////////////////////////////////////////////////////////////////////
        System.out.println("Min Heap Largest to Smallest Single Insertion ");
        startTime = System.nanoTime();
        minHeap minHeap2 = new minHeap(6);

        minHeap2.insert(5);
        minHeap2.insert(4);
        minHeap2.insert(3);
        minHeap2.insert(2);
        minHeap2.insert(1);

        elapsedTime = System.nanoTime() - startTime;

        minHeap2.print();

        System.out.println("Execution Time: " + elapsedTime + "ns");
        //////////////////////////////////////////////////////////////////////////////////
        System.out.println("Min Heap Random Single Insertion ");
        startTime = System.nanoTime();
        minHeap minHeap3 = new minHeap(6);

        minHeap3.insert(4);
        minHeap3.insert(3);
        minHeap3.insert(2);
        minHeap3.insert(5);
        minHeap3.insert(1);

        elapsedTime = System.nanoTime() - startTime;

        minHeap3.print();

        System.out.println("Execution Time: " + elapsedTime + "ns");
        //////////////////////////////////////////////////////////////////////////////////
        System.out.println("Min Heap Smallest To Largest Array Insertion ");

        int[] elements = new int[]{1,2,3,4,5};
        int N = elements.length;

        startTime = System.nanoTime();

        minHeap.buildHeap(elements, N);

        elapsedTime = System.nanoTime() - startTime;

        minHeap.printArray(elements, N);
        System.out.println("Execution Time: " + elapsedTime + "ns");
        ///////////////////////////////////////////////////////////////////////////////////
        System.out.println("Min Heap Smallest To Largest Array Insertion ");

        int[] elements2 = new int[]{1,2,3,4,5};
        int N2 = elements2.length;

        startTime = System.nanoTime();

        minHeap.buildHeap(elements2, N2);

        elapsedTime = System.nanoTime() - startTime;

        minHeap.printArray(elements2, N2);
        System.out.println("Execution Time: " + elapsedTime + "ns");
        ///////////////////////////////////////////////////////////////////////////////////
        System.out.println("Min Heap Random Array Insertion ");

        int[] elements3 = new int[]{4,3,2,5,1};
        int N3 = elements2.length;

        startTime = System.nanoTime();

        minHeap.buildHeap(elements3, N3);

        elapsedTime = System.nanoTime() - startTime;

        minHeap.printArray(elements3, N3);
        System.out.println("Execution Time: " + elapsedTime + "ns");
    }
}
