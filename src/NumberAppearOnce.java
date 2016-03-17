/**
 * Created by toryang on 16/3/17.
 */

/**
 * 题目描述:
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字.
 */
public class NumberAppearOnce {
    /**
     * 解题思路:
     * 1,将数组中的数进行异或,得到只出现一次的两个数异或的结果;
     * 2,异或的结果必定有大于等于1位为1,去第1个为1的位数n;
     * 3,将数组中的数按照第n位是否为1分为两个数组,只出现一次的数也分别在这两个数组中;
     * 4,将两个数组各自异或,两个数分别得到的两个数为只出现一次的数字;
     */
    public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array == null || array.length <= 1){
            num1[0] = num2[0] = 0;
            return;
        }
        int len = array.length, index = 0, sum = 0;
        for(int i = 0; i < len; i++){
            sum ^= array[i];
        }
        for(index = 0; index < 32; index++){
            if((sum & (1 << index)) != 0) break;
        }
        for(int i = 0; i < len; i++){
            if((array[i] & (1 << index))!=0){
                num2[0] ^= array[i];
            }else{
                num1[0] ^= array[i];
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,2,3};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        FindNumsAppearOnce(array,num1,num2);
        System.out.println(num1[0]+":"+num2[0]);

    }
}
