package com.company;

import java.util.Scanner;
import java.util.Stack;

public class reverse {

    static Stack<String> StackWord;
    private static Scanner scanner;
    public static void main(String[] args) {
	    scanner = new Scanner(System.in);
        StackWord = new Stack<>();
        for (int word = 1; word <= 10; word++) {
            String newWord = scanner.next();
            StackWord.push(newWord);
        }
        while (!StackWord.empty()) {
            String WordFromEnd = StackWord.pop();
            System.out.print(WordFromEnd + " ");
        }
    }
}
