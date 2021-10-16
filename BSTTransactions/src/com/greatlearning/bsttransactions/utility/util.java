package com.greatlearning.bsttransactions.utility;

import java.util.Queue;
import java.util.Deque;
import java.util.LinkedList;

public class util {

    Deque<Node> queue = new LinkedList<Node>();

    public class Node {

        public int nodeData;
        public Node left;
        public Node right;

    }

    public Node newNode(int x){
        Node temp = new Node();
            temp.nodeData = x;
            temp.left = null;
            temp.right = null;
            return temp;
    }


    public int minNode(Node root) {
        
        int min = root.nodeData;
        Queue<Node> queue1 = new LinkedList<Node>();
        queue1.add(root);
        while (!queue1.isEmpty()) {
            Node tempNode = queue1.poll();
            if (tempNode.nodeData < min) {
                min = tempNode.nodeData;
            }
            // enqueue left node
            if (tempNode.left != null) {
                queue1.add(tempNode.left);
            }    
            // enqueue right node       
            if (tempNode.right != null) {    
                queue1.add(tempNode.right);
            }    
        }
        return min;
    }

    public void deleteNode( Node root, int nodeData) {

        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            if (root.nodeData == nodeData) {
                Node temp = null;
                root = temp;
                return;
            } else
                return;
        }
        
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        Node temp = null, keyNode = null;
        while (!q.isEmpty()) {
            temp = q.peek();
            q.remove();
            if (temp.nodeData == nodeData)
                keyNode = temp; // Found the deletion node
            if (temp.left != null)
                q.add(temp.left);
            if (temp.right != null)
                q.add(temp.right);
        }
        if (keyNode != null) {
            int x = temp.nodeData; // the last node searched in the above loop is the deepest rightmost node
            delete(root, temp); // delete the deepest rightmost node
            keyNode.nodeData = x; // replace found node key value with deleted value
        }
            
    }

    static void delete(Node root, Node delNode) {

        Queue<Node> q1 = new LinkedList<Node>();
        q1.add(root);
        Node tempNode = null;
        while (!q1.isEmpty()) {
            tempNode = q1.peek();
            q1.remove();
            if (tempNode == delNode) {
                tempNode = null;
                return;
            }
        
            if (tempNode.right != null) {
                if (tempNode.right == delNode) {
                    tempNode.right = null;
                    return;
                } else
                    q1.add(tempNode.right);
            }
        
            if (tempNode.left != null) {
                if (tempNode.left == delNode) {
                    tempNode.left = null;
                    return;
                } else
                    q1.add(tempNode.left);
            }
        
        }
        
        
    }
    protected Node insertNode(Node root, int key) {

        Node newnode = newNode(key);
        if (root == null) {
            root = newnode;
            queue.add(root);   
            return root;    
        } else {
            Node node;
            node = queue.remove();
            /*here is no need to insert left node*/
            // if (node.left == null) {
            //     node.left = newnode;
            //     queue.add(node.left);
            //     queue.addFirst(node);
            //     return root;
            node.right = newnode;
            queue.add(node.right);
            return root;
        }
    }
    public void printTree(Node root) {
        Queue<Node> queue1 = new LinkedList<Node>();
        queue1.add(root);
        if (root != null) {
            while (!queue1.isEmpty()) {
                Node tempNode = queue1.poll();
                System.out.print(tempNode.nodeData+"->");
        
                /*here is no need to check left node because there is no 
                /left node*/
                // if (tempNode.left != null) {
                //     queue1.add(tempNode.left);
                // }
          
                if (tempNode.right != null) {
                    queue1.add(tempNode.right);
                }
            }
        } else
            System.out.println("Tree is empty!!!");    
        }
}
