package com.company.Tree;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author isaid, daniyar
 */
import java.util.*;

public class TreeTraversal {

    static class Node<T> {
        T value;
        Node<T> left;
        Node<T> right;

        Node(T value) {
            this.value = value;
        }

        void visit() {
            System.out.print(this.value + " ");
        }
    }

    static enum ORDER {
        PREORDER, LEVELORDER, INORDER, POSTORDER
    }

    static void traverse(Node<?> node, ORDER order) {
        if (node == null) {
            return;
        }
        switch (order) {
            case PREORDER:
                node.visit();
                traverse(node.left, order);
                traverse(node.right, order);
                break;

            case LEVELORDER:
                Queue<Node<?>> queue = new LinkedList<>();
                queue.add(node);
                while(!queue.isEmpty()){
                    Node<?> next = queue.remove();
                    next.visit();
                    if(next.left!=null)
                        queue.add(next.left);
                    if(next.right!=null)
                        queue.add(next.right);
                }
                break;
            case INORDER:
                traverse(node.left, order);
                node.visit();
                traverse(node.right, order);
                break;
            case POSTORDER:
                traverse(node.left, order);
                traverse(node.right, order);
                node.visit();
        }
    }

    public static void main(String[] args) {

        Node<Integer> n1 = new Node<>(1);
        Node<Integer> n2 = new Node<>(2);
        Node<Integer> n3 = new Node<>(3);
        Node<Integer> n4 = new Node<>(4);
        Node<Integer> n5 = new Node<>(5);


        n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n2.right = n5;

        System.out.println("The preorder traverse:");
        traverse(n1, ORDER.PREORDER);
        System.out.println();
        System.out.println("The level-order traverse:");
        traverse(n1, ORDER.LEVELORDER);
        System.out.println();

        System.out.println("The inorder traverse:");
        traverse(n1, ORDER.INORDER);
        System.out.println();
        System.out.println("The postorder traverse:");
        traverse(n1, ORDER.POSTORDER);
        System.out.println();
    }
}