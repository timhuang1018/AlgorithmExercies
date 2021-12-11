package greedy;


import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumNumberOfRefuelingStops {

    //TODO solve this with dp

    //first thought
    //from start point within startFuel
    //use startFuel to find all stations and store into heap
    //startFuel already pass target => return count
    //can't reach target and next station, poll and add one fuel
    public static int minRefuelStops(int target, int startFuel, int[][] stations) {
        int count = -1, totalFuel = 0, index =0;
        Queue<Integer> fuels = new PriorityQueue<>((p1,p2) -> p2-p1);
        fuels.offer(startFuel);
        while(!fuels.isEmpty()){
            totalFuel += fuels.poll();
            count++;
            if( totalFuel >= target){
                return count;
            }
            while (index < stations.length && stations[index][0] <= totalFuel){
                fuels.offer(stations[index][1]);
                index++;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        //expected 3
//        System.out.println(minRefuelStops(100 ,25,new int[][]{
//                new int[]{25,25},new int[]{50,25},new int[]{75,25}
//        }));;

        //expected 4
//        System.out.println(
//                minRefuelStops(1000,299,
//        new int[][]{
//                new int[]{13,21},new int[]{26,115},
//                new int[]{100,47},new int[]{225,99},
//                new int[]{299,141}, new int[]{444,198},
//                new int[]{608,190}, new int[]{636,157},
//                new int[]{647,255}, new int[]{841,123}
//        })
//        );

        //expected 2
        System.out.println(
                minRefuelStops(100 ,10, new int[][]{
                        new int[]{10,60},
                        new int[]{20,30},
                        new int[]{30,30},
                        new int[]{60,40}
                })
        );
    }
}
