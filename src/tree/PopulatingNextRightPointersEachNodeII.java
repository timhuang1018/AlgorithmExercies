package tree;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Populate each next pointer to point to its next right node.
 * If there is no next right node, the next pointer should be set to NULL.
 *
 * Initially, all next pointers are set to NULL.
 */
public class PopulatingNextRightPointersEachNodeII {

    //connect node with same level
    public Node connect(Node root) {
        if(root == null){
            return null;
        }
        Queue<Node> queue = new LinkedList();
        queue.offer(root);

        while(true){

            Queue<Node> tempQueue = new LinkedList();
            Node previous = null;
            while(!queue.isEmpty()){

                Node node = queue.poll();
                if(node.left != null){
                    tempQueue.offer(node.left);
                    if (previous != null){
                        previous.next = node.left;
                    }
                    previous = node.left;
                }
                if(node.right != null){
                    tempQueue.offer(node.right);

                    if (previous != null){
                        previous.next = node.right;
                    }
                    previous = node.right;
                }
            }

            if(tempQueue.isEmpty()){
                break;
            }else{
                while(!tempQueue.isEmpty()){
                    queue.offer(tempQueue.poll());
                }
            }
        }
        return root;
    }



    static class Node{
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
