package node;

import java.util.Stack;

public class FlattenMultilevelDoublyLinkedList {

    //if a node have next , put it's next into stack
    //check if node have child, set next to its child, and child to null
    //if no child , set next which is pop from stack
    public Node flatten(Node head) {
        Node visitor = head;
        Stack<Node> stack = new Stack<>();

        while(visitor!=null){

            if(visitor.next!=null){
                stack.push(visitor.next);
            }
            if(visitor.child != null){
                Node next = visitor.child;
                visitor.child = null;
                visitor.next = next;
                visitor.next.prev = visitor;

            }else if(!stack.isEmpty()){
                visitor.next = stack.pop();
                visitor.next.prev = visitor;

            }

            visitor = visitor.next;
        }

        return head;
    }


    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }
}
