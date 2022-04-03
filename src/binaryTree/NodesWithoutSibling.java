/*
For a given Binary Tree of type integer, print all the nodes without any siblings.
 */

package binaryTree;

public class NodesWithoutSibling {

    public static void printNodesWithoutSibling(BinaryTreeNode<Integer> root) {
        //Your code goes here
        if(root==null)
            return;

        if(root.left==null && root.right!=null)
            System.out.print(root.right.data+" ");

        if(root.left!=null && root.right==null)
            System.out.print(root.left.data+" ");

        printNodesWithoutSibling(root.left);
        printNodesWithoutSibling(root.right);
    }
}

