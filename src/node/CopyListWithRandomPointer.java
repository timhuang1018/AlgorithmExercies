package node;

import java.util.HashMap;

/**
 * A linked list of length n is given such that each node contains an additional random pointer,
 * which could point to any node in the list, or null.
 *
 * Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes,
 * where each new node has its value set to the value of its corresponding original node.
 * Both the next and random pointer of the new nodes should point to new nodes in the copied list
 * such that the pointers in the original list and copied list represent the same list state.
 * None of the pointers in the new list should point to nodes in the original list.
 *
 * For example, if there are two nodes X and Y in the original list, where X.random --> Y,
 * then for the corresponding two nodes x and y in the copied list, x.random --> y.
 *
 * Return the head of the copied linked list.
 *
 * The linked list is represented in the input/output as a list of n nodes.
 * Each node is represented as a pair of [val, random_index] where:
 *
 * val: an integer representing Node.val
 * random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
 * Your code will only be given the head of the original linked list.
 *
 * Example 1:
 * Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
 */
public class CopyListWithRandomPointer {

    //TODO: could create a new list linking origin and its copy as next
    //this result in random could reference to random.next (constant to find)

    //hash map to store mapping from origin to copy
    //walk through origin list and use ref to make copy have relative next and random
    //constant to find random result in O(n) time complexity
    public Node copyRandomList(Node head) {

        HashMap<Node, Node> map = new HashMap<>();

        Node visitor = head;
        while(visitor != null){
            map.put(visitor, new Node(visitor.val));
            visitor = visitor.next;
        }

        visitor = head;

        while(visitor != null){
            map.get(visitor).next = map.get(visitor.next);
            map.get(visitor).random = map.get(visitor.random);
            visitor = visitor.next;
        }

        return map.get(head);
    }


    //original
    //brute force
    //first round deep copy for val and next;
    //second round loop through origin and cop list together
    //if origin random is not null, create inner loop to start over and find random
    //this result in O(n*n) time complexity in worst case
    public Node copyRandomLis2(Node head) {
        if(head == null) return null;

        Node newList = new Node(head.val), visitor = head.next;
        Node dummy = new Node(-1);
        dummy.next = newList;

        while(visitor != null){
            newList.next = new Node(visitor.val);
            newList = newList.next;
            visitor = visitor.next;
        }

        Node newVisitor = dummy.next;
        visitor = head;

        while(visitor != null){
            Node pointTo = visitor.random;

            if(pointTo != null){
                Node inner = head;
                Node innerCopy = dummy.next;
                while(inner!=null){
                    if(inner == pointTo){
                        newVisitor.random = innerCopy;
                    }
                    inner = inner.next;
                    innerCopy = innerCopy.next;
                }
            }

            visitor = visitor.next;
            newVisitor = newVisitor.next;
        }

        return dummy.next;
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
