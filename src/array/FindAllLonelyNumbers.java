package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllLonelyNumbers {

    public List<Integer> findLonely(int[] nums) {
        List<Integer> result = new ArrayList<>();

        if(nums.length == 1){
            result.add(nums[0]);
            return result;
        }
        Arrays.sort(nums);

        for(int i = 0; i < nums.length ; i++){
            if(i < nums.length - 1 &&  nums[i] == nums[i+1]){
                continue;
            }

            if( i < nums.length - 1 && nums[i]== nums[i+1] + 1){
                continue;
            }
            if(i > 0 && nums[i]== nums[i-1] - 1){
                continue;
            }
            result.add(nums[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        FindAllLonelyNumbers solution = new FindAllLonelyNumbers();
        System.out.println(solution.findLonely(new int[]{10,6,5,8}));
    }
}
