package array;

import java.util.*;

public class CountArrayPairsDivisibleByK {

    public static long coutPairs(int[] nums, int k) {
        long pairs = 0;

        //prevent duplicate
        Map<Integer, Integer> numCount = new HashMap<>();

//        for(int num: nums){
//            numCount.put(num, numCount.getOrDefault(num, 0) + 1);
//        }
//
//        int total = nums.length;
//        for(int candidate : numCount.keySet()){
//            if(candidate % k == 0){
//                total -= numCount.get(candidate);
//                pairs += numCount.get(candidate) * total;
//            }
//        }


        Map<Integer, List<Integer>> map = new HashMap<>();


        //skip n = 1, just compare if any value == k when finding
        for(int n = 2; n <= (k+1)/2; n++){
            if(k % n == 0){ //dividable

                for(int num : nums){
                    if(num % n == 0){
                        if(map.containsKey(k / n)){
                            pairs += map.get(k / n).size();
                            continue;
                        }

                        if(!map.containsKey(n)){
                            map.put(n, new ArrayList<>());
                        }
                        map.get(n).add(num);
                    }
                }
            }
        }


        return pairs;
    }

    public static void main(String[] args) {
        long t1 = coutPairs(new int[]{8,10,2,5,9,6,3,8,2}, 6);
        System.out.println(t1);
    }
}
