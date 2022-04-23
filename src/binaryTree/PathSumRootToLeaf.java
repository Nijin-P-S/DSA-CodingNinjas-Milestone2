package binaryTree;

/*
For a given Binary Tree of type integer and a number K,
print out all root-to-leaf paths where the sum of all the node data along the path is equal to K.
 */

public class PathSumRootToLeaf {
    public static void printPath(BinaryTreeNode<Integer> root, int sum, String path){
        if(root == null)
            return ;
        if(root.left == null && root.right == null){
            if(root.data == sum)
            {
                System.out.println(path + Integer.toString(root.data)+" ");
            }
            else
                return;
        }

        sum-=root.data;
        path+=Integer.toString(root.data)+" ";

        printPath(root.left, sum, path);
        printPath(root.right, sum, path);
    }

    public static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k) {
        printPath(root, k, "");
    }
}
