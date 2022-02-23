package array;

public class RearrangeArray {

    public int[] rearrangeArray(int[] nums) {
        boolean needPos = true;
        int left = 0, right = 0;

        //check if left stay at the index need swap or move on til satisfy
        //check what left need is right have or right move on til satisfy
        while(right < nums.length){
            if(right <= left){
                right++;
                continue;
            }

            if(needPos){
                if(nums[left] > 0){
                    left++;
                    needPos = false;
                }else{
                    if(nums[right] > 0){
                        int temp = nums[left];
                        nums[left] = nums[right];
                        nums[right] = temp;
                        needPos = false;
                        left++;
                    }else{
                        right++;
                    }
                }
            }else{
                if(nums[left] < 0){
                    left++;
                    needPos = true;
                }else{
                    if(nums[right] < 0){
                        int temp = nums[left];
                        nums[left] = nums[right];
                        nums[right] = temp;
                        needPos = true;
                        left++;
                    }else{
                        right++;
                    }
                }
            }
        }

        return nums;

    }

    public static void main(String[] args) {
        RearrangeArray solution = new RearrangeArray();
        System.out.println(solution.rearrangeArray(new int[]{1,2,-1,-2}));
    }
}
