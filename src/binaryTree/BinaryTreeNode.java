package binaryTree;

public class BinaryTreeNode <T>{
        public binaryTree.BinaryTreeNode<T> left;
        public binaryTree.BinaryTreeNode<T> right;
        public   T data;
        BinaryTreeNode(T data){
            left = null;
            right = null;
            this.data = data;
    }
}
