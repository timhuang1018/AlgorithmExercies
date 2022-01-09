package graph;

import java.util.*;

/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
 * You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 *
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them.
 * If it is impossible to finish all courses, return an empty array.
 *
 *
 *
 * Example 1:
 *
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: [0,1]
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0.
 * So the correct course order is [0,1].
 *
 * Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 * Output: [0,2,1,3]
 * Explanation: There are a total of 4 courses to take.
 * To take course 3 you should have finished both courses 1 and 2.
 * Both courses 1 and 2 should be taken after you finished course 0.
 * So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
 *
 * Example 3:
 *
 * Input: numCourses = 1, prerequisites = []
 * Output: [0]
 */
public class CourseScheduleII {

    //make courses as nodes, and prerequisites as edges
    //build the graph and indegrees for each node
    //many valid answers means there may be multiple source and leave
    //use visited node array to prevent duplicate visited
    //use an array to keep the valid path
    //after traversing the graph, see if path size equal to courses - 1 => valid answer
    //time O(v + e)
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        Map<Integer, Set<Integer>> graph = new HashMap<>();
        int[] inDegrees = new int[numCourses];
        buildGraph(graph, inDegrees, prerequisites);

        List<Integer> path = new ArrayList<>();
        boolean[] visited = new boolean[numCourses];
        for(int node : graph.keySet()){
            if(inDegrees[node]==0){
                dfs(node, graph , inDegrees, path, visited);
            }
        }
        //check we have valid answer
        if(path.size()!= numCourses){
            return new int[0];
        }

        int[] result = new int[numCourses];
        for(int i=0; i< path.size(); i++){
            result[i] = path.get(i);
        }
        return result;
    }

    private void dfs(int node, Map<Integer, Set<Integer>> graph , int[] inDegrees, List<Integer> path, boolean[] visited){

        if(visited[node]) return;

        path.add(node);

        visited[node] = true;

        for(int child : graph.get(node)){
            inDegrees[child]--;
            if(inDegrees[child]==0){
                dfs(child, graph , inDegrees, path, visited);
            }
        }

    }

    private void buildGraph(Map<Integer, Set<Integer>> graph, int[] inDegrees, int[][] prerequisites){
        for(int i=0; i<inDegrees.length; i++){
            graph.put(i, new HashSet<>());
        }

        for(int j=0; j<prerequisites.length; j++){
            graph.get(prerequisites[j][1]).add(prerequisites[j][0]);
            inDegrees[prerequisites[j][0]]++;
        }
    }
}
