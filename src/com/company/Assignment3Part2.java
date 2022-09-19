package com.company;


class Stack {
    int stack[];
    int top;
    int size = 3;

    Stack() {
        stack = new int[size];
        top = -1;
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.stackPush(1);
        stack.stackPush(2);
        stack.stackPop();
        stack.stackPush(3);
        stack.stackPop();
        stack.stackPop();
    }

    public void stackPush(int n){
        //make sure stack is not at full capacity
        if(top < size) {
            //move top up one
            ++top;
            //set value to top
            stack[top] = n;
            System.out.println("Pushed " + n + " onto the stack");
        }
    }
    public void stackPop(){
        //make sure stack is not empty
        if(top != -1) {
            System.out.println("Popped " + stack[top]);
            //move top down one
            --top;
            if (top != -1) {
                System.out.println("Top Value on Stack: " + stack[top]);
            }else{
                System.out.println("Top = -1 Stack Empty");
            }
        }
    }

}
class Queue {
    String[] queue;
    int front;
    int behind;
    int size = 3;
    int total;

    Queue()
    {
        queue = new String[size];
        front = 0;
        behind = -1;
        total = 0;
    }

    public static void main(String[] args) {
        Queue queue = new Queue();

        queue.enqueue("A");
        queue.enqueue("B");
        queue.dequeue();
        queue.dequeue();
        queue.enqueue("C");
        queue.dequeue();
    }

    public void enqueue(String a) {
        if (total < size) {
            System.out.println("Adding " + a + " to back of queue");
            behind = (behind + 1) % size;
            queue[behind] = a;
            total++;
        }
    }
    public void dequeue() {
        if (total != 0) {
            String x = queue[front];
            System.out.println("Removing " + x + " from front of queue");
            front = (front + 1) % size;
            total--;
        }
    }
}
