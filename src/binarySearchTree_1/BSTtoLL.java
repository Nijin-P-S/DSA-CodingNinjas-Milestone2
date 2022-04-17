package binarySearchTree_1;

/*
Given a binary search tree and data of two nodes, find 'LCA' (Lowest Common Ancestor) of the given two nodes in the BST.
 */

import binaryTree.BinaryTreeNode;

public class BSTtoLL {
    private static boolean find(BinaryTreeNode<Integer> root , int num){
        if(root == null)
            return false;

        if(root.data == num)
            return true;

        return find(root.left, num) || find(root.right, num);
    }

    public static int getLCA(BinaryTreeNode<Integer> root, int a, int b) {
        if(root == null)
            return -1;
        int max = Math.max(a, b);
        int min = Math.min(a,b);

        while(root!=null &&(root.data != min) && !(root.data>min && root.data<=max) ){
            if(root.data < min)
                root = root.right;
            else if(root.data > max)
                root = root.left;
        }


        boolean findA = find(root, a);
        boolean findB = find(root, b);

        if(findA && findB)
            return root.data;

        else if(findA)
            return a;
        else if(findB)
            return b;
        else
            return -1;
    }
}
