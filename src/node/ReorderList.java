package node;

import helper.DataLogger;
import helper.LinkedListGenerator;
import helper.ListNode;

public class ReorderList {

    //first get the middle point node
    //then reverse the next half of list
    //then start from head and end to combine and reorder
    public void reorderList(ListNode head) {
        ListNode slow = head, dummy = new ListNode(-1);
        dummy.next = head;
        //depend on the requirement to make fast at middle left or middle right
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode endHead = reverse(slow);
        slow.next = null; //break the chain into two list

        while(head!=null && endHead != null){
            ListNode temp = head.next;
            head.next = endHead; //start to merge so the reference need to change immediately after
            endHead = endHead.next; //change assign (important to put here)

            head.next.next = temp;
            head = head.next.next;
        }

        DataLogger.printLinkedList(dummy.next);
    }

    //start reverse at the next node, stop when found the given node
    private ListNode reverse(ListNode node){

        ListNode newHead = null, visitor = node.next;

        while(visitor != null){
            ListNode temp = visitor.next;
            visitor.next = newHead;
            newHead = visitor;
            visitor = temp;
        }

        return newHead;
    }

    public static void main(String[] args) {
        ReorderList solution = new ReorderList();
        //expected 1,5,2,4,3
        solution.reorderList(LinkedListGenerator.fromArray(new int[]{1,2,3,4,5}));

        //expected 1,4,2,3
        solution.reorderList(LinkedListGenerator.fromArray(new int[]{1,2,3,4}));
    }
}
