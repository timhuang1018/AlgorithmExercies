package array;

import helper.DataLogger;

public class PourWater {

    //recalculate everytime after a water drop
    //cause might make the dropping index and order change
    //same way but previous index
    public int[] pourWater(int[] heights, int waterUnits, int k) {
        int index = k;
        while(waterUnits>0){

            while(index > 0 && heights[index-1] <= heights[index]){
                index--;
            }
            while(index < heights.length-1 && heights[index+1] <= heights[index]){
                index++;
            }

            while (index > k && heights[index] == heights[index-1]){
                index--;
            }
            heights[index]++;
            waterUnits--;
        }

        return heights;
    }





    //use one pointer , because two pointer is hard to describe
    //when heights[left] <= heights[index] but if every value is equal, you want the closest value to index
    //one pointer can adjust the pointer by following rule while two pointer cannot
    public int[] pourWater2(int[] heights, int waterUnits, int index) {

        while(waterUnits>0){
            int left = index - 1; int right = index + 1;


            /**
             * wrong condition here for example
             */
            while(left > 0 && heights[left] <= heights[index]){
                left--;
            }
            /**
             * wrong condition here for example
             */
            while(right < heights.length -1 && heights[right] <= heights[index]){
                right++;
            }

            if(left >= 0 && heights[left] < heights[index]){
                heights[left]++;
            }else if(right < heights.length && heights[right] < heights[index]){
                heights[right]++;
            }else {
                heights[index]++;
            }
            waterUnits--;
        }

        DataLogger.printIntArray(heights);
        return heights;
    }

    public static void main(String[] args) {
        PourWater solution = new PourWater();

        //expected [4,4,4,4,3,3,3,3,3,4,3,2,1]
        solution.pourWater(new int[]{1,2,3,4,3,2,1,2,3,4,3,2,1}, 10, 2);
    }
}
