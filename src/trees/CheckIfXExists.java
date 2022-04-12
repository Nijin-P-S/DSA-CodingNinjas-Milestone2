package trees;
/*
Given a generic tree and an integer x,
check if x is present in the given tree or not. Return true if x is present, return false otherwise.
 */

import java.util.Queue;
import java.util.LinkedList;

public class CheckIfXExists {
    public static boolean checkIfContainsX(TreeNode<Integer> root, int x){

        // Write your code here
        if(root == null)
            return false;

        Queue<TreeNode<Integer>> queue = new LinkedList<TreeNode<Integer>>();

        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode<Integer> curr = queue.poll();
            if(curr.data == x)
                return true;
            for(TreeNode<Integer> node : curr.children){
                queue.add(node);
            }
        }

        return false;
    }
}
