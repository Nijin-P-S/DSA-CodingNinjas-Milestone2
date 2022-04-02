/*
For a given a binary tree of integers and an integer X,
find and return the total number of nodes of the given binary tree which are having data greater than X.
 */

package binaryTree;

public class NodeGreaterThanX {
    public static int countNodesGreaterThanX(BinaryTreeNode<Integer> root, int x) {
        //Your code goes here
        if(root==null)
            return 0;

        if(root.data>x)
            return 1+countNodesGreaterThanX(root.left,x)+countNodesGreaterThanX(root.right,x);
        else
            return countNodesGreaterThanX(root.left,x)+countNodesGreaterThanX(root.right,x);
    }
}
