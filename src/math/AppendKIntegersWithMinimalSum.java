package math;

import java.util.*;

public class AppendKIntegersWithMinimalSum {

    public static long minimalKSum(int[] nums, int k) {
        long sum = 0;
        Arrays.sort(nums);

        Set<Integer> blackList = new HashSet<>();

        //include necessary num
        for(int num : nums){
            if(num <= k && !blackList.contains(num)){
                k++;
                blackList.add(num);
            }
            if(num > k){
                break;
            }
        }
        sum = ((long)k*(k + 1))/2;

        blackList = new HashSet<>();
        //exclude num
        for(int num : nums){
            if(num <= k && !blackList.contains(num)){
                sum -= num;
                blackList.add(num);
            }

            if(num > k){
                break;
            }
        }

        System.out.println(sum);
        return sum;
    }

    public static void main(String[] args) {
        //expected 25
//        minimalKSum(new int[]{5,6},6);
        //expected 3444
//        minimalKSum(new int[]{53,41,90,33,84,26,50,32,63,47,66,43,29,88,71,28,83},76);
        //expected 794
//        minimalKSum(new int[]{96,44,99,25,61,84,88,18,19,33,60,86,52,19,32,47,35,50,94,17,29,98,22,21,72,100,40,84},35);

    }
}
