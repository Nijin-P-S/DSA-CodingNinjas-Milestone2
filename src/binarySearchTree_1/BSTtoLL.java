package binarySearchTree_1;

/*
Given a BST, convert it into a sorted linked list. You have to return the head of LL.
 */

import binaryTree.BinaryTreeNode;

import java.util.LinkedList;

class ReturnLL{
    LinkedList<Integer> head;
    LinkedList<Integer> tail;

    ReturnLL(LinkedList<Integer> head, LinkedList<Integer> tail){
        this.head = head;
        this.tail = tail;
    }
}
public class BSTtoLL {
    public static ReturnLL constructLL(BinaryTreeNode<Integer> root)
    {
        if(root == null)
            return null;

        if(root.left == null && root.right == null) //So it is a leaf
        {
            LinkedList<Integer> head = new LinkedList<>(root.data);
            return new ReturnLL(head, head);
        }

        LinkedList<Integer> rootLL = new LinkedList<>(root.data);

        ReturnLL curr = new ReturnLL(null, null);

        ReturnLL left = constructLL(root.left);
        ReturnLL right = constructLL(root.right);


        if(left == null){
            curr.head = rootLL;
        }

        else{
            left.tail.next = rootLL;
            curr.head = left.head;
        }

        if(right == null){
            curr.tail = rootLL;
        }

        else{
            rootLL.next = right.head;
            curr.tail = right.tail;
        }

        return curr;


    }

    public static LinkedList<Integer> constructLinkedList(BinaryTreeNode<Integer> root) {
        if(root == null)
            return null;
        ReturnLL result = constructLL(root);
        return result.head;

    }
}
