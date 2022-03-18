package array;

import java.util.*;

public class MinimumTimeFinishRace {

    //have to know this round whether change tire is worthy
    //calculate every tire if no change and complete til numLaps
    //start with the one can complete most laps before change tire
    public static int minimumFinishTime(int[][] tires, int changeTime, int numLaps) {

        Arrays.sort(tires, (p1,p2)-> p1[0] - p2[0]);

        long[][] noChange = new long[tires.length][numLaps];
        int[] maxLapBeforeChange = new int[tires.length];

        int[] maxLap = new int[2];
        for(int i =0; i< tires.length; i++){
            long needTime = 0;
            for(int j = 0; j< numLaps; j++){
                needTime += (long)tires[i][0] * Math.pow(tires[i][1], j);
                noChange[i][j] = needTime;
                if(needTime >= changeTime){
                    maxLapBeforeChange[i] = j + 1;
                    if(maxLapBeforeChange[i] > maxLap[0] || (maxLapBeforeChange[i] == maxLap[0] && needTime < maxLap[1])){
                        maxLap[0] = maxLapBeforeChange[i];
                        maxLap[1] = (int)needTime;
                    }
                    break; // no need to count any more
                }

            }

        }

        int time = 0;

        while(numLaps > 0){
            if(numLaps >= maxLap[0]){
                numLaps -= maxLap[0];
                time += maxLap[1];
            }else{
                //find most efficient one
                long minTime = Long.MAX_VALUE;
                for(int i = 0; i < noChange.length; i++){
                    for(int j = 0; j < noChange[0].length; j++){
                        if(j + 1 > numLaps) break; //no need more laps
                        if(j + 1 == numLaps){ //candidate answer
                            minTime = Math.min(minTime, noChange[i][j]);
                        }
                        if(noChange[i][j] >= changeTime) break; //useless tire
                    }
                }
                time += minTime;
                numLaps = 0; //finish
            }

            if(numLaps == 0) break;
            //change tire
            time += changeTime;
        }
        return time;
    }

    public static void main(String[] args) {
        //expected 21
//        minimumFinishTime(new int[][]{new int[]{2,3}, new int[]{3,4}},5,4);
        minimumFinishTime(new int[][]{new int[]{1,10}, new int[]{2,2}, new int[]{3,4}},6,5);
    }
}
