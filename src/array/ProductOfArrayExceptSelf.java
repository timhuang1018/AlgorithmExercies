package array;

import helper.DataLogger;

public class ProductOfArrayExceptSelf {

    //[5,2,3,4] -> [24,60, 40,30]
    //compute start from left, multiply each index together
    //[1,5,10,30] (1, 5, 5*2, 5*2*3)
    //compute start from right, multiply each index together
    //[24,12,4,1] (4*3*2, 4*3, 4 ,1)
    //merge and multiply into one
    //[24,60,40,30] (1*24, 5*12, 10*4, 30*1)

    //time O(n)
    //space O(1) not consider final result array
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        int tempSub1 = 1;
        for(int i=0; i<nums.length; i++){
            result[i] = tempSub1;
            tempSub1 *= nums[i];
        }

        int tempSub2 = 1;
        for(int j= nums.length-1; j>=0; j--){
            result[j] *= tempSub2;
            tempSub2 *= nums[j];
        }




        return result;
    }

    //time O(n)
    //space O(n)
    public int[] productExceptSelf2(int[] nums){
        int[] result = new int[nums.length];
        int[] tempArr = new int[nums.length];

        int tempSub1 = 1;
        for(int i=0; i<nums.length; i++){
            result[i] = tempSub1;
            tempSub1 *= nums[i];
        }

        int tempSub2 = 1;
        for(int j= nums.length-1; j>=0; j--){
            tempArr[j] = tempSub2;
            tempSub2 *= nums[j];
        }

        for(int k=0; k<nums.length; k++){
            result[k] *= tempArr[k];
        }
        return result;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf solution = new ProductOfArrayExceptSelf();
        //expected [0,0,9,0,0]
        solution.productExceptSelf(new int[]{-1,1,0,-3,3});
    }
}
