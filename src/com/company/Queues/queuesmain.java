package com.company.Queues;

/**
 * Created by Daniyar on 15/02/17.
 */

import java.util.*;

public class queuesmain {

    protected static String[] operations = {"Queue Operations", "Enqueue", "Dequeue", "First", "isEmpty", "Size",
            "Print the operation number :"};

    static int size = 0;
    private static Scanner scan = new Scanner(System.in);

    public static Queue myQueue;


    private static void QueueOnCreate() {
        myQueue = new Queue(size);
    }

    public static void main(String args[]) {
        System.out.println("How many numbers would you like to insert into the Queue");
        size = scan.nextInt();
        QueueOnCreate();
        while (size > 0) {
            query();
            int number = scan.nextInt();
            makemyoperationof(number);
            if (!asktocontinue())
                break;
        }
    }

    private static void makemyoperationof(int number) {
        switch (number) {
            case 1:
                myQueue.enqueue(say());
                myQueue.display();
                break;
            case 2:
                myQueue.dequeue();
                myQueue.display();
                break;
            case 3:
                System.out.println(String.format("%d", myQueue.first()));
                break;
            case 4:
                System.out.println(String.format("%b", myQueue.isEmpty()));
                break;
            case 5:
                System.out.println(String.format("%d", myQueue.size()));
                break;
        }
    }

    protected static boolean asktocontinue() {
        System.out.println("Do you want to continue (type y or n)");
        char ch = scan.next().charAt(0);
        return ch == 'y' ? true : false;

    }

    protected static int say() {
        System.out.println("Enter Integer Element to insert");
        return scan.nextInt();
    }

    protected static void query() {
        for (int i = 0; i < 7; ++i) {
            if (i > 0 && i < 6)
                System.out.println(String.format("%d_ %s", i,operations[i]));
            else
                System.out.println(operations[i]);
        }

    }


    //Default class
    static class Queue {
        protected int Queue[];
        protected int front, rear, size, len;


        public Queue(int n) {
            size = n;
            len = 0;
            Queue = new int[size];
            front = -1;
            rear = -1;
        }

        public boolean isEmpty() {
            return front == -1;
        }


        public int size() {
            return len;
        }

        public int first() {
            if (isEmpty())
                throw new NoSuchElementException("Underflow Exception");
            return Queue[front];
        }

        public void enqueue(int i) {
            if (rear == -1) {
                front = 0;
                rear = 0;
                Queue[rear] = i;
            } else if (rear + 1 >= size)
                throw new IndexOutOfBoundsException("Overflow Exception");
            else if (rear + 1 < size)
                Queue[++rear] = i;
            len++;
        }

        public int dequeue() {
            if (isEmpty())
                throw new NoSuchElementException("Underflow Exception");
            else {
                len--;
                int ele = Queue[front];
                if (front == rear) {
                    front = -1;
                    rear = -1;
                } else
                    front++;
                return ele;
            }
        }

        /*  Displaying the Queue status */
        public void display() {
            System.out.print("\nQueue = ");
            if (len == 0) {
                System.out.print("Empty\n");
                return;
            }
            for (int i = front; i <= rear; i++)
                System.out.print(Queue[i] + " ");
            System.out.println();
        }
    }

}