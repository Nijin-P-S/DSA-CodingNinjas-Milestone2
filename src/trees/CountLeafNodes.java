package trees;

/*
Given a generic tree, count and return the number of leaf nodes present in the given tree.
 */

import java.util.Queue;
import java.util.LinkedList;

public class CountLeafNodes {
    public static int countLeafNodes(TreeNode<Integer> root){

        // Write your code here
        if(root == null)
            return 0;

        int noOfLeaves = 0;

        Queue<TreeNode<Integer>> queue = new LinkedList<TreeNode<Integer>>();

        queue.add(root);

        while(!queue.isEmpty()){
            int count = 0;
            TreeNode<Integer> curr = queue.poll();

            for(TreeNode<Integer> node : curr.children){
                queue.add(node);
                count++;
            }
            if(count == 0)
                noOfLeaves++;
        }

        return noOfLeaves;
    }
}
