package greedy;

import java.util.HashMap;

public class SubarraySumEqualsK {

    //traverse once to cache a hash map which contains
    //sum: [a0, a0+a1, a0+a1+a2, a0+...+a3, a0+...+an]
    //then traverse second time using two pointers,
    //every time find k = sum[i] - sum[j]  => sum[j] = sum[i] - k
    //indicate there is a sub array aj+...+ai equal to k
    public int subarraySum(int[] nums, int k) {

        int count = 0, sum = 0;
        HashMap < Integer, Integer > map = new HashMap <> ();

        //special case, when sum itself is already equal to k
        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;

    }

    public static void main(String[] args) {
        SubarraySumEqualsK solution = new SubarraySumEqualsK();

//        //expected 0
        System.out.println(solution.subarraySum(new int[]{1}, 0));

        //expected 1
        System.out.println(solution.subarraySum(new int[]{-1,-1,1}, 0));

    }


}
