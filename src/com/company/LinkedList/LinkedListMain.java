package com.company.LinkedList;

/**
 * Created by yernar on 06/02/17.
 */

import java.util.*;

public class LinkedListMain {

    private static LinkedList<String> list;

    public static void main(String[] args)
    {
        list = new LinkedList <String>();
        list.addFirst("p");
        list.addFirst("a");
        list.addFirst("e");
        list.addFirst("h");

        System.out.println(list);

        list.addLast("s");
        Iterator itr = list.iterator();

        list.insertAfter("e", "ee");
        System.out.println(list);
        System.out.println(list.getLast());

        list.insertBefore("h", "yy");
        System.out.println(list);

        list.remove("p");
        System.out.println(list);
    }
}
