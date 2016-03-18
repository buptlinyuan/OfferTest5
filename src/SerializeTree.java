/**
 * Created by toryang on 16/3/18.
 */

/**
 * 题目描述:
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 */
public class SerializeTree {

    /**
     * 解题思路:
     * 根据给出的返回值类型可知,序列化就是:需要将一个二叉树序列化成为一个String类型;
     * 反序列化就是将序列化返回的String字符串返回到原二叉树;
     */
    int index = -1;
    String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null){
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.val+",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();

    }
    TreeNode Deserialize(String str) {
        index++;
        int length = str.length();
        if (index >= length){
            return null;
        }

        String[] strr = str.split(",");
        TreeNode node = null;
        if (!strr[index].equals("#")){
            node = new TreeNode(Integer.valueOf(strr[index]));
            node.left = Deserialize(str);
            node.right= Deserialize(str);
        }

        return node;
    }
}
