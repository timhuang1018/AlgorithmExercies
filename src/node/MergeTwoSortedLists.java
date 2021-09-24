package node;

import helper.ListNode;

public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1,null), visitor = dummy;

        while(l1!=null && l2!=null){
            if(l1.val > l2.val){
                visitor.next = l2;
                l2 = l2.next;
                visitor = visitor.next;
            }else{
                visitor.next = l1;
                l1 = l1.next;
                visitor = visitor.next;
            }
        }

        if(l1!=null){
            visitor.next = l1;
        }else if(l2!=null){
            visitor.next = l2;
        }

        return dummy.next;
    }
}
