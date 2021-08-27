package node;

/**
 * Given the head of a singly linked list, return true if it is a palindrome.
 *
 * Input: head = [1,2,2,1]
 * Output: true
 */

import helper.ListNode;

public class PalindromeLinkedList {
    //two pointers, fast and slow traverse linkedlist, slow should at half when fast reach last node
    //another two pointer start from start and end, one go forward, one go backward
    // and compare these two along
    public boolean isPalindrome(ListNode head) {
        if (head==null) return false;
        ListNode dummy = new ListNode(-1,head),slow = dummy,fast = dummy;

        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        slow = reverseList(slow);

        while (slow!=null && head!=null){
            if (slow.val!=head.val) return false;
            slow = slow.next;
            head = head.next;
        }

        return true;
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
}
