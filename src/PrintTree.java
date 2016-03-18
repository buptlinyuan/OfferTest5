/**
 * Created by toryang on 16/3/17.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目描述;
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class PrintTree {

    /**
     * 解题思路:
     * 先进行层序遍历;
     * 在遍历每一层的时候看这一层是否需要从右往左打印;
     *
     */

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        if (pRoot == null){
            return lists;
        }
        boolean leftToRight = true;
        Queue<TreeNode> layer = new LinkedList<TreeNode>();
        ArrayList<Integer> layerList = new ArrayList<Integer>();
        layer.add(pRoot);
        int start = 0,end = 1;

        while (layer.size() > 0){
            TreeNode cur = layer.remove();
            layerList.add(cur.val);
            start++;
            if (cur.left != null){
                layer.add(cur.left);
            }

            if (cur.right != null){
                layer.add(cur.right);
            }

            if (start == end){
                end = layer.size();
                start = 0;
                if (!leftToRight){
                    lists.add(reverse(layerList));
                }else {
                    lists.add(layerList);
                }

                leftToRight = !leftToRight;
                layerList = new ArrayList<Integer>();
            }
        }

        return lists;
    }

    private  ArrayList reverse(ArrayList<Integer> layerlist){
        int length = layerlist.size();
        ArrayList<Integer> reverseList = new ArrayList<Integer>();
        for (int i=length-1;i>=0;i--){
            reverseList.add(layerlist.get(i));
        }
        return reverseList;
    }
}
