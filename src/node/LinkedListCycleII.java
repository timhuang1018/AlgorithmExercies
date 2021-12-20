package node;

import helper.ListNode;

public class LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        boolean isCycle = false;
        //head might be null or only single node then won't enter loop
        while(fast!= null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
            //find cycle
            if(fast!=null && fast == slow) {
                isCycle = true;
                break;
            }
        }

        //there is no cycle
        if(!isCycle) return null;

        while(head!=null && head != slow){
            head = head.next;
            slow = slow.next;
        }

        return head;
    }
}
