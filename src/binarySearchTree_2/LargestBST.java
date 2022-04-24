package binarySearchTree_2;

/*
Given a Binary tree, find the largest BST subtree.
That is, you need to find the BST with maximum height in the given binary tree.
You have to return the height of largest BST.
 */

public class LargestBST {
    public static boolean checkBST(BinaryTreeNode<Integer> root, int min, int max) {
        if(root == null){
            return true;
        }
        if(root.data < min || root.data > max){
            return false;
        }
        boolean isLeftOk = checkBST(root.left,min,root.data-1);
        boolean isRightOk = checkBST(root.right,root.data,max);
        return isRightOk && isLeftOk;
    }

    private static Integer findHeight(BinaryTreeNode<Integer> root){
        if(root == null)
            return 0;

        int rootHeight = 1 + Math.max(findHeight(root.right), findHeight(root.left));
        return rootHeight;
    }

    public static int largestBSTSubtree(BinaryTreeNode<Integer> root) {
        // Write your code here
        if(root == null)
            return 0;

        boolean isBst = checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        int height = 0;
        if(isBst){
            height = findHeight(root);
        }
        else{
            height = Math.max(largestBSTSubtree(root.right), largestBSTSubtree(root.left));
        }
        return height;
    }
}
