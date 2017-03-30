package com.company.LinkedList;

//data-structure linkedlist
import java.util.*;

public class LinkedList<AnyType> implements Iterable<AnyType>
{
    private Node<AnyType> head;

    /**
     *  Constructs an empty list
     */
    public LinkedList()
    {
        head = null;
    }
    /**
     *  Returns true if the list is empty
     *
     */
    public boolean isEmpty()
    {
        return head == null;
    }
    /**
     *  Inserts a new node at the beginning of this list.
     *
     */
    public void addFirst(AnyType item)
    {
        head = new Node<AnyType>(item, head);
    }
    /**
     *  Returns the first element in the list.
     *
     */
    public AnyType getFirst()
    {
        if(head == null) throw new NoSuchElementException();

        return head.data;
    }
    /**
     *  Removes the first element in the list.
     *
     */
    public AnyType removeFirst()
    {
        AnyType tmp = getFirst();
        head = head.next;
        return tmp;
    }
    /**
     *  Inserts a new node to the end of this list.
     *
     */
    public void addLast(AnyType item)
    {
        if( head == null)
            addFirst(item);
        else
        {
            Node<AnyType> tmp = head;
            while(tmp.next != null) tmp = tmp.next;

            tmp.next = new Node<AnyType>(item, null);
        }
    }
    /**
     *  Returns the last element in the list.
     *
     */
    public AnyType getLast()
    {
        if(head == null) throw new NoSuchElementException();

        Node<AnyType> tmp = head;
        while(tmp.next != null) tmp = tmp.next;

        return tmp.data;
    }
    /**
     *  Returns a string representation
     *
     */
    public String toString()
    {
        StringBuffer result = new StringBuffer();
        for(Object x : this)
            result.append(x + " ");

        return result.toString();
    }
    /**
     *  Inserts a new node after a node containing the key.
     *
     */
    public void insertAfter(AnyType key, AnyType toInsert)
    {
        Node<AnyType> tmp = head;

        while(tmp != null && !tmp.data.equals(key)) tmp = tmp.next;

        if(tmp != null)
            tmp.next = new Node<AnyType>(toInsert, tmp.next);
    }
    /**
     *  Inserts a new node before a node containing the key.
     *
     */
    public void insertBefore(AnyType key, AnyType toInsert)
    {
        if(head == null) return;

        if(head.data.equals(key))
        {
            addFirst(toInsert);
            return;
        }

        Node<AnyType> prev = null;
        Node<AnyType> cur = head;

        while(cur != null && !cur.data.equals(key))
        {
            prev = cur;
            cur = cur.next;
        }
        //insert between cur and prev
        if(cur != null)
            prev.next = new Node<AnyType>(toInsert, cur);
    }
    /**
     *  Removes the first occurrence of the specified element in this list.
     *
     */
    public void remove(AnyType key)
    {
        if(head == null)
            throw new RuntimeException("cannot delete");

        if( head.data.equals(key) )
        {
            head = head.next;
            return;
        }

        Node<AnyType> cur  = head;
        Node<AnyType> prev = null;

        while(cur != null && !cur.data.equals(key) )
        {
            prev = cur;
            cur = cur.next;
        }

        if(cur == null)
            throw new RuntimeException("cannot delete");

        //delete cur node
        prev.next = cur.next;
    }


    /*******************************************************
     *
     *  The Node class
     *
     ********************************************************/
    private static class Node<AnyType>
    {
        private AnyType data;
        private Node<AnyType> next;

        public Node(AnyType data, Node<AnyType> next)
        {
            this.data = data;
            this.next = next;
        }
    }

    /*******************************************************
     *
     *  The Iterator class
     *
     ********************************************************/

    public Iterator<AnyType> iterator()
    {
        return new LinkedListIterator();
    }

    private class LinkedListIterator  implements Iterator<AnyType>
    {
        private Node<AnyType> nextNode;

        public LinkedListIterator()
        {
            nextNode = head;
        }

        public boolean hasNext()
        {
            return nextNode != null;
        }

        public AnyType next()
        {
            if (!hasNext()) throw new NoSuchElementException();
            AnyType res = nextNode.data;
            nextNode = nextNode.next;
            return res;
        }

        public void remove() { throw new UnsupportedOperationException(); }
    }
}