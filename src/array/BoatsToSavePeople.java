package array;

import java.util.Arrays;

public class BoatsToSavePeople {


    //time O(nlogn)
    //space O(1)
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0, right = people.length -1, count = 0;

        while(left <= right){
            if(people[left] + people[right] <= limit){
                left++;
            }
            count++;
            right--;
        }


        return count;
    }

    public static void main(String[] args) {
        BoatsToSavePeople solution = new BoatsToSavePeople();
        //expected 2
        System.out.println(solution.numRescueBoats(new int[]{2,4}, 5));
    }
}
