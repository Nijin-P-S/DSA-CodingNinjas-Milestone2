/*
For a given a Binary Tree of type integer, print the complete information of every node,
when traversed in a level-order fashion.
*/


import binaryTree.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

package binaryTree;

public class PrintLevelWise {
    public static void printLevelWise(BinaryTreeNode<Integer> root) {
        //Your code goes here
        if(root==null)
            return;

        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<BinaryTreeNode<Integer>>();

        queue.add(root);

        while(!queue.isEmpty()){
            BinaryTreeNode<Integer> first = queue.poll();
            System.out.print(first.data+":");
            if(first.left!=null){
                queue.add(first.left);
                System.out.print("L:"+first.left.data);
            }
            else{
                System.out.print("L:-1");
            }
            if(first.right!=null){
                queue.add(first.right);
                System.out.print(",R:"+first.right.data);
            }
            else{
                System.out.print(",R:-1");
            }
            System.out.println();
        }
    }
}
