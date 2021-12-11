package node;

import helper.ListNode;

public class ReverseNodesInKGroup {

    //use recurrsion to automatically keep the head of first segment
    //in a help function record the head then count nodes unitl k and put it into another recursion
    //if can't count k nodes, just return the head of the left
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode visitor = head,splitHead = head, newHead = null, tail = null;

        int times = k;
        while(visitor!=null){
            times--;
            if(times == 0){
                //break the chain , reverse the segment
                ListNode temp = visitor.next;
                visitor.next = null;
                visitor = temp;
                ListNode[] nodes = reverse(splitHead);

                //connect to newHead's tail, update splitHead, and tail
                splitHead = temp;
                if(newHead == null){
                    newHead = nodes[0];
                    tail = nodes[1];
                }else{
                    tail.next = nodes[0];
                    tail = nodes[1];
                }
                times = k;
            }else{
                visitor = visitor.next;
            }
        }
        if(times < k){
            if(tail == null){
                return head;
            }else{
                tail.next = splitHead;
            }
        }

        return newHead;
    }

    //return head and end node
    private ListNode[] reverse(ListNode node){
        ListNode newHead = node, visitor = node.next, last = node;
        node.next = null;

        while(visitor != null){
            ListNode temp = visitor.next;
            visitor.next = newHead;
            newHead = visitor;
            visitor = temp;
        }

        return new ListNode[]{newHead, last};
    }
}
