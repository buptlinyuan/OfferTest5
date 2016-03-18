/**
 * Created by toryang on 16/3/18.
 */

/**
 * 题目描述:
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 * 例如
 * a b c e
 * s f c s
 * a d e e
 * 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
 * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 *
 * ABCE
 * SFCS
 * ADEE
 */
public class HasPathInMatrix {

    /**
     * 解题思路:
     * 从矩阵某个外围位置开始,上下左右进行遍历查找,看是否能够匹配得到需要查找的字符串;
     */
    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        int flag[] = new int[matrix.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (helper(matrix, rows, cols, i, j, str, 0, flag))
                    return true;
            }
        }
        return false;
    }

    /**
     * 回溯法进行递归;
     *
     * @param matrix 矩阵
     * @param rows 矩阵行
     * @param cols 矩阵列
     * @param i 当前行
     * @param j 当前列
     * @param str 当前字符串
     * @param k 目前匹配字符串位置
     * @param flag
     * @return
     */
    private static boolean helper(char[] matrix, int rows, int cols, int i, int j, char[] str, int k, int[] flag) {
        int index = i * cols + j;
        if (i < 0 || i >= rows || j < 0 || j >= cols || matrix[index] != str[k] || flag[index] == 1)
            return false;
        if(k == str.length - 1) return true;
        flag[index] = 1;

        if (helper(matrix, rows, cols, i - 1, j, str, k + 1, flag)
                || helper(matrix, rows, cols, i + 1, j, str, k + 1, flag)
                || helper(matrix, rows, cols, i, j - 1, str, k + 1, flag)
                || helper(matrix, rows, cols, i, j + 1, str, k + 1, flag)) {

            return true;
        }
        flag[index] = 0;
        return false;
    }

    public static void main(String[] args) {
        char[] array = {'a','b', 'c','e','s','f','c','s','a','d','e','e'};
        System.out.println(hasPath("ABCESFCSADEE".toCharArray(),3,4,"SEE".toCharArray()));

    }


}
