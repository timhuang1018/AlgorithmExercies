package tree;

import java.util.HashMap;
import java.util.Map;

public class LowestCommonAncestorOfBinaryTreeIII {

    public Node lowestCommonAncestor(Node p, Node q) {
        Map<Integer, Node> map = new HashMap<>();
        while(p!=null){
            map.put(p.val, p);
            p = p.parent;
        }

        while(!map.containsKey(q.val)){
            q = q.parent;
        }

        return q;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }
}
