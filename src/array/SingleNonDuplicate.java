package array;

/**
 * You are given a sorted array consisting of only integers where every element appears exactly twice,
 * except for one element which appears exactly once.
 * Find this single element that appears only once
 */
public class SingleNonDuplicate {

    public static int singleNonDuplicate(int[] nums){
        if (nums.length==1) return nums[0];
        int lo = 0, hi = nums.length-1;
        while (lo<=hi){
            int mid = lo + ( hi - lo )/2;
            System.out.println("mid:"+mid);
            if ((mid==0 || nums[mid-1]!=nums[mid]) && ( mid== nums.length-1 || nums[mid+1]!=nums[mid])){
                return nums[mid];
            }
            int index = 0;

            if (nums[mid]!=nums[mid-1]){
                index = mid;
            }else {
                index = mid-1;
            }

            if (index % 2 == 1){
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        //should be 2
//        int t1 = singleNonDuplicate(new int[]{1,1,2,3,3,4,4,8,8});
//        System.out.println(t1);
//        //should be 4
//        int t2 = singleNonDuplicate(new int[]{3,3,7,7,10,11,11});
//        System.out.println(t2);
        //should be 4
        int t3 = singleNonDuplicate(new int[]{1,1,2});
        System.out.println(t3);
    }
}
