package com.company.Queues;
import java.util.*;


public class QueueADT
{
    protected int Queue[] ;
    protected int front, rear, size, len;


    public QueueADT(int n)
    {
        size = n;
        len = 0;
        Queue = new int[size];
        front = -1;
        rear = -1;
    }

    public boolean isEmpty()
    {
        return front == -1;
    }


    public int size()
    {
        return len ;
    }

    public int first()
    {
        if (isEmpty())
            throw new NoSuchElementException("Underflow Exception");
        return Queue[front];
    }

    public void enqueue(int i)
    {
        if (rear == -1)
        {
            front = 0;
            rear = 0;
            Queue[rear] = i;
        }
        else if (rear + 1 >= size)
            throw new IndexOutOfBoundsException("Overflow Exception");
        else if ( rear + 1 < size)
            Queue[++rear] = i;
        len++ ;
    }

    public int dequeue()
    {
        if (isEmpty())
            throw new NoSuchElementException("Underflow Exception");
        else
        {
            len-- ;
            int ele = Queue[front];
            if ( front == rear)
            {
                front = -1;
                rear = -1;
            }
            else
                front++;
            return ele;
        }
    }
    /*  Displaying the Queue status */
    public void display()
    {
        System.out.print("\nQueue = ");
        if (len == 0)
        {
            System.out.print("Empty\n");
            return ;
        }
        for (int i = front; i <= rear; i++)
            System.out.print(Queue[i]+" ");
        System.out.println();
    }
}