package trees;

/*
Given a generic tree, count and return the sum of all nodes present in the given tree.
 */

public class SumOfAllNodes {
    public static int sumOfAllNode(TreeNode<Integer> root){
        if(root == null)
            return 0;

        int sum = root.data;

        for(TreeNode<Integer> node : root.children){
            sum+=sumOfAllNode(node);
        }

        return sum;
    }
}

