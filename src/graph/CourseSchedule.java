package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //build the graph and count how many in-degree (parents) for each course
        Map<Integer, List<Integer>> graph = getGraph(numCourses, prerequisites);
        Map<Integer, Integer> parents = getParentCount(graph);

        List<Integer> order = new ArrayList<>();

        for (Integer node : graph.keySet()){
            dfs(node, parents, graph, order);
        }

        return order.size() == numCourses;
    }


    private void dfs(Integer node, Map<Integer, Integer> parents, Map<Integer, List<Integer>> graph, List<Integer> order){
        //only the current node at top can enter
        //start from source node
        if (parents.containsKey(node) && parents.get(node)!=0){
            return;
        }

        order.add(node);
        parents.put(node, -1);
        //after visited this node, decrement children parent count, to see who is next candidate
        for (int child: graph.get(node)){
            parents.put(child, parents.get(child) - 1);
            dfs(child, parents, graph, order);
        }
    }

    private Map<Integer, List<Integer>> getGraph(int courses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i<courses; i++){
            graph.put(i, new ArrayList<>());
        }

        for (int[] dependClass : prerequisites){
            graph.get(dependClass[1]).add(dependClass[0]);
        }

        return graph;
    }

    private Map<Integer, Integer> getParentCount(Map<Integer, List<Integer>> graph){
        Map<Integer, Integer> map = new HashMap<>();
        for(Integer node : graph.keySet()){
            for (Integer child : graph.get(node)){
                map.put(child,map.getOrDefault(child ,0) + 1);
            }
        }

        return map;
    }
}
