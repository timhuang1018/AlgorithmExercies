package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
 * and return an array of the non-overlapping intervals that cover all the intervals in the input.
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 *
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 *
 * Constraints:
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 */
public class MergeIntervals {

    //prepare a list to keep result which cannot be merge
    //loop through and compare two interval at once
    // i1.start < i2.start and i1.end > i2.end -> this could be merged
    // i1.start < i2.start and i2.end < i2.end -> this could be merged
    // i1.end < i2.start -> this could not

    //time complexity is O(nlogn) if need to be sorted
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 1){
            return intervals;
        }

        Arrays.sort(intervals, (o1, o2) -> o1[0]- o2[0]);
        List<int[]> list = new ArrayList<>();

        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int i = 1; i<intervals.length; i++){
            if(end < intervals[i][0]){
                list.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }else{
                end = Math.max(intervals[i][1], end);
            }
        }

        list.add(new int[]{start, end});

        int[][] result = new int[list.size()][2];
        for(int j=0; j<list.size(); j++){
            result[j] = list.get(j);
        }

        return result;
    }
}
