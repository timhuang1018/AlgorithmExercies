package node;

import helper.DataLogger;
import helper.LinkedListGenerator;
import helper.ListNode;

import java.util.LinkedList;

public class OddEvenLinkedList {

    public static ListNode oddEvenList(ListNode head) {
        if (head==null || head.next==null || head.next.next==null) return head;
        ListNode odd = head, even = head.next,evenHead = head.next;
        while (even!=null && even.next!=null){
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;

        return head;
    }

    public static void main(String[] args) {
        ListNode t1 = oddEvenList(LinkedListGenerator.fromArray(new int[]{1,2,3,4,5}));
        new LinkedList<Integer>().remove();
        DataLogger.printLinkedList(t1);

        ListNode t2 = oddEvenList(LinkedListGenerator.fromArray(new int[]{2,1,3,5,6,4,7}));
        //expected Output: [2,3,6,7,1,5,4]
        DataLogger.printLinkedList(t2);
    }
}
