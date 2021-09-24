package node;

import helper.ListNode;

public class IntersectionOfTwoLinkedLists {


    //use two pointer and traverse each linked list at the same time
    //each pointer reach the end will start from another linked list to traverse again
    //which make two pointer walk same distance, then able to compare next node if is intersection
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pointer1 = headA, pointer2 = headB;

        while (true){
            if (pointer1==pointer2){
                return pointer1;
            }
            if(pointer1!=null){
                pointer1 = pointer1.next;
            }else {
                pointer1 = headB;
            }
            if(pointer2!=null){
                pointer2 = pointer2.next;
            }else{
                pointer2 = headA;
            }
        }
    }


        //walk through both linked list to get each total nodes
    //determine which is long , short
    //make long linked list shorter until both have same length
    //walk through both at same time to compare if their next node is the same one (intersection)
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if(headA==null || headB==null){
            return null;
        }

        int totalNodesA = 0, totalNodesB = 0;
        ListNode visitorA = headA, visitorB = headB;

        while(visitorA!=null){
            totalNodesA++;
            visitorA = visitorA.next;
        }
        while(visitorB!=null){
            totalNodesB++;
            visitorB = visitorB.next;
        }

        ListNode longHead = totalNodesA > totalNodesB ? headA : headB;
        ListNode shortHead = longHead == headA ? headB : headA;

        int longTotal = longHead == headA ? totalNodesA : totalNodesB;
        int shortTotal = longTotal == totalNodesA ? totalNodesB : totalNodesA;

        while(longTotal > shortTotal && longHead.next!=null){
            longHead = longHead.next;
            longTotal--;
        }

        while(longHead!=null && shortHead!=null){
            if(longHead==shortHead){
                return longHead;
            }
            longHead = longHead.next;
            shortHead = shortHead.next;
        }

        return null;
    }
}
