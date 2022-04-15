package binaryTree;

import java.util.Queue;
import java.util.LinkedList;

/*
For a given a Binary Tree of type integer, find and return the minimum and the maximum data values.
Return the output as an object of Pair class, which is already created.
 */

class Pair<T, U> {
    T minimum;
    U maximum;

    public Pair(T minimum, U maximum) {
        this.minimum = minimum;
        this.maximum = maximum;
    }

}

public class MinMaxBinaryTree {
    public static Pair<Integer, Integer> getMinAndMax(BinaryTreeNode<Integer> root) {
        //Your code goes here

        if(root == null)
            return null;

        Pair<Integer, Integer> pair = new Pair<>(root.data, root.data);

        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty()){
            BinaryTreeNode<Integer> frontNode = queue.poll();
            if(frontNode.data<pair.minimum){
                pair.minimum = frontNode.data;
            }
            if(frontNode.data>pair.maximum){
                pair.maximum = frontNode.data;
            }

            if(frontNode.left != null){
                queue.add(frontNode.left);
            }
            if(frontNode.right != null){
                queue.add(frontNode.right);
            }
        }

        return pair;
    }
}
