package node;

import helper.TreeNode;
import helper.TreeNodeGenerator;

import java.util.Stack;

public class ConvertBinarySearchTreeToSortedDoublyLinkedList {

    //do a in-order traversal
    //record the left(head) every time have a left child
    //record end if there is a right child

    public TreeNode treeToDoublyList(TreeNode root) {
        if(root == null) return null;

        TreeNode head = root, prev = null;
        while (head.left!=null){
            head = head.left;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()){

            while (cur !=null){
                stack.push(cur);
                cur = cur.left;
            }

            //cur is null then start from most left
            cur = stack.pop();
            if (prev!=null){
                prev.right = cur;
                cur.left = prev;
            }
            prev = cur;
            cur = cur.right;
        }

        if (prev!=null){
            prev.right = head;
        }

        return head;
    }


    public static void main(String[] args) {
        ConvertBinarySearchTreeToSortedDoublyLinkedList solution = new ConvertBinarySearchTreeToSortedDoublyLinkedList();
        solution.treeToDoublyList(TreeNodeGenerator.buildTree(new Integer[]{4,2,5,1,3}));
    }


}
