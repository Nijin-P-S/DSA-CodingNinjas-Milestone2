package trees;

/*
Given a generic tree, find and return the height of given tree.
 */
public class FindHeight {
    private static int getHeight(TreeNode<Integer> root, int level){
        int maxLevel = level;
        for(TreeNode<Integer> node : root.children){
            maxLevel = Math.max(maxLevel, getHeight(node, level+1));
        }

        return maxLevel;
    }


    public static int getHeight(TreeNode<Integer> root){
 
        if(root == null)
            return 0;

        return (getHeight(root, 1));
    }
}
