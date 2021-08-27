package heap;

import helper.ArrayGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * Given a characters array tasks, representing the tasks a CPU needs to do,
 * where each letter represents a different task.
 * Tasks could be done in any order. Each task is done in one unit of time.
 * For each unit of time, the CPU could complete either one task or just be idle.
 *
 * However, there is a non-negative integer n that represents the cooldown period
 * between two same tasks (the same letter in the array),
 * that is that there must be at least n units of time between any two same tasks.
 *
 * Return the least number of units of times that the CPU will take to finish all the given tasks.
 *
 * 1 <= task.length <= 104
 * tasks[i] is upper-case English letter.
 * The integer n is in the range [0, 100]
 */
public class TaskScheduler {

    public static int leastInterval(char[] tasks, int n) {
        int[] taskCount = new int[26];
        for (int i=0; i<tasks.length; i++){
            taskCount[tasks[i]-'A']++;
        }

        PriorityQueue<int[]> taskHeap = new PriorityQueue<>((p1,p2)->p2[1]-p1[1]);
        for (int j=0; j<taskCount.length; j++){
            if(taskCount[j]>0){
                taskHeap.offer(new int[]{j,taskCount[j]});
            }
        }

        int units = 0;

        while (!taskHeap.isEmpty()){
            //temp container for task already used in each loop
            Stack<int[]> tempStack = new Stack<>();
            int interval = n;

            while (interval>=0){
                if (!taskHeap.isEmpty()){
                    int[] task = taskHeap.poll();
                    units++;
                    //still have
                    if (--task[1]>0){
                        tempStack.add(task);
                    }

                }else if (!tempStack.isEmpty()){  //need for another loop, fill up interval with idle
                    units++;
                }
                interval--;
            }

            while (!tempStack.isEmpty()){
                taskHeap.offer(tempStack.pop());
            }
        }


        return units;
    }

    public static void main(String[] args) {
        int testcase1 = leastInterval(new char[]{'A','A','A','B','B','B'},2);
        System.out.println(testcase1);

        char[] chars = ArrayGenerator.fromStringArray(new String[]{"A","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"});
        int testcase2 = leastInterval(chars, 29);
        System.out.println(testcase2);
    }
}
