package trees;

import java.util.Queue;
import java.util.LinkedList;

/*
Given a tree, find and return the node for which sum of data of all children and the node itself is maximum.
In the sum, data of node itself and data of immediate children is to be taken.
 */
public class SumNodeChildrenMax {
    public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root){

        int max = 0;

        Queue<TreeNode<Integer>> queue = new LinkedList<>();

        queue.add(root);

        TreeNode<Integer> result = null;

        while(!queue.isEmpty()){
            TreeNode<Integer> curr = queue.poll();
            int sum = curr.data;

            for(TreeNode<Integer> node : curr.children){
                sum+=node.data;
                queue.add(node);
            }

            if(sum>max){
                max = sum;
                result = curr;
            }

        }
        return result;
    }
}
