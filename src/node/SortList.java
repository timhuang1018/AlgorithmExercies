package node;

import helper.ListNode;

/**
 * Given the head of a linked list, return the list after sorting it in ascending order.
 *
 * Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?
 *
 * Example 1:
 *
 * Input: head = [4,2,1,3]
 * Output: [1,2,3,4]
 * Example 2:
 *
 * Input: head = [-1,5,3,4,0]
 * Output: [-1,0,3,4,5]
 * Example 3:
 *
 * Input: head = []
 * Output: []
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 5 * 104].
 * -105 <= Node.val <= 105
 */
public class SortList {

    //TODO solution for O(1) memory

    //time complexity O(nlogn)
    //space complexity O(logn)
    public ListNode sortList(ListNode head) {
        if(head == null || head.next==null) return head;

        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);
    }

    public ListNode getMid(ListNode head){
        if(head == null || head.next==null) return head;

        ListNode fast = head, preMid = new ListNode(-1,null);
        preMid.next = head;

        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            preMid = preMid.next;
        }
        ListNode realMid = preMid.next;
        //break the chain to separate into two linked list
        preMid.next = null;

        return realMid;
    }

    public ListNode merge(ListNode list1, ListNode list2){
        ListNode dummy = new ListNode(-1,null), visitor = dummy;

        while(list1!=null && list2!=null){
            if(list1.val > list2.val){
                visitor.next = list2;
                list2 = list2.next;
                visitor = visitor.next;
            }else{
                visitor.next = list1;
                list1 = list1.next;
                visitor = visitor.next;
            }
        }

        if(list1!=null){
            visitor.next = list1;
        }else if(list2!=null){
            visitor.next = list2;
        }

        return dummy.next;
    }

}
