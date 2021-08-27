package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * There are n different online courses numbered from 1 to n.
 * You are given an array courses where courses[i] = [durationi, lastDayi] indicate that
 * the ith course should be taken continuously for durationi days and must be finished before or on lastDayi.
 *
 * You will start on the 1st day and you cannot take two or more courses simultaneously.
 *
 * Return the maximum number of courses that you can take.
 */
public class CourseScheduleIII {

    public static int scheduleCourse(int[][] courses) {

        //min heap to make earliest last day at top
        PriorityQueue<int[]> coursesQueue = new PriorityQueue<>(Comparator.comparingInt(p -> p[1]));

        //all courses taken up until each loop, longest at top
        PriorityQueue<Integer> durations = new PriorityQueue<>((p1,p2)-> p2 - p1);

        for (int i=0; i<courses.length; i++){
            coursesQueue.offer(courses[i]);
        }

        int availableCount = 0,startTime = 0;

        while (!coursesQueue.isEmpty()){
            int[] course = coursesQueue.poll();
            int duration = course[0], endTime = course[1];

            if (startTime + duration<=endTime){
                availableCount++;
                durations.offer(duration);
                startTime += duration;
            }else if (!durations.isEmpty() && duration<durations.peek()){
                //replace longer course with shorter one
                startTime -= durations.poll();
                durations.offer(duration);
                startTime += duration;
            }
        }

        return availableCount;
    }

    public static void main(String[] args) {
        //expected 2
        System.out.println(scheduleCourse(new int[][]{ new int[]{1,2},new int[]{2,3}}));

        //expected 2 , this is edge case
        System.out.println(scheduleCourse(new int[][]{ new int[]{5,5},new int[]{4,6},new int[]{2,6}}));
    }
}
