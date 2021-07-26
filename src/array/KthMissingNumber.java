package array;

/**
 * Given an array with supposedly sequential elements starting from 0 (0 is never missing),
 * find out the kth missing element in the array.
 */
public class KthMissingNumber {
    public static int findMissingNumber(int[] nums,int k){
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi){
            int mid = lo + (hi-lo)/2;
            //nums[i] - i could check for how many missing number at i index
            //check missing between mid+1 satisfy the number are left (k - how many missing now )
            if (mid!=nums.length-1 && ( k - (nums[mid] - mid) <= nums[mid+1] - (mid+1) )){
                return mid+k;
            }else if (nums[mid] - mid >= k){
                hi = mid -1;
            }else {
                lo = mid +1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int t1 = findMissingNumber(new int[]{0, 1, 2, 3, 5, 6, 7, 8, 10, 11, 12, 15, 16, 17},4);
        System.out.println(t1);

        int t2 = findMissingNumber(new int[]{0, 2, 3, 4, 5, 6, 7, 8, 9, 10},3);
        System.out.println(t2);

        //expected 4
        int t3 = findMissingNumber(new int[]{0, 1, 2, 6, 7},2);
        System.out.println(t3);
    }
}
