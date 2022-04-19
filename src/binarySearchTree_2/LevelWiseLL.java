package binarySearchTree_2;

/*
Given a binary tree, write code to create a separate linked list for each level.
You need to return the array which contains head of each level linked list.
 */

import binaryTree.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;

class LinkedListNode<T>{
    LinkedListNode<T> next;
    T data;

    LinkedListNode(T data){
        this.data = data;
    }
}

public class LevelWiseLL {
    public static ArrayList<LinkedListNode<Integer>> constructLinkedListForEachLevel(BinaryTreeNode<Integer> root){
        // Write your code here
        if(root == null)
            return null;

        ArrayList<LinkedListNode<Integer>> result = new ArrayList<>();

        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        LinkedListNode<Integer> head = null;
        LinkedListNode<Integer> tail = null;

        while(!queue.isEmpty()){
            BinaryTreeNode<Integer> curr = queue.poll();

            if(curr == null){
                result.add(head);
                head = null;
                tail = null;

                if(!queue.isEmpty())
                    queue.add(null);

                continue;
            }

            LinkedListNode<Integer> newNode = new LinkedListNode<>(curr.data);


            if(head == null){
                head = newNode;
                tail = newNode;
            }
            else{
                tail.next = newNode;
                tail = newNode;
            }


            if(curr.left != null)
                queue.add(curr.left);
            if(curr.right != null)
                queue.add(curr.right);
        }

        return result;
    }
}
