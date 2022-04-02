/*
For a given Binary Tree of integers, print the post-order traversal.
 */
package binaryTree;

public class PostOrderTraversal {
    public static void postOrder(BinaryTreeNode<Integer> root) {
        //Your code goes here
        if(root==null)
            return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }
}
