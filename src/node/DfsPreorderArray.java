package node;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Given an ArrayList of Nodes, with each Node having an ID and a parent ID,
 * determine whether the List is given in preorder.
 *
 * ex.
 * (id, parentId), Given [(4, None), (2,4), (1, 2), (3, 2), (8, 4),
 * (6, 8), (5, 6), (7, 6), (9, 8)] Return True
 */
public class DfsPreorderArray {

    //preorder is in self - left - right order,if re
    public boolean inPreorder(List<Node> list){
        if (list == null || list.size() == 0){
            return false;
        }

        Stack<Integer> stack = new Stack<>();
        Node root = list.get(0);
        stack.push(root.id);
        int i = 1;

        while (i < list.size() && !stack.isEmpty()){
            Node current = list.get(i);
            if (stack.peek() == current.parentId){
                stack.push(current.id);
                i++;
            }else {
                stack.pop();
            }
        }
        return i == list.size();
    }


    public static void main(String[] args) {
        DfsPreorderArray solution = new DfsPreorderArray();
        List<Node> t1 = Arrays.asList(
                new Node(4, null),new Node(2,4),
                new Node(1, 2), new Node(3, 2),
                new Node(8, 4), new Node(6, 8),
                new Node(5, 6), new Node(7, 6),
                new Node(9, 8));
        System.out.println(solution.inPreorder(t1));;
    }

    static class Node{
        int id;
        int parentId;

        public Node(int id, Integer parentId){
            this.id = id;
            if (parentId != null){
                this.parentId = parentId;
            }
        }
    }
}
