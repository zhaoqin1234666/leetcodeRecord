package 树;

import org.omg.CORBA.MARSHAL;

public class MaxDepth {
    public static void main(String[] args) {
        TreeNode<String> tree = new TreeNode<>();
        TreeNode left = tree.addLeft("2");
        tree.addRight("3");
        left.addLeft("4");
        TreeNode root = tree;

        MaxDepth maxDepth = new MaxDepth();
        System.out.println(maxDepth.getMaxDepth(root));

    }

    public int getMaxDepth(TreeNode root){
        if(root == null) return 0;
        return Math.max(getMaxDepth(root.left), getMaxDepth(root.right)) + 1;
    }

}
