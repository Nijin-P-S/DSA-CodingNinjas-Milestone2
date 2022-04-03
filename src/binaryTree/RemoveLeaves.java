/*
Write a program to remove leaves from the binary tree
 */

package binaryTree;

public class RemoveLeaves {

    public static BinaryTreeNode<Integer> removeLeaves(BinaryTreeNode<Integer> root){
        if(root == null)
            return null;

        if(root.left==null && root.right==null)
            return null;

        root.left = removeLeaves(root.left);
        root.right = removeLeaves(root.right);

        return root;
    }
}
