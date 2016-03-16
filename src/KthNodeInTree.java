/**
 * Created by toryang on 16/3/16.
 */

import java.util.Stack;

/**
 * 题目描述:
 * 给定一颗二叉搜索树，请找出其中的第k大的结点。
 * 例如，
 *    5
 *   / \
 *   3 7
 *  /\ /\
 * 2 4 6 8 中，
 * 按结点数值大小顺序第三个结点的值为4。
 *
 */

public class KthNodeInTree {
    /**
     * 解题思路:
     * 中序遍历,按照顺序查找
     * @param pRoot
     * @param k
     * @return
     */
    TreeNode KthNode(TreeNode pRoot, int k) {

        if(pRoot==null) return null;
        int i = 0;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = pRoot;
        while(p!=null || stack.size()!=0){
            while(p!=null){
                stack.add(p);
                System.out.println("p:"+ p.val);
                p = p.left;

            }
            if(stack.size()!=0){
                p = stack.pop();
                if(++i==k){
                    return p;
                }
                System.out.println("p2:"+p.val);
                p = p.right;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(3);
        node.left.left = new TreeNode(2);
        node.left.right = new TreeNode(4);
        node.right = new TreeNode(7);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(8);

        System.out.println(new KthNodeInTree().KthNode(node,3).val);
    }
}
