package greedy;

public class MajorityElement {
    //must be one number have more element than half n
    public int majorityElement(int[] nums) {
        if (nums.length==1) return nums[0];
        int majorty = nums[0];
        int times = 0;
        for (int i=1; i<nums.length; i++){
            if (times<0){
                majorty = nums[i];
                times = 0;
            } else if (nums[i]==majorty){
                times++;
            }else {
                times--;
            }
        }
        return majorty;
    }
}
