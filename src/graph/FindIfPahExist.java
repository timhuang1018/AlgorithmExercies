package graph;

import java.util.*;

public class FindIfPahExist {

    public boolean validPath(int n, int[][] edges, int start, int end) {
        if (start == end) return true;
        //use bi-dir edges to build graph
        //use starting point to do dfs
        //only reach end will result true, other cases are false
        Set<Integer> visited = new HashSet<>();
        Map<Integer, List<Integer>> graph = buildGraph(edges);
        for(Integer node : graph.keySet()){
            if(node == start && dfs(node, end, graph, visited)) return true;
        }

        return false;
    }

    public boolean dfs(int node, int end, Map<Integer, List<Integer>> graph, Set<Integer> visited){
        if(node == end){
            return true;
        }

        if(visited.contains(node)) return false;
        visited.add(node);

        for(int child : graph.get(node)){
            if(dfs(child, end, graph, visited)) return true;
        }

        return false;
    }

    public Map<Integer, List<Integer>> buildGraph(int[][] edges){

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int[] edge: edges){

            if(!graph.containsKey(edge[0])){
                graph.put(edge[0], new ArrayList<>());
            }
            graph.get(edge[0]).add(edge[1]);

            if(!graph.containsKey(edge[1])){
                graph.put(edge[1], new ArrayList<>());
            }
            graph.get(edge[1]).add(edge[0]);

        }
        return graph;
    }

    public static void main(String[] args) {
        FindIfPahExist solution = new FindIfPahExist();
        //expected true
        System.out.println(solution.validPath(5, new int[][]{new int[]{0,4}}, 0, 4));

        //expected true
        System.out.println(solution.validPath(1, new int[][]{},0, 0));
    }
}
