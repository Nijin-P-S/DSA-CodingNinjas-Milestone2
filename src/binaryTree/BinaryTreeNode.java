package binaryTree;

public class BinaryTreeNode <T>{
        binaryTree.BinaryTreeNode<T> left;
        binaryTree.BinaryTreeNode<T> right;
        T data;
        BinaryTreeNode(T data){
            left = null;
            right = null;
            this.data = data;
    }
}
