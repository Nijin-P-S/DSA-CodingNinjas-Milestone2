package binarySearchTree;

import binaryTree.BinaryTreeNode;

public class CheckBSTOrNot {
    public static boolean isBST_Helper(BinaryTreeNode<Integer> root, int min, int max) {
        if(root == null){
            return true;
        }
        if(root.data < min || root.data > max){
            return false;
        }
        boolean isLeftOk = isBST_Helper(root.left,min,root.data-1);
        boolean isRightOk = isBST_Helper(root.right,root.data,max);
        return isRightOk && isLeftOk;
    }
    public static boolean isBST(BinaryTreeNode<Integer> root) {

        return isBST_Helper(root,Integer.MIN_VALUE,Integer.MAX_VALUE);

    }
}
