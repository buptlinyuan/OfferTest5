/**
 * Created by toryang on 16/3/18.
 */

import java.util.Arrays;

/**
 * 题目描述:
 * 如何得到一个数据流中的中位数？
 * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 *
 */
public class GetMidInStream {
    static int[] seq = new int[0];
    public void Insert(Integer num) {
        //      int stop = list.size(), start = 0;
        int stop = seq.length-1, start = 0;
        if(seq.length == 0){
            seq = Arrays.copyOf(seq, 1);
            seq[0] = num;
        }else{
            while(stop >= start){
                int mid = (start+stop) >>> 1;
                if(seq[mid] < num){
                    start = mid + 1;
                }else if(seq[mid] > num){
                    stop = mid - 1;
                }else{ // key == mid
                    seq = Arrays.copyOf(seq, seq.length+1);
                    for(int i = seq.length-1;i > mid;i--){
                        seq[i] = seq[i-1];
                    }
                    seq[mid] = num;
                    break;
                }
            }
            if(start > seq.length-1){//num bigger than last key
                seq = Arrays.copyOf(seq, seq.length+1);
                seq[start] = num;
            }else if(stop < 0){ //num less than first key
                seq = Arrays.copyOf(seq, seq.length+1);
                for(int i = seq.length-1; i >0;i--){
                    seq[i] = seq[i-1];
                }
                seq[start] = num;
            }else{ // num in between the seq
                seq = Arrays.copyOf(seq, seq.length+1);
                for(int i = seq.length-1; i > start;i--){
                    seq[i] = seq[i-1];
                }
                seq[start] = num;
            }
        }
    }

    public Double GetMedian() {
        int len = seq.length;
        if(len %2 ==0){
            return (seq[len/2]+seq[len/2-1])/2.0;
        }
        return seq[len/2]*1.0;
    }

}
