package array;

import java.util.Arrays;

/**
 *  Given an array A of integers and integer K
 *  return the maximum S such that there exists i < j with A[i] + A[j] = S and S < K.
 *  If no i, j exist satisfying this equation, return -1.
 * Input : arr = {30, 20, 50} , K = 70
 * Output : 50
 * 30 + 20 = 50, which is the maximum possible sum which is less than K
 *
 * Input : arr = {5, 20, 110, 100, 10}, K = 85
 * Output : 20 + 10 = 30
 */
public class TwoSumLessThanK {

    public static int twoSumLessThanK(int[] array, int target){
        Arrays.sort(array);
        int i = 0, j = array.length-1;
        int max = 0;
        while (i<j){
            int sub = array[i] + array[j];
            if (sub<target){
                if (sub>max){
                    max = sub;
                }
                i++;
            }else {
                j--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int t1 = twoSumLessThanK(new int[]{30, 20, 50},70);
        assert t1 == 50;
        int t2 = twoSumLessThanK(new int[]{5, 20, 110, 100, 10},85);
        assert t2 == 30;
        int t3 = twoSumLessThanK(new int[]{5, 20, 110,30,21, 100, 10},40);
        assert t3 == 35;
    }


}
