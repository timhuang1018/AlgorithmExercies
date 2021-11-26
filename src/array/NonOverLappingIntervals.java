package array;

import java.util.Arrays;

public class NonOverLappingIntervals {

    //[[1,100],[11,22],[1,11],[2,12]]

    //sort start indices by end value, compare each two:
    //if overlapping -> increment count
    //or compare next two
    //time O(nlogn) , space O(1)
    public int eraseOverlapIntervals(int[][] intervals) {

        //ascending by end value
        Arrays.sort(intervals, (o1, o2) -> o1[1] - o2[1] );

        int count =0, end = intervals[0][1];

        for(int i =1; i < intervals.length; i++){
            if(intervals[i][0] >= end){
                end = intervals[i][1];
            }else{
                count++;
            }
        }

        return count;
    }
}
