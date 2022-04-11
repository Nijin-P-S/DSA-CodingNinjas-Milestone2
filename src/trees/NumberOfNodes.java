package trees;


import com.sun.xml.internal.xsom.impl.SchemaImpl;

public class NumberOfNodes {
    public static int countNumberOfNodes(TreeNode<Integer> root){
        if(root == null){
            return 0;
        }
        int count = 1;
        for(TreeNode<Integer> node : root.children){
            count+= countNumberOfNodes(node);
        }

        return count;
    }
}
