package greedy;

/**
 * return left and right index of Max sub array
 */
public class MaxSubArrayPair {

    public static int[] maxSubArray(int[] nums) {
        int temp = nums[0];
        int max = nums[0];
        int left = 0, right = 0;
        int[] result = new int[2];
        for (int i=1; i<nums.length; i++){
            if(temp + nums[i] <= nums[i]){
                temp = nums[i];
                left = i;
                right = i;
            }else {
                temp += nums[i];
                right = i;
            }
            if (temp>max){
                max = temp;
                result[0] = left;
                result[1] = right;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int[] t1 = maxSubArray(arr);
        //expected {3,6}
        System.out.println(t1[0]+" and "+t1[1]);

        int[] t2 = maxSubArray(
                new int[]{-1, 3, -2, 4, -3, 6, -10, 1, 1, -3, 2, -1, 4, -9}
        );
        //expected {1,5}
        System.out.println(t2[0]+" and "+t2[1]);

    }
}
