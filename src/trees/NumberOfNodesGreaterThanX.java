package trees;

/*
Given a tree and an integer x, find and return number of Nodes which are greater than x.
 */

import java.util.Queue;
import java.util.LinkedList;
public class NumberOfNodesGreaterThanX {
    public static int numNodeGreater(TreeNode<Integer> root,int x){

        // Write your code here
        int count = 0;
        if(root == null){
            return count;
        }

        Queue<TreeNode<Integer>> queue = new LinkedList<TreeNode<Integer>>();
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode<Integer> curr = queue.poll();
            if(curr.data > x)
                count++;
            for(TreeNode<Integer> node : curr.children){
                queue.add(node);
            }
        }
        return count;
    }
}
