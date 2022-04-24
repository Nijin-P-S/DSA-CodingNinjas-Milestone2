package binarySearchTree_2;

/*
Implement the BST class which includes following functions -
1. search
Given an element, find if that is present in BST or not. Return true or false.
2. insert -
Given an element, insert that element in the BST at the correct position.
If element is equal to the data of the node, insert it in the left subtree.
3. delete -
Given an element, remove that element from the BST.
If the element which is to be deleted has both children, replace that with the minimum element from right sub-tree.
4. printTree (recursive) -
Print the BST in ithe following format -
For printing a node with data N, you need to follow the exact format -
N:L:x,R:y
where, N is data of any node present in the binary tree.
x and y are the values of left and right child of node N. Print the children only if it is not null.
There is no space in between.
You need to print all nodes in the recursive format in different lines.
 */


public class BinarySearchTree {
    BinaryTreeNode<Integer> root;
    int size = 0;

    private BinaryTreeNode<Integer> insert(BinaryTreeNode<Integer> root, int data){
        if(root == null){
            BinaryTreeNode<Integer> node = new BinaryTreeNode<>(data);
            return node;
        }

        if(data > root.data){
            root.right = insert(root.right, data);
        }
        else{
            root.left = insert(root.left, data);
        }
        return root;
    }
    public void insert(int data) {
        //Implement the insert() function
        if(size == 0){
            root = new BinaryTreeNode<>(data);
            size++;
            return;
        }
        insert(root, data);
        size++;
    }


    private BinaryTreeNode<Integer> findNode(BinaryTreeNode<Integer> root, int data){
        if(root == null)
            return null;
        if(root.data == data)
            return root;

        if(data > root.data)
            return findNode(root.right, data);
        else
            return findNode(root.left, data);
    }

    private Integer findSmallest(BinaryTreeNode<Integer> root){
        if(root == null){
            return Integer.MAX_VALUE;
        }
        return (Math.min(root.data,Math.min(findSmallest(root.left),findSmallest(root.right))));
    }

    private BinaryTreeNode<Integer> remove(BinaryTreeNode<Integer> root, int data){
        if(root == null)
            return null;

        if(root.data < data)
            root.right = remove(root.right, data);
        else if(root.data > data)
            root.left = remove(root.left, data);

        if(root.left ==null && root.right == null)
            return null;
        else if(root.right == null && root.left!=null){
            return root.left;
        }
        else if(root.right!=null && root.left == null)
            return root.right;
        else{
            int smallest = findSmallest(root.right);
            root.data = smallest;
            root.right = remove(root.right, smallest);
            return root;
        }

    }

    public void remove(int data) {
        //Implement the remove() function
        root = remove(root, data);
        size--;
    }

    private void printTree(BinaryTreeNode<Integer> root){
        if(root == null)
            return;
        System.out.print(root.data +":");
        if(root.left!=null){
            System.out.print("L:"+root.left.data+",");
        }
        if(root.right!=null){
            System.out.print("R:"+root.right.data);
            System.out.println();
        }
        if(root.left==null && root.right == null)
            System.out.println();
        else if(root.right == null)
            System.out.println();
        printTree(root.left);
        printTree(root.right);
    }

    public void printTree() {
        //Implement the printTree() function
        printTree(root);
    }

    private boolean search(BinaryTreeNode<Integer> root, int data){
        if(root == null)
            return false;

        if(root.data == data)
            return true;

        return search(root.left , data) || search(root.right, data);
    }

    public boolean search(int data) {
        //Implement the search() function
        return search(root, data);
    }


}
