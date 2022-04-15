package binaryTree;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

/*
For a given a Binary Tree of type integer, print it in a level order fashion where each level will be printed on a new line.
Elements on every level will be printed in a linear fashion and a single space will separate them.
 */

public class LevelOrderTraversal {
    public static void printLevelWise(BinaryTreeNode<Integer> root) {
        //Your code goes here
        if(root == null)
            return;

        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();


        queue.add(root);
        stack.push(1);

        while(!queue.isEmpty()){
            int loop = stack.pop();
            int countChildren = 0;

            for(int i = 0; i < loop ; i++){
                BinaryTreeNode<Integer> curr = queue.poll();
                System.out.print(curr.data+" ");
                if(curr.left != null){
                    countChildren++;
                    queue.add(curr.left);
                }
                if(curr.right != null){
                    countChildren++;
                    queue.add(curr.right);
                }
            }
            System.out.println();
            stack.push(countChildren);
        }
    }
}
