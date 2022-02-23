package node;

import helper.LinkedListGenerator;
import helper.ListNode;

public class MergeNodeBetweenZeroes {

    public static ListNode mergeNodes(ListNode head) {

        ListNode merge = head.next.next, prev = head.next;

        while(merge != null){
            if(merge.val == 0){
                prev.next = merge.next;
                prev = prev.next;
                merge = merge.next;
                if(merge == null) break;
            }else{
                prev.val += merge.val;
            }
            merge = merge.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode head = LinkedListGenerator.fromArray(new int[]{0,3,1,0,4,5,2,0});
        mergeNodes(head);
    }
}
