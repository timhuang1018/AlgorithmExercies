package graph;

import helper.DataLogger;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {

    //start from 0
    //link node and put in path until the end, which is an empty array
    //backtrack and try another node
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);

        dfs(graph, 0,  path, result);

        return result;
    }

    public void dfs(int[][] graph, int node, List<Integer> path, List<List<Integer>> result){

        //end
        if(node == graph.length -1){
            result.add(new ArrayList<>(path));
            return;
        }

        //try all neighbors
        for(int nextNode : graph[node]){
            path.add(nextNode);
            dfs(graph, nextNode, path, result);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        AllPathsFromSourceToTarget solution = new AllPathsFromSourceToTarget();
        //expected [[0,1,3],[0,2,3]]
        System.out.println(solution.allPathsSourceTarget(new int[][]{new int[]{1,2},new int[]{3},new int[]{3},new int[]{}}));
    }
}
