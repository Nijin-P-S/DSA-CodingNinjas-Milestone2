package trees;

/*
Given a generic tree, print the post-order traversal of given tree.
The post-order traversal is: visit child nodes first and then root node.
 */

public class PostOrderTraversal {
    public static void printPostOrder(TreeNode<Integer> root){

        if(root == null)
            return;


        for(TreeNode<Integer> node: root.children){
            printPostOrder(node);
        }
        System.out.print(root.data + " ");

    }
}
