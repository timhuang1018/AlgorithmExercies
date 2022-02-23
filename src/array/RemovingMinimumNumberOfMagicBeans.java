package array;

import java.util.Arrays;

public class RemovingMinimumNumberOfMagicBeans {

    public long minimumRemoval(int[] beans) {
        if(beans.length == 1) return 0;
        Arrays.sort(beans);

        long total = 0;
        for(int i = 0; i < beans.length; i++){
            total += beans[i];
        }
        long min = total;
        int index = 0;
        while(index < beans.length){
            min = Math.min(min, total - (long) (beans.length - index) * beans[index]);
            index++;
        }

        return min;
    }

    //first thought: is equal number important ? seems not by above 2 examples
    //sort to make ascending will help
    //prefix sum ?
    //binary search
//    public long minimumRemoval(int[] beans) {
//        if(beans.length == 1) return 0;
//        Arrays.sort(beans);
//
//        long[] preSum = new long[beans.length];
//        preSum[0] = beans[0];
//        for(int i = 1; i < beans.length; i++){
//            preSum[i] = (preSum[i-1] + beans[i]);
//        }
//
//        int left = 0, right = beans.length - 1;
//        //make min the biggest answer first
//        long min = 0;
//        for(int i = 1; i<beans.length; i++){
//            min += (beans[i]);
//        }
//
//        while(left <= right){
//
//            int mid = left + (right - left)/2;
//            int midValue = beans[mid];
//            long sum = 0;
//
//            //cut right
//            for(int i = mid+1; i<beans.length; i++){
//                sum += (beans[i] - midValue);
//            }
//            //cut left
//            sum += (preSum[mid] - midValue);
//
//            if(sum <= min){ //try to find optimized answer
//                min = sum;
//                left++;
//            }else{
//                right--;
//            }
//
//        }
//
//        return min;
//    }

    public static void main(String[] args) {
        RemovingMinimumNumberOfMagicBeans solution  = new RemovingMinimumNumberOfMagicBeans();
        //expected 7
        System.out.println(solution.minimumRemoval(new int[]{2,10,3,2}));

        //expected 158
        System.out.println(solution.minimumRemoval(new int[]{23,52,45,28,84,3,82,87}));

    }
}
