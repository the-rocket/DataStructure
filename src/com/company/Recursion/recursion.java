package com.company.Recursion;

import org.omg.CORBA.Object;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

public class recursion {

    private static Scanner scanner;
    private static int n;
    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        n = scanner.nextInt();
        if (n == 1)
            System.out.print(1);
        else
        if (n == 2)
            System.out.print("1 1");
        else {
            LinkedList<Integer> row = new LinkedList<>();
            row.addAll(Arrays.asList(1,1));
            System.out.print(PascalRecursion(2,row));
        }

    }

    private static String PascalRecursion(int line, LinkedList<Integer> row) {
        if (line == n) {
            return row.toString();
        }
        for (int i = 0; i < row.size()-1; ++i) {
            row.set(i, row.get(i)+row.get(i+1));
        }
        row.addFirst(1);
        return PascalRecursion(line+1, row);
    }

}
