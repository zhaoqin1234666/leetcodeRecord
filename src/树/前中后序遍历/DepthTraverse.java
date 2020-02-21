package 树.前中后序遍历;

import 树.TreeNode;

/**
 *
 */
public class DepthTraverse {
    public static void main(String[] args) {
        TreeNode<String> tree = new TreeNode<String>("1");
        TreeNode left = tree.addLeft("2");
        tree.addRight("3");
        left.addLeft("4");
        TreeNode root = tree;

        DepthTraverse depthTraverse = new DepthTraverse();
        depthTraverse.beforeDfs(root);
        System.out.println();
        depthTraverse.centerDfs(root);
        System.out.println();
        depthTraverse.laterDfs(root);

    }

    /**
     * 前序
     * @param root
     */
    public void beforeDfs(TreeNode root){
        if(root != null){
            beforeDfs(root.left);
            System.out.print(root.value + " ");
            beforeDfs(root.right);
        }
    }

    /**
     * 中序
     * @param root
     */
    public void centerDfs(TreeNode root){
        if(root != null){
            System.out.print(root.value + " ");
            beforeDfs(root.left);
            beforeDfs(root.right);
        }
    }

    /**
     * 中序
     * @param root
     */
    public void laterDfs(TreeNode root){
        if(root != null){
            beforeDfs(root.left);
            beforeDfs(root.right);
            System.out.print(root.value + " ");
        }
    }

}
