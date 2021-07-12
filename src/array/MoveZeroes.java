package array;

public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        if(nums.length<=1){
            return;
        }
        int swapIndex = 0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]!=0){
                nums[swapIndex] = nums[i];
                swapIndex++;
            }
        }
        for (;swapIndex<nums.length;swapIndex++){
            nums[swapIndex] = 0;
        }
    }

}
