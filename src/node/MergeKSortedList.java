package node;

import helper.ListNode;
import java.util.PriorityQueue;

/**
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 *
 * Merge all the linked-lists into one sorted linked-list and return it.
 *
 * Example 1:
 *
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * merging them into one sorted list:
 * 1->1->2->3->4->4->5->6
 * Example 2:
 *
 * Input: lists = []
 * Output: []
 * Example 3:
 *
 * Input: lists = [[]]
 * Output: []
 */

public class MergeKSortedList {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1), visitor = dummy;
        PriorityQueue<ListNode> heap = new PriorityQueue<>((p1, p2)-> p1.val - p2.val);

        for(ListNode node : lists){
            if(node!=null){
                heap.offer(node);
            }
        }

        while(!heap.isEmpty()){
            ListNode node = heap.poll();
            visitor.next = node;
            visitor = visitor.next;
            if(node.next!=null){
                heap.offer(node.next);
            }
        }

        return dummy.next;
    }
}
