/*
For a given Binary Tree of integers, find and return the height of the tree.
 */

package binaryTree;

public class HeightOfTree {
    public static int height(BinaryTreeNode<Integer> root) {
        //Your code goes here
        if(root==null)
            return 0;

        int root_height =1;
        int left_height = root_height+ height(root.left);
        int right_height = root_height+ height(root.right);

        int height = Math.max(left_height, right_height);

        return height;
    }
}
