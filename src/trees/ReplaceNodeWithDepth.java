package trees;

public class ReplaceNodeWithDepth {
    public static void replaceWithDepthValue(TreeNode<Integer> root, int depth){

        root.data = depth;

        for(TreeNode<Integer> node : root.children){
            replaceWithDepthValue(node, depth+1);
        }
    }

    public static void replaceWithDepthValue(TreeNode<Integer> root){

        // Write your code here
        if(root == null)
            return;

        replaceWithDepthValue(root, 0);
    }
}
