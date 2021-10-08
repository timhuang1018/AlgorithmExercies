package tree;


import helper.TreeNode;
import helper.TreeNodeGenerator;

public class LongestUnivaluePath {

    public int longestUnivaluePath(TreeNode root) {
        return dfs(root).maxLen;
    }

    public NodeWrapper dfs(TreeNode node){
        if(node == null){
            return new NodeWrapper(Integer.MIN_VALUE);
        }

        NodeWrapper left = dfs(node.left);
        NodeWrapper right = dfs(node.right);

        NodeWrapper result = new NodeWrapper(node.val);

        //4 cases:  1.
        if(left.uniValue == result.uniValue && right.uniValue == result.uniValue){
            result.length = Math.max( left.length, right.length) + 1;
            result.maxLen = Math.max(left.length+right.length + 2, Math.max(left.maxLen, right.maxLen));
        }else if(left.uniValue == result.uniValue){
            result.length = left.length + 1;
            result.maxLen = Math.max(result.length, Math.max(left.maxLen, right.maxLen));
        }else if(right.uniValue == result.uniValue){
            result.length = right.length + 1;
            result.maxLen = Math.max(result.length, Math.max(left.maxLen, right.maxLen));
        }else {
            result.length = 0;
            result.maxLen = Math.max(result.length, Math.max(left.maxLen, right.maxLen));
        }

        System.out.println("left:"+left+",right:"+right+", nw:"+result);

        return result;
    }

    static class NodeWrapper{
        int length;
        int maxLen;
        int uniValue;
        public NodeWrapper(int uniValue){
            this.uniValue = uniValue;
        }

        @Override
        public String toString() {
            return "NodeWrapper{" +
                    "length=" + length +
                    ", maxLen=" + maxLen +
                    ", uniValue=" + uniValue +
                    '}';
        }
    }

    public static void main(String[] args) {
        LongestUnivaluePath solution = new LongestUnivaluePath();

        TreeNode t1 = TreeNodeGenerator.fromIntegerArray(new Integer[]{1,4,5,4,4,5});
//        expected 2
        System.out.println(solution.longestUnivaluePath(t1));

//        TreeNode t2 = TreeNodeGenerator.fromIntegerArray(new Integer[]{5,4,5,1,1,5});
//        //expected 2
//        System.out.println(solution.longestUnivaluePath(t2));
    }
}
