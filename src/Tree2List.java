/**
 * Created by toryang on 16/3/16.
 */

import java.util.ArrayList;

/**
 * 题目描述:
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class Tree2List {

    /**
     * 解题思路:
     * 1,中序遍历,将顺序链表存到list中;
     * 2,针对list中的TreeNode,对前后指针进行修改,使node.left指向前一个,node.right指向后一个;
     * @param pRootOfTree
     * @return
     */
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree==null){
            return null;
        }
        ArrayList<TreeNode> inorderList=new ArrayList<TreeNode>();
        inorder(pRootOfTree,inorderList);

        int n = inorderList.size();
        for(int i=0;i<n;i++){
            if(i>0){
                inorderList.get(i).left=inorderList.get(i-1);
            }
            if(i<n-1){
                inorderList.get(i).right=inorderList.get(i+1);
            }
        }
        return inorderList.get(0);
    }

    private void inorder(TreeNode pRootOfTree,ArrayList<TreeNode> inorderList){
        if(pRootOfTree==null){
            return;
        }
        inorder(pRootOfTree.left,inorderList);
        inorderList.add(pRootOfTree);
        inorder(pRootOfTree.right,inorderList);
    }
}
