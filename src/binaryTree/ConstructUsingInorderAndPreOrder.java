package binaryTree;

/*
For a given preorder and inorder traversal of a Binary Tree of type integer stored in an array/list,
create the binary tree using the given two arrays/lists. You just need to construct the tree and return the root.
 */

/*Algorithm
1) Find root from preOrder array
2)Find Inorder or both left and right of the root from InOrder
3)Find PreOrder of both left anf left subtree
4)Use recursion to build left and right subtree
5)Attach them to root
*/

public class ConstructUsingInorderAndPreOrder {
    public static BinaryTreeNode<Integer> buildTree(int[] preOrder, int[] inOrder) {
        if(inOrder.length ==0 && preOrder.length == 0)
            return null;

        if(inOrder.length ==1 && preOrder.length == 1)
        {
            BinaryTreeNode<Integer> root = new BinaryTreeNode<>(preOrder[0]);
            return root;
        }

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(preOrder[0]);
        int inOrderIndex = 0;

        while(inOrder[inOrderIndex]!=preOrder[0])
            inOrderIndex++;

        int[] leftInorder= new int[inOrderIndex];;
        int[] rightInorder = new int[inOrder.length - inOrderIndex-1];
        int[] leftPreorder= new int[inOrderIndex];;
        int[] rightPreorder = new int[inOrder.length - inOrderIndex-1];

        for(int i=0;i<leftInorder.length; i++){
            leftInorder[i] = inOrder[i];
        }

        for(int i=0; i<rightInorder.length;i++){
            rightInorder[i] = inOrder[inOrderIndex+1+i];
        }

        for(int i=0;i<leftPreorder.length;i++){
            leftPreorder[i] = preOrder[i+1];
        }

        for(int i=0; i<rightPreorder.length;i++){
            rightPreorder[i] = preOrder[inOrderIndex+i+1];
        }

        root.left = buildTree(leftPreorder, leftInorder);
        root.right = buildTree(rightPreorder, rightInorder);

        return root;
    }
}
