package binarySearchTree_2;

import binaryTree.BinaryTreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/*
Given a binary search tree and an integer S, find pair of nodes in the BST which sum to S.
You can use extra space of the order of O(log n).
 */


public class PairSumInBST {
    private static HashSet<Integer> hashSet = new HashSet<>();

    private static boolean foundPair(BinaryTreeNode<Integer> root , int diff){
        if(root == null)
            return false;

        if(root.data < diff)
            return foundPair(root.right, diff);
        else if(root.data > diff)
            return foundPair(root.left, diff);
        else
            return true;
    }

    public static void printNodes(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> curr, int s){
        if(curr==null)
            return;

        int diff = s - curr.data;
        if(curr.data != diff && !(hashSet.contains(curr.data) || hashSet.contains(diff))){
            boolean found = foundPair(root, diff);
            if(found){
                System.out.println(Math.min(curr.data, diff) + " " + Math.max(curr.data, diff));
                hashSet.add(curr.data);
                hashSet.add(diff);
            }
        }

        printNodes(root, curr.left, s);
        printNodes(root, curr.right, s);
    }

    public static void printNodesSumToS(BinaryTreeNode<Integer> root, int s) {
        printNodes(root, root, s);
    }
}
