package node;

import helper.LinkedListGenerator;
import helper.ListNode;

/**
 * Given the head of a sorted linked list,
 * delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * Return the linked list sorted as well.
 *
 * The number of nodes in the list is in the range [0, 300].
 * -100 <= Node.val <= 100
 * The list is guaranteed to be sorted in ascending order.
 */
public class RemoveDuplicatesfromSortedListII {

    public static ListNode deleteDuplicates(ListNode head) {
        if (head==null) return null;
        //201 is range of node.val
        int [] valCount = new int[201];
        ListNode visitor = head, dummy= new ListNode(Integer.MIN_VALUE,head), keepHead = dummy;

        while (visitor!=null){
            //node.val may be -100
            valCount[visitor.val+100]++;
            visitor = visitor.next;
        }

        while (dummy.next!=null){
            if (valCount[dummy.next.val+100]>1){
                dummy.next = dummy.next.next;
            }else {
                dummy = dummy.next;
            }
        }

        return keepHead.next;
    }

    public static void main(String[] args) {
        deleteDuplicates(LinkedListGenerator.fromArray(new int[]{-1,0,0,0,0,3,3}));
    }

}
