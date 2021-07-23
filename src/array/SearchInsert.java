package array;

/**
 * Given a sorted array of distinct integers and a target value,
 * return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 * You must write an algorithm with O(log n) runtime complexity.
 */
public class SearchInsert {

    public static int searchInsert(int[] nums, int target) {
        int lo = 0, hi = nums.length-1;
        if (target<nums[0]){
            return 0;
        }
        while (lo<=hi){
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target){
                return mid;
            }else if (mid == nums.length-1 || (nums[mid]<target && nums[mid+1]>target)){
                return mid + 1;
            }else if (nums[mid]>target){
                hi = mid - 1;
            }else {
                lo = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] num = new int[]{1,3,5,6};
        int index = searchInsert(num,7);
        System.out.println(index);

        int index2 = searchInsert(num,0);
        System.out.println(index2);

        int index3 = searchInsert(num,2);
        System.out.println(index3);
    }

}
