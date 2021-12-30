package graph;

import java.util.*;

public class MinimumTimeToCompleteTasks {

    /**
     * @param tasks contains array of task String,each task may be format
     *              "taskId|prerequisite|time" or just "taskId|time" if no prerequisite task
     * @return minimum of time unit need to complete tasks
     */
    int leastTime = 0;
    public int minTime(String[] tasks){
        Map<String, Integer> timeTable = new HashMap<>();
        Map<String, Integer> parentCount = new HashMap<>();
        //build graph along with time table and parent count (in-degree)
        Map<String, Set<String>> graph = buildGraph(tasks, timeTable, parentCount);

        for(String task : parentCount.keySet()){
            if(parentCount.get(task) == 0){
                dfs(task, graph, timeTable, timeTable.get(task));
            }
        }

        return leastTime;
    }

    private void dfs(String task, Map<String, Set<String>> graph, Map<String, Integer> timeTable, int time) {
        if (graph.get(task).isEmpty()){ // find the final task and keep the maximum
            leastTime = Math.max(leastTime, time);
        }else{
            //backtrack to visit all possible path to find the maximum time
            for (String childTask : graph.get(task)){
                time += timeTable.get(childTask);
                dfs(childTask, graph, timeTable, time);
                time -= timeTable.get(childTask);
            }
        }
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
                parentCount.put(segments[0],0);
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
//        System.out.println(solution.minTime(new String[]{"A|B C|4","B|C D|3","C|D|3","D|2"}));

        //expected 9 , D -> C&B in parallel -> A , 2 + max(1,3) + 4 = 9
        System.out.println(solution.minTime(new String[]{"A|B C|4","B|D|1","C|D|3","D|2"}));

    }
}
