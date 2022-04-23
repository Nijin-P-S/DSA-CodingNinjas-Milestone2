package binaryTree;

/*
For a given postorder and inorder traversal of a Binary Tree of type integer stored in an array/list,
create the binary tree using the given two arrays/lists. You just need to construct the tree and return the root.
 */

/*
ALGORITHM
1)Find the root from postOrder
2)Get the left and right inorder subtree from inOrder
3)Find the left and right postOrder subtree from postOrder
4)Generate the left and right subtree
5)Attach it to root
 */

public class ConstructUsingInorderAndPostOrder {
    public static BinaryTreeNode<Integer> buildTree(int[] postOrder, int[] inOrder) {
        if(inOrder.length ==0 && postOrder.length == 0)
            return null;

        if(inOrder.length ==1 && postOrder.length == 1)
        {
            BinaryTreeNode<Integer> root = new BinaryTreeNode<>(postOrder[postOrder.length-1]);
            return root;
        }

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(postOrder[postOrder.length-1]);
        int inOrderIndex = 0;

        while(inOrder[inOrderIndex]!=postOrder[postOrder.length-1])
            inOrderIndex++;

        int[] leftInorder= new int[inOrderIndex];;
        int[] rightInorder = new int[inOrder.length - inOrderIndex-1];
        int[] leftPostorder= new int[inOrderIndex];;
        int[] rightPostorder = new int[inOrder.length - inOrderIndex-1];

        for(int i=0;i<leftInorder.length; i++){
            leftInorder[i] = inOrder[i];
        }

        for(int i=0; i<rightInorder.length;i++){
            rightInorder[i] = inOrder[inOrderIndex+1+i];
        }

        for(int i=0;i<leftPostorder.length;i++){
            leftPostorder[i] = postOrder[i];
        }

        for(int i=0; i<rightPostorder.length;i++){
            rightPostorder[i] = postOrder[inOrderIndex+i];
        }

        root.left = buildTree(leftPostorder, leftInorder);
        root.right = buildTree(rightPostorder, rightInorder);

        return root;
    }
}
