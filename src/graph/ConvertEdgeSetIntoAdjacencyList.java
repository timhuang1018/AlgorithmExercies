package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertEdgeSetIntoAdjacencyList {

    public Map<Character, List<Character>> edgeSetToAdjacencyList(char[] vertices, char[][] edges){
        Map<Character, List<Character>> map = new HashMap<>();

        for (char c : vertices){
            map.put(c, new ArrayList<>());
        }

        for(char[] edge : edges){
            map.get(edge[0]).add(edge[1]);
        }
        return map;
    }

    public static void main(String[] args) {
        ConvertEdgeSetIntoAdjacencyList solution = new ConvertEdgeSetIntoAdjacencyList();
        System.out.println(
                solution.edgeSetToAdjacencyList(
                        new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'},
                        new char[][]{
                                new char[]{'A', 'E'},
                                new char[]{'B', 'C'},
                                new char[]{'E', 'B'},
                                new char[]{'D', 'D'},
                                new char[]{'D', 'A'},
                                new char[]{'E', 'G'},
                                new char[]{'F', 'E'},
                                new char[]{'G', 'D'}
                        }
                )
        );

    }
}
