package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {

    public Node cloneGraph(Node node) {
        Map<Node, Node> map = new HashMap<>();
        return dfs(node, map);
    }

    private Node dfs(Node node, Map<Node, Node> map){
        if(node == null) return null;

        if(map.containsKey(node)){
            return map.get(node);
        }

        Node clone = new Node(node.val);
        map.put(node, clone);

        for(Node child : node.neighbors){
            clone.neighbors.add(dfs(child, map));
        }

        return clone;
    }


    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
