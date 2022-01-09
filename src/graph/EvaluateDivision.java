package graph;

import java.util.*;

/**
 * You are given an array of variable pairs equations and an array of real numbers values,
 * where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i].
 * Each Ai or Bi is a string that represents a single variable.
 *
 * You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.
 *
 * Return the answers to all queries. If a single answer cannot be determined, return -1.0.
 *
 * Note: The input is always valid.
 * You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.
 *
 *
 *
 * Example 1:
 *
 * Input: equations = [["a","b"],["b","c"]],
 * values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
 * Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
 * Explanation:
 * Given: a / b = 2.0, b / c = 3.0
 * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
 * return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
 * Example 2:
 *
 * Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0],
 * queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
 * Output: [3.75000,0.40000,5.00000,0.20000]
 * Example 3:
 *
 * Input: equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
 * Output: [0.50000,2.00000,-1.00000,-1.00000]
 *
 * Constraints:
 *
 * 1 <= equations.length <= 20
 * equations[i].length == 2
 * 1 <= Ai.length, Bi.length <= 5
 * values.length == equations.length
 * 0.0 < values[i] <= 20.0
 * 1 <= queries.length <= 20
 * queries[i].length == 2
 * 1 <= Cj.length, Dj.length <= 5
 * Ai, Bi, Cj, Dj consist of lower case English letters and digits.
 */
public class EvaluateDivision {

    private double queryResult = - 1.0;

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        double[] result = new double[queries.size()];
        Map<String, Set<EdgeValue>> graph = buildGraph(equations, values);

        for (int j = 0; j<queries.size(); j++){
            String numerator = queries.get(j).get(0);
            String deno = queries.get(j).get(1);
            if (graph.containsKey(numerator)){
                // visited.add(numerator);
                if(!numerator.equals(deno)){
                    Set<String> visited = new HashSet<>();
                    visited.add(numerator);
                    findValue(numerator, deno, 1.0, graph, visited);
                }else {
                    queryResult = 1; // no need to find
                }
            }
            result[j] = queryResult;
            queryResult = -1.0;
        }

        return result;
    }

    private void findValue(String node, String deno, double product, Map<String, Set<EdgeValue>> graph, Set<String> visited) {
        if (node.equals(deno)){
            //compare with queryResult, keep minimum one except -1.0 (no result)
            queryResult = product;
            return;
        }

        visited.add(node);

        for (EdgeValue child : graph.get(node)){
            if(visited.contains(child.toNode)){
                continue;
            }
            findValue(child.toNode, deno, product * child.value, graph, visited);
        }

    }

    private Map<String, Set<EdgeValue>> buildGraph(List<List<String>> equations, double[] values) {
        Map<String, Set<EdgeValue>> graph = new HashMap<>();

        for (int i=0; i<equations.size(); i++){
            List<String> nodePair = equations.get(i);
            if(!graph.containsKey(nodePair.get(0))) graph.put(nodePair.get(0), new HashSet<>());
            if(!graph.containsKey(nodePair.get(1))) graph.put(nodePair.get(1), new HashSet<>());

            //a => b
            //b => a
            graph.get(nodePair.get(0)).add(new EdgeValue(nodePair.get(1), values[i]));
            graph.get(nodePair.get(1)).add(new EdgeValue(nodePair.get(0), 1 / values[i]));
        }

        return graph;
    }

    static class EdgeValue{
        String toNode;
        double value;
        public EdgeValue(String toNode, double value){
            this.toNode = toNode;
            this.value = value;
        }

        @Override
        public String toString() {
            return "EdgeValue{" +
                    "toNode='" + toNode + '\'' +
                    ", value=" + value +
                    '}';
        }
    }

}
