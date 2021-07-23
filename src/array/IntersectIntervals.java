package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two lists of intervals, each interval denoted as [start, end],
 * find the intersection (overlapped segments) between the lists...
 */
public class IntersectIntervals {

    public static List<Interval> intersectIntervals(List<Interval> list1, List<Interval> list2){
        List<Interval> result = new ArrayList<>();
        int i = 0, j = 0;
        while ( i < list1.size() && j < list2.size()){
            Interval iv1 = list1.get(i);
            Interval iv2 = list2.get(j);
            System.out.println("iv1:"+iv1 + " iv2:"+iv2);
            if (iv1.end < iv2.start){
                i++;
            }else if (iv2.end < iv1.start){
                j++;
            }else {
                int minEnd = Math.min(iv1.end,iv2.end);
                result.add(new Interval(
                                Math.max(iv1.start,iv2.start),
                                minEnd
                        ));
                if (minEnd==iv1.end) i++;
                else j++;
            }
        }

        return result;
    }

    public static class Interval{
        int start;
        int end;
        public Interval(int start,int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<Interval> list1 = new ArrayList<>();
        list1.add(new Interval(-100, 100));
        list1.add(new Interval(200, 300));
        List<Interval> list2 = new ArrayList<>();
        list2.add(new Interval(-50, 0));
        list2.add(new Interval(10, 20));
        list2.add(new Interval(30, 50));

        List<Interval> list = intersectIntervals(list1,list2);
        System.out.println(list);

        List<Interval> list3 = new ArrayList<>();
        list3.add(new Interval(2, 6));
        list3.add(new Interval(7, 12));
        list3.add(new Interval(15, 20));
        List<Interval> list4 = new ArrayList<>();
        list4.add(new Interval(-5, -3));
        list4.add(new Interval(-2, 0));
        list4.add(new Interval(1, 11));
        list4.add(new Interval(20, 30));
        list4.add(new Interval(40, 60));

        System.out.println(intersectIntervals(list3,list4));

    }
}
