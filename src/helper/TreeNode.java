package helper;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public String printVal() {
        StringBuilder sb = new StringBuilder();
        sb.append("TNode{ ");
        sb.append(val);
        if (left!=null){
            sb.append( ", left=");
            sb.append(left.printVal());
        }
        if (right!=null){
            sb.append(", right=");
            sb.append(right.printVal());
        }
        sb.append(" }");
        return sb.toString();
    }

    public String printHashcode(){
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append(toString());
        if (left!=null){
            sb.append( ", left=");
            sb.append(left.printHashcode());
        }
        if (right!=null){
            sb.append(", right=");
            sb.append(right.printHashcode());
        }
        sb.append('}');
        return sb.toString();
    }
}
