package array;

/**
 * You are given a sorted array consisting of only integers where every element appears exactly twice,
 * except for one element which appears exactly once.
 * Find this single element that appears only once
 */
public class SingleNonDuplicate {

    //TODO not solved yet
    public static int singleNonDuplicate(int[] nums){
        int lo = 0, hi = nums.length-1;
        while (lo<=hi){
            int mid = lo + ( hi - lo )/2;
            System.out.println("mid:"+mid);
            if (nums[mid-1]!=nums[mid] && nums[mid+1]!=nums[mid]){
                return mid;
            }else if (nums[mid-1] == nums[mid]){
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int t1 = singleNonDuplicate(new int[]{1,1,2,3,3,4,4,8,8});
        System.out.println(t1);
    }
}
