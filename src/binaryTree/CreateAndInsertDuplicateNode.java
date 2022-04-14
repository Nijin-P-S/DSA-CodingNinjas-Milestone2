package binaryTree;

/*
For a given a Binary Tree of type integer, duplicate every node of the tree and attach it to the left of itself.
The root will remain the same. So you just need to insert nodes in the given Binary Tree.
 */

public class CreateAndInsertDuplicateNode {
    public static void insertDuplicateNode(BinaryTreeNode<Integer> root) {
        if(root == null)
            return;

        BinaryTreeNode<Integer> node = new BinaryTreeNode<Integer>(root.data);

        node.left = root.left;
        root.left = node;

        insertDuplicateNode(node.left);
        insertDuplicateNode(root.right);
    }
}
