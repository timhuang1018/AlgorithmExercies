package tree;

import helper.TreeNode;
import helper.TreeNodeGenerator;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        return preDfs(root, new ArrayList<>(), 0);
    }

    public List<Integer> preDfs(TreeNode node, List<Integer> list, int depth){
        if(node == null) return list;
        if (list.size() == depth){
            list.add(node.val);
        }
        preDfs(node.right, list, depth + 1);
        preDfs(node.left, list, depth + 1);

        return list;
    }

    public static void main(String[] args) {
        BinaryTreeRightSideView solution = new BinaryTreeRightSideView();
        //expected [1, 2]
        TreeNode root = TreeNodeGenerator.fromIntegerArray(new Integer[]{1,2});
        System.out.println(solution.rightSideView(root));;

        TreeNode root2 = TreeNodeGenerator.fromIntegerArray(new Integer[]{1,2,3,4});
        //expected [1, 3, 4]
        System.out.println(solution.rightSideView(root2));;
    }
}
