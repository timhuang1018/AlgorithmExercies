package tree;

import helper.DataLogger;
import helper.ListNode;
import helper.TreeNode;
import helper.TreeNodeGenerator;


/**
 * Convert a binary tree to doubly linked list in the in-order sequence.
 * Return the head of the doubly linked list.
 * Could you solve it in-place without making new Nodes?
 */
public class BinaryTreeToDLL {


    //use in-order order dfs to satisfy the order of requirement
    //and link from the end node
    public ListNode toDoublyNode(TreeNode root){
        if (root == null){
            return null;
        }
        ListNode left = toDoublyNode(root.left);
        ListNode node = new ListNode(root.val);
        ListNode right = toDoublyNode(root.right);

        if (left != null){
            ListNode visitor = left;
            while (visitor.next!=null){
                visitor = visitor.next;
            }
            visitor.next = node;
        }

        if (right!=null){
            node.next = right;
        }

        return left == null ? node : left;
    }

    public static void main(String[] args) {
        BinaryTreeToDLL solution = new BinaryTreeToDLL();
        TreeNode t1 = TreeNodeGenerator.fromIntegerArray(new Integer[]{1,2,3,4,5,6,7,null,null,null,null,8,9});

        //expected 4,2,5,1,8,6,9,3,7
        DataLogger.printLinkedList(solution.toDoublyNode(t1));
    }
}
