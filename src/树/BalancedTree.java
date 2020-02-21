package 树;

/**
 * 平衡二叉树 AVL
 * 性质：
 *      左右子树的高度之差的绝对值小于等于 1  如果大于等于2 就不平衡
 *      平衡因子 = 左子树高度 - 右子树高度的绝对值
 *
 *
 * 平衡二叉树的调整步骤
 * 1 找平衡因子
 * 2 找插入新结点后，失去平衡的最小子数
 *          最小子数的要求如下
 *              a 距离插入的新结点最近
 *              b 平衡因子绝对值大于1的结点作为根
 * 3 平衡调整
 *          有四种情况
 *          LL型 - R
 *          RR型 - L
 *          LR型 - LR
 *          Rl型 - RL
 *
 *      右转就是顺时针转   左转就是逆时针转
 *
 * LL型(中为支点，高右转)
 *
 *         16        11
 *       11        9    16
 *      9
 *
 * RR型 (中为支，高左转)
 *       7                      11
 *        11                  7   16
 *          16
 *
 * LR型(下二整体先左转 后与LL同)
 *       16                16              7
 *     3                 7               3   16
 *       7              3
 * RL型(下二整体先右转 后与RR同)
 *    16             16                18
 *      26             18            16   26
 *    18                 26
 *
 *
 * 实例
 *  16   3  7  11  9 26 18  14  15
 *
 *
 *
 */
public class BalancedTree {
    private boolean isBalanced = true;

    public static void main(String[] args) {
        TreeNode<String> tree = new TreeNode<>();
        TreeNode left = tree.addLeft("2");
        tree.addRight("3");
        left.addLeft("4");
        TreeNode root = tree;

        BalancedTree instanse = new BalancedTree();
        System.out.println(instanse.isBalancedTree(root));
        System.out.println(instanse.isBalanced);
    }

    public int isBalancedTree(TreeNode head){
        if(head == null) return 0;
        int l = isBalancedTree(head.left);
        int r = isBalancedTree(head.right);
        if(Math.abs(l - r) > 1) isBalanced = false;
        return 1 + Math.max(l, r);
    }
}
