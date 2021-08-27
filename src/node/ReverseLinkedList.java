package node;

import helper.ListNode;

public class ReverseLinkedList {

    public static ListNode reverseList(ListNode head) {
        //A->B
        //keep next ref, A->null, B->A , move head
        ListNode newHead = null;
        while (head!=null){
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        return newHead;
    }
}
