/**
 * Created by toryang on 16/3/17.
 */

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 题目描述;
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class PrintTree {

    /**
     * 解题思路:
     * 按之字形顺序打印二叉树需要两个栈。我们在打印某一行结点时，把下一层的子结点保存到相应的栈里。
     * 如果当前打印的是奇数层，则先保存左子结点再保存右子结点到一个栈里；
     * 如果当前打印的是偶数层，则先保存右子结点再保存左子结点到第二个栈里。
     */

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        if (pRoot == null){
            return lists;
        }
        LinkedList<TreeNode> current = new LinkedList<TreeNode>();
        LinkedList<TreeNode> reverse = new LinkedList<TreeNode>();

        int flag = 0;
        TreeNode node;
        current.add(pRoot);
        while (current.size() > 0){
            node = current.remove(current.size()-1);

        }

        return lists;
    }
}
