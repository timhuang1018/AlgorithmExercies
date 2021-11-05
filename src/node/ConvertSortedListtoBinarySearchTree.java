package node;

import helper.*;

/**
 * Given the head of a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in
 * which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Input: head = [-10,-3,0,5,9]
 * Output: [0,-3,9,-10,null,5]
 * Explanation: One possible answer is [0,-3,9,-10,null,5],
 * which represents the shown height balanced BST.
 */
public class ConvertSortedListtoBinarySearchTree {

    public TreeNode sortedListToBST(ListNode head) {
        //to make a balance BST, split the sort list at mid in recursion
        return splitList(head);
    }

    public TreeNode splitList(ListNode head){
        if(head == null){
            return null;
        }

        //use fast, slow to be at mid of the linkedlist
        //use breakNode to disconnect two linkedlists
        ListNode slow = head, fast = head, breakNode = head;
        while(fast != null && fast.next!=null){
            fast = fast.next.next;
            breakNode = slow;
            slow = slow.next;
        }
        breakNode.next = null;

        TreeNode current = new TreeNode(slow.val);

        if(slow == head){
            return current;
        }

        ListNode leftHead = head, rightHead = slow.next;
        current.left = splitList(leftHead);
        current.right = splitList(rightHead);

        return current;
    }


    public static void main(String[] args) {
        ConvertSortedListtoBinarySearchTree solution = new ConvertSortedListtoBinarySearchTree();
        TreeNode t1 = solution.sortedListToBST(LinkedListGenerator.fromArray(new int[]{-10,-3,0,5,9}));
        TreeNodeGenerator.printLevelOrder(t1);
    }
}
