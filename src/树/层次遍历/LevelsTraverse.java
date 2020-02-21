package 树.层次遍历;

import 树.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 层次遍历 广度优先
 */
public class LevelsTraverse {
    public static void main(String[] args) {
        TreeNode<String> tree = new TreeNode<String>();
        TreeNode left = tree.addLeft("2");
        tree.addRight("3");
        left.addLeft("4");
        TreeNode root = tree;

        LevelsTraverse levelsTraverse = new LevelsTraverse();
        List<List<String>> lists = levelsTraverse.levelTraverse(root);
        for (List<String> list : lists) {
            System.out.println(list);
        }

    }

    public List<List<String>> levelTraverse(TreeNode root){
        List<List<String>> resultList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            int count = queue.size();
            List<String> ret = new ArrayList<>();

            while (count > 0){
                TreeNode temp = queue.poll();
                ret.add((String) temp.value);
                if(temp.left != null) queue.add(temp.left);
                if(temp.right != null) queue.add(temp.right);
                count--;
            }
            resultList.add(ret);
        }
        return resultList;
    }
}
