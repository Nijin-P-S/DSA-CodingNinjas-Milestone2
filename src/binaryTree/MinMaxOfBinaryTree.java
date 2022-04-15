package binaryTree;

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


public class MinMaxOfBinaryTree {
    public static Pair<Integer, Integer> getMinAndMax(BinaryTreeNode<Integer> root){
        if(root == null){
            return new Pair<>(Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Pair<Integer, Integer> leftPair = getMinAndMax(root.left);
        Pair<Integer, Integer> rightPair = getMinAndMax(root.right);

        int minimum = Math.min(root.data, Math.min(leftPair.minimum, rightPair.minimum));
        int maximum = Math.max(root.data, Math.max(leftPair.maximum, rightPair.maximum));

        return new Pair<>(minimum, maximum);
    }
}
