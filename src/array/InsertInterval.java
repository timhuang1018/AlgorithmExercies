package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of non-overlapping intervals,
 * insert a new interval into the intervals (merge if necessary).
 *
 * You may assume that the intervals were initially sorted according to their start times.
 */
public class InsertInterval {

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int start = newInterval[0], end = newInterval[1];

        for (int i = 0; i<intervals.length;i++){
            //e2 < s1
            if ( intervals[i][1] < start){
                result.add(intervals[i]);
            }
            //e1 < s2
            else if (end < intervals[i][0]){
                result.add(new int[]{start,end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
            //union
            else {
                start = Math.min(start,intervals[i][0]);
                end = Math.max(end,intervals[i][1]);
            }
        }
        result.add(new int[]{start,end});
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        insert(new int[][]{{1,3},{6,9}}, new int[]{2,5});
    }

}
