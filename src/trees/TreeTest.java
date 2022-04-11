package trees;

import java.util.Scanner;

public class TreeTest {

    public static TreeNode<Integer> takeInputRecursive(){
        System.out.println("Enter the data of your node :");
        Scanner input = new Scanner(System.in);
        int data = input.nextInt();
        TreeNode<Integer> root = new TreeNode<>(data);
        System.out.println("Enter the number of children for "+root.data);
        int count = input.nextInt();

        for(int i=0; i<count; i++){
            root.children.add(takeInputRecursive());
        }

        return root;
    }

    public static void printTreePreOrderBetter(TreeNode<Integer> root){
        if(root == null)
            return;

        System.out.print(root.data+": ");
        for (TreeNode<Integer> node : root.children){
            System.out.print(node.data+" ");
        }
        System.out.println();
        for (TreeNode<Integer> node : root.children){
            printTreePreOrderBetter(node);
        }
    }

    public static void printTreePreOrder(TreeNode<Integer> root){
        if(root == null)
            return;

        System.out.print(root.data + " ");
        for (TreeNode<Integer> node : root.children){
            printTreePreOrder(node);
        }
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(4);
        TreeNode<Integer> node1 = new TreeNode<>(1);
        TreeNode<Integer> node2 = new TreeNode<>(2);
        TreeNode<Integer> node3 = new TreeNode<>(3);
        TreeNode<Integer> node4 = new TreeNode<>(5);
        TreeNode<Integer> node5 = new TreeNode<>(6);

        root.children.add(node1);
        root.children.add(node2);
        root.children.add(node3);
        node2.children.add(node4);
        node2.children.add(node5);

        TreeNode<Integer> newRoot = takeInputRecursive();

        printTreePreOrderBetter(newRoot);

        System.out.println(NumberOfNodes.countNumberOfNodes(root));
    }
}
