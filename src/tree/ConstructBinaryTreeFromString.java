package tree;

import helper.TreeNode;
import helper.TreeNodeGenerator;

/**
 * You need to construct a binary tree from a string consisting of parenthesis and integers.
 *
 * The whole input represents a binary tree. It contains an integer followed by zero, one or two pairs of parenthesis.
 * The integer represents the root's value and a pair of parenthesis contains a child binary tree with the same structure.
 *
 * You always start to construct the left child node of the parent first if it exists.
 *
 * There will only be '(', ')', '-' and '0' ~ '9' in the input string.
 * An empty tree is represented by "" instead of "()"
 *
 * Example:
 * Input: "-4(2(3)(1))(6(5))"
 * Output: {-4,2,6,3,1,5}
 *
 * Input: "1(-1)"
 * Output: {1,-1}
 */
public class ConstructBinaryTreeFromString {


    //recursion
    //first collect all char before '(', include '-' in loop
    //then another loop to split left and right child using substring
    //return node
    public TreeNode str2tree(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }

        return recurHelper(s);
    }

    private TreeNode recurHelper(String leftString) {
        int index = 0;
        if (index >= leftString.length()){
            return null;
        }
        StringBuilder numberString = new StringBuilder();

        try {
            while (index < leftString.length()){
                char c = leftString.charAt(index);
                if (c == '('){
                    break;
                }
                numberString.append(c);
                index++;
            }
            TreeNode root = new TreeNode(Integer.parseInt(numberString.toString()));

            int start = index;
            //record parenthesis count to find correct closing parenthesis
            int balance = 0;
            while (index < leftString.length()){
                char c = leftString.charAt(index);
                if (c == '('){
                    balance++;
                    if (balance == 1){
                        start = index + 1;
                    }
                }else if (c == ')'){
                    balance--;
                    if (balance == 0){
                        if (root.left != null){
                            root.right = recurHelper(leftString.substring(start,index));
                        }else {
                            root.left = recurHelper(leftString.substring(start,index));
                        }
                    }
                }
                index++;
            }
            return root;
        }catch (NumberFormatException e){
            return null;
        }
    }

    public static void main(String[] args) {
        ConstructBinaryTreeFromString solution = new ConstructBinaryTreeFromString();
        String s1 = "-4(2(3)(1))(6(5))";
        TreeNode n1 =  solution.str2tree(s1);
        System.out.println("answer:");
        //expected -4,2,6,3,1,5
        TreeNodeGenerator.printLevelOrder(n1);

        String s2 = "1(-1)";
        TreeNode n2 = solution.str2tree(s2);
        System.out.println("answer:");
        //expected 1, -1
        TreeNodeGenerator.printLevelOrder(n2);

    }
}
