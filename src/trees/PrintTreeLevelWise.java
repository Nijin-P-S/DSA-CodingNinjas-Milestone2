package trees;

import java.util.Queue;
import java.util.LinkedList;

public class PrintTreeLevelWise {
    public static void printLevelWise(TreeNode<Integer> root){
        if(root == null)
            return;

        Queue<TreeNode<Integer>> roots = new LinkedList<TreeNode<Integer>>();
        Queue<Integer> childrenCount = new LinkedList<Integer>();

        roots.add(root);
        childrenCount.add(1);

        while(!roots.isEmpty()){
            int count = 0;
            TreeNode<Integer> curr ;
            int children = childrenCount.poll();
            for(int i = 0;i < children; i++){
                curr = roots.poll();
                System.out.print(curr.data+" ");
                for(TreeNode<Integer> nodes : curr.children){
                    count++;
                    roots.add(nodes);
                }
            }
            childrenCount.add(count);
            System.out.println();
        }
    }
}
