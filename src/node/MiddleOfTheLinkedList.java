package node;

import helper.ListNode;

/**
 * Given the head of a singly linked list, return the middle node of the linked list.
 *
 * If there are two middle nodes, return the second middle node.
 */
public class MiddleOfTheLinkedList {

    //use two pointer(fast, slow)
    //this let even number list return second middle node
    //but if need to take the first middle node ,  make A.slow = head.next B.add dummy node C. check fast.next.next in loop condition
    public ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
