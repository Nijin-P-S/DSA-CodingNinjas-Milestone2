package binarySearchTree;

/*
Given a sorted integer array A of size n, which contains all unique elements.
You need to construct a balanced BST from this input array. Return the root of constructed BST.
 */


import binaryTree.BinaryTreeNode;

public class ConstructBST {
    public static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr, int left, int right){
        if(left>right)
            return null;

        int mid = (left+right)/2;

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(arr[mid]);
        root.left = SortedArrayToBST(arr, left, mid-1);
        root.right = SortedArrayToBST(arr, mid+1, right);


        return root;


    }
    
    public static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr, int n){
        if(n==0)
            return null;
        return SortedArrayToBST(arr, 0, n-1);

    }
}
