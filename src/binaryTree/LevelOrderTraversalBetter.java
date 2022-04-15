package binaryTree;

import java.util.Queue;
import java.util.LinkedList;

/*
For a given a Binary Tree of type integer, print it in a level order fashion where each level will be printed on a new line.
Elements on every level will be printed in a linear fashion and a single space will separate them.
 */

public class LevelOrderTraversalBetter {
    public static void printLevelWise(BinaryTreeNode<Integer> root) {
        //Your code goes here
        if(root == null)
            return;

        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();

        queue.add(root);
        queue.add(null);

        while(!queue.isEmpty()){
            BinaryTreeNode<Integer> frontNode = queue.poll();

            if(frontNode == null){
                System.out.println();
                if(!queue.isEmpty()){
                    queue.add(null);
                }
            }

            else{
                System.out.print(frontNode.data+" ");
                if(frontNode.left != null)
                    queue.add(frontNode.left);
                if(frontNode.right != null)
                    queue.add(frontNode.right);
            }
        }
    }
}
