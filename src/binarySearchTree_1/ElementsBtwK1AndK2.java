package binarySearchTree_1;

import binaryTree.BinaryTreeNode;

/*
Given a Binary Search Tree and two integers k1 and k2,
find and print the elements which are in range k1 and k2 (both inclusive).
****************************Print the elements in increasing order.************************************
 */

public class ElementsBtwK1AndK2 {
    public static void elementsInRangeK1K2(BinaryTreeNode<Integer> root, int k1, int k2){
        if(root == null)
            return;


        if(root.data >= k1 && root.data <= k2)
        {
            elementsInRangeK1K2(root.left, k1 , k2);
            System.out.print(root.data + " ");
            elementsInRangeK1K2(root.right, k1 , k2);
        }


        else if(root.data > k2){
            elementsInRangeK1K2(root.left, k1 , k2);
        }
        else if(root.data < k1)
            elementsInRangeK1K2(root.right, k1 , k2);
    }
}
