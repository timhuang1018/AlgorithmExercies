package array;

/**
 * Given an array with supposedly sequential elements starting from 0 (0 is never missing),
 * find out the kth missing element in the array.
 */
public class KthMissingNumber {
    public static int findMissingNumber(int[] nums,int k){
        int lo = 0, hi = nums.length - 1;
        //check if missing kth number is not possible
        if (nums[nums.length-1] < nums.length + k - 1) return -1;
        while (lo <= hi){
            int mid = lo + (hi-lo)/2;
            System.out.println("mid:" + mid);
            if (nums[mid+1] == mid+k+1){
                return mid+k;
            }else if (nums[mid] >= mid + k){
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
    }
}
