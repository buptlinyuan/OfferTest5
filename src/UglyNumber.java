/**
 * Created by toryang on 16/3/16.
 */

/**
 * 题目描述:
 * 把只包含因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含因子7。
 * 习惯上我们把1当做是第一个丑数。
 * 求按从小到大的顺序的第N个丑数。
 */
public class UglyNumber {

    public int Min(int number1,int number2,int number3){
        int min = (number1 < number2)?number1:number2;
        return (min<number3)?min:number3;
    }

    /**
     * 解题思路:
     * 第一个丑数是1,分别用2,3,5去乘前面的丑数,所得的丑数全部继续放到丑数的数组中;
     *
     * @param index
     * @return
     */

    public int GetUglyNumber_Solution(int index) {
        if (index < 0)
            return 0;

        int[] ugly = new int[index];
        ugly[0] = 1;
        int nextUglyIndex = 1;
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        while (nextUglyIndex < index){
            int min = Min(ugly[p2]*2,ugly[p3]*3,ugly[p5]*5);
            ugly[nextUglyIndex] = min;

            while (ugly[p2] * 2 <= ugly[nextUglyIndex])
                p2++;
            while (ugly[p3] * 3 <= ugly[nextUglyIndex])
                p3++;
            while (ugly[p5] * 5 <= ugly[nextUglyIndex])
                p5++;
            nextUglyIndex++;
        }
        return ugly[index-1];
    }

    public static void main(String[] args) {
        System.out.println(new UglyNumber().GetUglyNumber_Solution(10));
    }
}
