package tree;

import helper.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateSubtrees {


    //visit all node in pre-order dfs
    //serialize node.val into a string to be a unique key for comparing duplicate
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {

        List<TreeNode> result = new ArrayList<TreeNode>();
        Map<String, Integer> map = new HashMap<>();
        dfs(root, map, result);
        return result;
    }

    private String dfs(TreeNode node, Map<String, Integer> map, List<TreeNode> result){
        if(node == null){
            return "";
        }
        String key =  "(" + dfs(node.left, map, result) +  node.val + dfs(node.right, map, result) + ")" ;

        if(map.getOrDefault(key, 0) == 1){
            result.add(node);
        }
        map.put(key, map.getOrDefault(key, 0) + 1);
        return key;
    }
}
