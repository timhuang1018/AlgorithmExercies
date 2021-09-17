package node;

import helper.ListNode;

public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        //according to constraints, if only one node, this should be removed, and nothing left
        if(head.next==null) return null;

        int total = 0;
        ListNode visitor = head;

        while(visitor!=null){
            total++;
            visitor = visitor.next;
        }
        //start at position -1 bc a dummy node ahead
        int removeAt = total - n, start = -1;
        ListNode dummy = new ListNode(-1, head), keepHead = dummy;

        while(dummy!=null){
            start++;
            if(start == removeAt){
                dummy.next = dummy.next.next;
            }
            dummy = dummy.next;
        }

        return keepHead.next;
    }
}
