package array;

import java.util.*;

/**
 * Given an array of meeting time intervals consisting of start and end times
 * [[s1,e1],[s2,e2],...] (si < ei),
 * find the minimum number of conference rooms required.
 */
public class MeetingRoomII {

    //time complexity O(nlogn)
    //space complexity O(n)
    public static int minMeetingRooms(List<IntersectIntervals.Interval> intervals){
        int max = 0,temp = 0;
        List<Pointer> pointers = new ArrayList<>();
        for (int i=0;i<intervals.size();i++){
            IntersectIntervals.Interval iv = intervals.get(i);
            pointers.add(new Pointer(iv.start,Boundary.START));
            pointers.add(new Pointer(iv.end,Boundary.END));
        }
        Collections.sort(pointers, new Comparator<Pointer>() {
            @Override
            public int compare(Pointer o1, Pointer o2) {
                return o1.location - o2.location;
            }
        });
        for (int j = 0; j<pointers.size();j++){
            Pointer p = pointers.get(j);
            if (p.boundary==Boundary.START){
                temp++;
            }else if(p.boundary==Boundary.END){
                temp--;
            }
            max = Math.max(max,temp);
        }

        return max;
    }

    public static class Pointer{
        int location;
        Boundary boundary;
        public Pointer(int location,Boundary boundary){
            this.location = location;
            this.boundary = boundary;
        }
    }

    enum Boundary{
        START,END
    }

    public static void main(String[] args) {
        List<IntersectIntervals.Interval> list2 = new ArrayList<>();
        list2.add(new IntersectIntervals.Interval(7,10));
        list2.add(new IntersectIntervals.Interval(2,4));
        System.out.println(
                minMeetingRooms(list2)
        );

        List<IntersectIntervals.Interval> list = new ArrayList<>();
        list.add(new IntersectIntervals.Interval(0,30));
        list.add(new IntersectIntervals.Interval(5,10));
        list.add(new IntersectIntervals.Interval(15,20));
        System.out.println(
                minMeetingRooms(list)
        );
    }
}
