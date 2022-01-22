package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * You are given n tasks labeled from 0 to n - 1 represented by a 2D integer array tasks,
 * where tasks[i] = [enqueueTimei, processingTimei] means that
 * the i task will be available to process at enqueueTimei and will take processingTimei to finish processing.
 *
 * You have a single-threaded CPU that can process at most one task at a time and will act in the following way:
 *
 * If the CPU is idle and there are no available tasks to process, the CPU remains idle.
 * If the CPU is idle and there are available tasks, the CPU will choose the one with the shortest processing time.
 * If multiple tasks have the same shortest processing time, it will choose the task with the smallest index.
 * Once a task is started, the CPU will process the entire task without stopping.
 * The CPU can finish a task then start a new one instantly.
 * Return the order in which the CPU will process the tasks.
 */
public class SingleThreadedCPU {

    //count by time, start from time 1
    //check by order which is enquetime <= time now
    //if there are bunch of them, choose the shortest processing
    //if there are same shortest, chose the smaller index
    //use enquetime for bucket sort, and a heap as bucket method 2

    //sort by enqueue time
    //store [index, enqueueTime, proTime]
    PriorityQueue<int[]> taskQueue = new PriorityQueue<>((p1, p2)-> p1[1] - p2[1]);
    //sort by proTime
    PriorityQueue<int[]> innerQueue = new PriorityQueue<>((p1, p2) -> {
        if(p1[2] == p2[2]){
            return p1[0] - p2[0];
        }
        return p1[2]- p2[2];
    });
    int timeNow = 0;


    public int[] getOrder(int[][] tasks) {
        int index = 0;
        int[] result = new int[tasks.length];

        for(int i=0; i<tasks.length; i++){
            taskQueue.offer(new int[]{i, tasks[i][0], tasks[i][1]});
        }

        while(!taskQueue.isEmpty()){

            updateCandidates();

            if(innerQueue.isEmpty()){
                timeNow = taskQueue.peek()[1];
                continue;
            }



            //consume all candidates, and update
            while(!innerQueue.isEmpty()){

                int[] candidate = innerQueue.poll();

                while(innerQueue.peek()[2] == candidate[2]){

                }
                // if(innerQueue.peek()[0] < candidate[0]){
                //     taskQueue.offer(candidate);
                //     candidate = innerQueue.poll();
                // }else{
                //     taskQueue.offer(innerQueue.poll());
                // }

                result[index++] = candidate[0];
                timeNow += candidate[2];
            }


            //put back to taskQueue
            // while(!innerQueue.isEmpty()){
            //     taskQueue.offer(innerQueue.poll());
            // }
        }

        return result;
    }

    private void updateCandidates(){
        while(!taskQueue.isEmpty() && taskQueue.peek()[1] <= timeNow){
            innerQueue.offer(taskQueue.poll());
        }
    }

    public static void main(String[] args) {

    }
}
