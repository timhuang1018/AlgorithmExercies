package array;

import java.util.*;

public class FourSum {

    //find total tuples we need find each tuple
    //(i, j, k, l) if different should count as 1 tuple
    //it means if brute force it would be O(n4) -> n * n * n * n
    //length are same for these 4 arrays

    //so actually we can merge each two arrays into one collection
    //use map to make duplicate into counts, then we can just multiply value, no need to find each

    //TODO refactor to find answer in second merging map
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int total = 0;
        //    value,  count
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map3 = new HashMap<>();
        for(int num1 : nums1){
            for(int num2 : nums2){
                map1.put(num1 + num2, map1.getOrDefault(num1 + num2, 0) + 1);
            }
        }

        //combine arr3, arr4
        for(int num3 : nums3){
            for(int num4 : nums4){
                map3.put(num3 + num4, map3.getOrDefault(num3 + num4, 0) + 1);
            }
        }

        Set<Integer> set1 = new HashSet<>();
        for(int sumBy2arr : map1.keySet()){
            if(set1.contains(sumBy2arr)) continue; //pass visited
            set1.add(sumBy2arr);

            if(map3.containsKey(-sumBy2arr)){
                total += map1.get(sumBy2arr)
                        * map3.get(-sumBy2arr);
            }
        }

        return total;
    }

    public static void main(String[] args) {

    }
}
