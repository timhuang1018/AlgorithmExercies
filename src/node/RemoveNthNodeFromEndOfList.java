package node;

import helper.LinkedListGenerator;
import helper.ListNode;

public class RemoveNthNodeFromEndOfList {


    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;

        for (int i =0; i< n; i++){
            fast = fast.next;
        }

        ListNode slow = head;

        while (fast!=null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow.next;
    }


        //original
    public ListNode removeNthFromEnd2(ListNode head, int n) {
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

    public static void main(String[] args) {
        ListNode nodes = LinkedListGenerator.fromArray(new int[]{1,2,3,4,5});
        ListNode node = removeNthFromEnd(nodes, 2);
        System.out.println(node.val);
    }
}
