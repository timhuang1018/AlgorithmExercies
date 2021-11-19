package graph;

import java.util.*;

/**
 * Givennnodes labeled from 0 to n - 1 and a list of undirected edges
 * (each edge is a pair of nodes), write a function to find the number of connected components in an undirected graph.
 *
 * Example 1:
 * Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.
 *
 * Example 2:
 * Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.
 * Note:
 * You can assume that no duplicate edges will appear in edges.
 * Since all edges are undirected,[0, 1]is the same as[1, 0]and thus will not appear together inedges.
 */
public class NumberOfConnectedComponentsInUndirectedGraph {

    //convert edges into adjacency list
    //dfs each node in the list, one dfs will visit all node in component
    //if visited nodes not have the node, mean there is a new component
    // time complexity O(n) space complexity O(n)
    public int countComponents(int n, int[][] edges){
        if (n <= 1){
            return n;
        }
        Map<Integer, List<Integer>> nodes = getEdgesIntoNodes(edges);
        Set<Integer> visited = new HashSet<>();
        int component = 0;
        for (Integer node : nodes.keySet()){
            System.out.println(node);
            if (!visited.contains(node)){
                component++;
                dfsVisit(node, nodes, visited);
            }
        }
        return component + (nodes.size() == n ? 0 : (n - nodes.size()));
    }

    private void dfsVisit(Integer node, Map<Integer, List<Integer>> nodes, Set<Integer> visited) {
        if (visited.contains(node)) return;

        visited.add(node);
        List<Integer> children = nodes.get(node);
        for (Integer child : children){
            dfsVisit(child, nodes, visited);
        }
    }

    private Map<Integer, List<Integer>> getEdgesIntoNodes(int[][] edges) {
        Map<Integer, List<Integer>> nodes = new HashMap<>();

        for (int[] edge : edges){
            int node = edge[0];
            int toNode = edge[1];
            nodes.put(node, new ArrayList<>());
            nodes.put(toNode, new ArrayList<>());
        }
        for (int[] edge : edges){
            int node = edge[0];
            int toNode = edge[1];
            nodes.get(node).add(toNode);
            nodes.get(toNode).add(node);
        }

        return nodes;
    }

    public static void main(String[] args) {
        NumberOfConnectedComponentsInUndirectedGraph solution = new NumberOfConnectedComponentsInUndirectedGraph();

        //expected 2
        System.out.println(solution.countComponents(5, new int[][]{new int[]{0, 1}, new int[]{1, 2},new int[]{3, 4}}));

        //expected 1
        System.out.println(solution.countComponents(5, new int[][]{new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 3},new int[]{3, 4}}));


        //expected 3
        System.out.println(solution.countComponents(7, new int[][]{new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 3},new int[]{3, 4}}));
    }
}
