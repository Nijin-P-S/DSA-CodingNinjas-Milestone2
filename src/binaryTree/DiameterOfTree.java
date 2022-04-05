package binaryTree;

public class DiameterOfTree {
    public static int height (BinaryTreeNode<Integer> root){
        if(root == null)
            return 0;

        int root_height = 1;
        int left_height = root_height + height(root.left);
        int right_height = root_height + height(root.right);

        int ans = Math.max(left_height, right_height);

        return ans;
    }

    public static int diameterOfBinaryTree(BinaryTreeNode<Integer> root){
        //Your code goes here
        if(root==null)
            return 0;

        int root_height =1;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int diameter = 1+leftHeight+rightHeight;

        int ans = Math.max(diameter, Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right)));

        return ans;
    }
}
