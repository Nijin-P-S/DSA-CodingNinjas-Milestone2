package trees;

/*
Given two Generic trees, return true if they are structurally identical
i.e. they are made of nodes with the same values arranged in the same way.
 */


import java.util.Queue;
import java.util.LinkedList;

public class StructurallyIdentical {
    public static boolean checkIdentical(TreeNode<Integer> root1, TreeNode<Integer> root2){

        if(root1 == null || root2 == null)
            return false;


        Queue<TreeNode<Integer>> queue1 = new LinkedList<TreeNode<Integer>>();
        Queue<TreeNode<Integer>> queue2 = new LinkedList<TreeNode<Integer>>();

        queue1.add(root1);
        queue2.add(root2);

        while(!queue1.isEmpty() && !queue2.isEmpty()){
            TreeNode<Integer> curr1 = queue1.poll();
            TreeNode<Integer> curr2 = queue2.poll();

            if(curr1.data != curr2.data)
                return false;

            for(TreeNode<Integer> node : curr1.children)
                queue1.add(node);

            for(TreeNode<Integer> node : curr2.children)
                queue2.add(node);
        }

        if(!queue1.isEmpty() || !queue2.isEmpty())
            return false;

        return true;
    }
}
