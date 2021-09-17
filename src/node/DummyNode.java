package node;

import helper.DataLogger;
import helper.LinkedListGenerator;
import helper.ListNode;

/**
 * Add 1 to an integer where each digit is carried by a node in the linked list.
 * Please do it in-place in O(n) time. Return the head node of the result
 */
public class DummyNode {

    public static ListNode increment(ListNode head){
        if (head==null) return new ListNode(1,null);

        ListNode dummy = new ListNode(0,head),visitor = dummy; // visitor responsible for traversing each node

        while (visitor!=null){
            if (visitor.val!=9){
                dummy = visitor;
            }
            visitor = visitor.next;
        }
        visitor = dummy;

        while (visitor!=null){
            if (visitor.val!=9){
                visitor.val++;
            }else {
                visitor.val = 0;
            }
            visitor = visitor.next;
        }
        //edge case 9->9->9, dummy never move
        return dummy.next==head ? dummy : head;
    }

    public static ListNode increment2(ListNode head){
        if (head==null) return new ListNode(1,null);
        //reverse list
        head = reverseList(head);

        //increment here
        head.val++;
        ListNode keepHead = head;
        int carry = 0;
        while (head!=null){
            int sub = head.val + carry;
            head.val = sub % 10;
            carry = sub / 10;

            //head will be at last node
            if (head.next!=null){
                head = head.next;
            }else {
                break;
            }
        }

        if (carry!=0){
            head.next = new ListNode(carry,null);
        }

        return reverseList(keepHead);
    }

    public static ListNode reverseList(ListNode head) {

        ListNode newHead = null;
        while (head!=null){
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        return newHead;
    }

    public static void main(String[] args) {
        //input 9
        //expected 1->0
        ListNode testcase1 = LinkedListGenerator.fromNodeString("9");
        DataLogger.printLinkedList(increment(testcase1));

        //input 2->9->3->9->8->9->9
        //expected 2->9->3->9->9->0->0
        ListNode testcase2 = LinkedListGenerator.fromNodeString("2->9->3->9->8->9->9");
        DataLogger.printLinkedList(increment(testcase2));

        //input 9->9->9
        //expected 1->0->0->0
        ListNode testcase3 = LinkedListGenerator.fromNodeString("9->9->9");
        DataLogger.printLinkedList(increment(testcase3));
    }
}
