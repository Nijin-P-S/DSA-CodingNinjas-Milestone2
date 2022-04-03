/*
For a given Binary Tree of type integer and a number X, find whether a node exists in the tree with data X or not.
 */

package binaryTree;

public class IsNodePresent {
    public static boolean isNodePresent(BinaryTreeNode<Integer> root, int x) {
        //Your code goes here
        if(root==null)
            return false;

        if(root.data==x)
            return true;

        return isNodePresent(root.left,x) || isNodePresent(root.right,x);
    }
}
