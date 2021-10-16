package com.greatlearning.bsttransactions.driver;

import com.greatlearning.bsttransactions.utility.util;

public class transactions extends util{


    public static void main(String[] args) {

    transactions transaction = new transactions();

    Node newTree = null;

    Node tree = null;
    tree = transaction.newNode(50);
    tree.left = transaction.newNode(30);
    tree.right = transaction.newNode(60);
    tree.left.left = transaction.newNode(10);
    tree.right.left = transaction.newNode(40);
    int x;

    while (tree.left!=null || tree.right!=null){
        x = transaction.minNode(tree);
        newTree = transaction.insertNode(newTree,x);
        transaction.deleteNode(tree, x);
    }
    transaction.printTree(newTree);
    System.out.println(tree.nodeData);
}

}