package binaryTree;

/*
You are given a Binary Tree of type integer, a target node, and an integer value K.
Print the data of all nodes that have a distance K from the target node.
The order in which they would be printed will not matter.
 */

import java.util.ArrayList;

class KDistance{
    BinaryTreeNode<Integer> root;
    Character direction;

    KDistance(BinaryTreeNode<Integer> root, Character direction){
        this.root = root;
        this.direction = direction;
    }
}

public class PrintNodesAtDistanceK {
    private static ArrayList<KDistance> nodes =  new ArrayList<>();

    private static boolean createArray(BinaryTreeNode<Integer> root, int node){
        if(root == null)
            return false;

        if(root.data == node){
            KDistance elem = new KDistance(root, 'C');
            nodes.add(elem);
            return true;
        }

        boolean isLeft = createArray(root.left, node);
        boolean isRight = createArray(root.right, node);

        if(isLeft){
            KDistance elem = new KDistance(root, 'L');
            nodes.add(elem);
            return true;
        }
        if(isRight){
            KDistance elem = new KDistance(root, 'R');
            nodes.add(elem);
            return true;
        }
        return false;
    }


    private static void printNodes(BinaryTreeNode<Integer> root , int distance){
        if(root == null)
            return;

        if(distance == 0){

            System.out.println(root.data);
        }

        printNodes(root.left, distance-1);
        printNodes(root.right, distance-1);


    }

    public static void nodesAtDistanceK(BinaryTreeNode<Integer> root, int node, int k) {
        createArray(root, node);


        for(KDistance element : nodes){
            if(k == 0){
                System.out.println(element.root.data);
                break;
            }
            else if(element.direction == 'L'){
                printNodes(element.root.right, k-1);
                k--;
            }
            else if(element.direction == 'R'){
                printNodes(element.root.left, k-1);
                k--;
            }
            else if(element.direction == 'C'){
                printNodes(element.root, k);
                k--;
            }
        }
    }
}
