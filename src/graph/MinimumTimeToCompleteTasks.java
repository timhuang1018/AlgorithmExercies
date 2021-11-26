package graph;

import java.util.*;

public class MinimumTimeToCompleteTasks {

    /**
     * @param tasks contains array of task String,each task may be format
     *              "taskId|prerequisite|time" or just "taskId|time" if no prerequisite task
     * @return minimum of time unit need to complete tasks
     */
    //use BFS because each level(period) could parallel the tasks which have same 0 in-degree
    public int minTime(String[] tasks){
        int minTime = 0;
        Map<String, Integer> timeTable = new HashMap<>();
        Map<String, Integer> parentCount = new HashMap<>();
        //build graph along with time table and parent count (in-degree)
        Map<String, Set<String>> graph = buildGraph(tasks, timeTable, parentCount);

        Queue<String> queue = new LinkedList<>();
        for (String task : graph.keySet()){
            if (!parentCount.containsKey(task) || parentCount.get(task)==0){
                queue.offer(task);
            }
        }
        while (!queue.isEmpty()){
            int size = queue.size();
            //compare each level , only max time in this level will be record
            int maxInPeriod = Integer.MIN_VALUE;
            for (int i =0; i<size; i++){
                String node = queue.poll();
                maxInPeriod = Math.max(maxInPeriod, timeTable.get(node));

                for (String child: graph.get(node)){
                    parentCount.put(child, parentCount.get(child) - 1);
                    if(parentCount.get(child)==0){
                        queue.offer(child);
                    }
                }
            }
            minTime += maxInPeriod;
        }

        return minTime;
    }


    private Map<String, Set<String>> buildGraph(String[] tasks, Map<String, Integer> timeTable, Map<String, Integer> parentCount) {
        Map<String, Set<String>> graph = new HashMap<>();

        for (String task : tasks){
            String[] segments = task.split("\\|");
            if (!graph.containsKey(segments[0])){
                graph.put(segments[0], new HashSet<>());
            }
            //no prerequisite task
            if (segments.length<3){
                timeTable.put(segments[0], Integer.parseInt(segments[1]));
            }else {
                timeTable.put(segments[0], Integer.parseInt(segments[2]));

                //every prerequisite increment task in-degree
                for (String prerequisite : segments[1].split(" ")){
                    if (!graph.containsKey(prerequisite)){
                        graph.put(prerequisite, new HashSet<>());
                    }
                    graph.get(prerequisite).add(segments[0]);
                    parentCount.put(segments[0], parentCount.getOrDefault(segments[0], 0)+1);
                }

            }
        }
        return graph;
    }

    public static void main(String[] args) {
        MinimumTimeToCompleteTasks solution = new MinimumTimeToCompleteTasks();

        //expected 12 , D -> C -> B -> A
        System.out.println(solution.minTime(new String[]{"A|B C|4","B|C D|3","C|D|3","D|2"}));

        //expected 9 , D -> C&B in parallel -> A , 2 + max(1,3) + 4 = 9
        System.out.println(solution.minTime(new String[]{"A|B C|4","B|D|1","C|D|3","D|2"}));

    }
}
