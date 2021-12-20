package trie;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class DiameterOfN_AryTree {

    //find out diameter must have find out the depth of each children
    //keep the best diameter (might happen at some nodes have two deepest child depth)
    //original thought use heap to sort out child's height descending
    //actually just keep two variable max1,max2 are enough
    public int diameter(Node root) {
        int[] find = dfs(root);

        return find[1];
    }

    private int[] dfs(Node node){
        // PriorityQueue<Integer> pq = new PriorityQueue<>((p1,p2)-> p2 - p1);
        int max1 = 0;
        int max2 = 0;
        int best = 0;

        for(Node child : node.children){
            int[] find = dfs(child);
            best = Math.max(best, find[1]);

            int height = find[0];

            if(height > max1){
                max2 = max1;
                max1 = height;
            }else if(height > max2){
                max2 = height;
            }
            // pq.offer(find[0]);
        }

        // if(pq.size()>=2){
        //     height = pq.poll();
        //     best = Math.max(best, pq.poll() + height);
        // }else if(pq.size() == 1){
        //     height = pq.poll();
        //     best = Math.max(best,  height);
        // }
        best = Math.max(best, max1+max2);

        return new int[]{max1+1, best};
    }


    public int diameter2(Node root) {
        int[] find = dfs2(root);

        return find[1];
    }

    private int[] dfs2(Node node){
        PriorityQueue<Integer> pq = new PriorityQueue<>((p1, p2)-> p2 - p1);
        int best = 0;
        for(Node child : node.children){
            int[] find = dfs2(child);
            best = Math.max(best, find[1]);
            pq.offer(find[0]);
        }
        int height = 0;
        if(pq.size()>=2){
            height = pq.poll();
            best = Math.max(best, pq.poll() + height);
        }else if(pq.size() == 1){
            height = pq.poll();
            best = Math.max(best,  height);
        }

        return new int[]{height+1, best};
    }

    public static void main(String[] args) {
        DiameterOfN_AryTree solution = new DiameterOfN_AryTree();
        ArrayList<Node> list = new ArrayList<>();
        ArrayList<Node> innerList = new ArrayList<>();
        innerList.add(new Node(5));
        list.add(new Node(1, innerList));
        Node root = new Node(3,list );
        System.out.println(solution.diameter(root));
    }


    static class Node {
        public int val;
        public List<Node> children;


        public Node() {
            children = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            children = new ArrayList<Node>();
        }

        public Node(int _val,ArrayList<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
