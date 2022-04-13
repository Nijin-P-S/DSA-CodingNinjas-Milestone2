package trees;

import java.util.Queue;
import java.util.LinkedList;

/*
Given a generic tree and an integer n.
Find and return the node with next larger element in the Tree i.e. find a node with value just greater than n.
 */

public class NextLargerElement {
    public static TreeNode<Integer> findNextLargerNode(TreeNode<Integer> root, int n){

        // Write your code here
        TreeNode<Integer> result = null;
        Queue<TreeNode<Integer>> queue = new LinkedList<TreeNode<Integer>>();

        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode<Integer> curr = queue.poll();
            if(curr.data>n){
                if(result == null)
                    result = curr;
                if(curr.data< result.data)
                    result = curr;
            }
            for(TreeNode<Integer> node : curr.children){
                queue.add(node);
            }
        }

        return result;
    }
}
