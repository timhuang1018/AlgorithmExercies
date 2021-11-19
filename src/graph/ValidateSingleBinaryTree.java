package graph;

import helper.TreeNode;

import java.util.*;

public class ValidateSingleBinaryTree {


    public boolean isBinaryTree(List<TreeNode> nodes){
        Set<TreeNode> roots = new HashSet<>(), seen = new HashSet<>();

        for (TreeNode node : nodes){
            if (seen.contains(node)) continue;
            Set<TreeNode> curSeen = new HashSet<>();
            if (hasCycle(node, roots, curSeen)){
                return false;
            }
            seen.addAll(curSeen);
            roots.add(node);
        }
        return roots.size() == 1 && seen.size() == nodes.size();
    }

    private boolean hasCycle(TreeNode node, Set<TreeNode> roots, Set<TreeNode> curSeen) {
        if (node == null) return false;
        if (curSeen.contains(node)) return true;

        curSeen.add(node);
        roots.remove(node);
        return hasCycle(node.left, roots, curSeen) || hasCycle(node.right, roots, curSeen);
    }

    //to be a valid binary tree
    //count number of in-edge while dfs all nodes in list,
    //check node in map after recursion
    //1.have multiple nodes with zero in-edge => invalid, only one root node
    //2.any node have more than one in-edge => invalid, means multiple nodes pointing same child
    public boolean isBinaryTree2(List<TreeNode> nodes) {
        if (nodes == null || nodes.size() == 0){
            return false;
        }
        //key are node
        //value are number of in-edge
        Map<TreeNode, Integer> map = getNodeInEdge(nodes);

        TreeNode root = null;
        for (TreeNode node : nodes){

            if (!map.containsKey(node)){
                if (root==null){
                    root = node;
                }else {
                    //multiple root
                    return false;
                }
            }else {
                // multiple parent point to same node
                if (map.get(node)>1){
                    return false;
                }
            }
        }
        return root != null ;
    }

    private Map<TreeNode, Integer> getNodeInEdge(List<TreeNode> nodes) {
        //value are number of in-edge
        Map<TreeNode, Integer> map = new HashMap<>();
        for (TreeNode node : nodes){
            if(node.left != null){
                map.put(node.left, map.getOrDefault(node.left,0) + 1);
            }
            if(node.right != null){
                map.put(node.right, map.getOrDefault(node.right,0) + 1);
            }
        }
        return map;
    }


    public static void main(String[] args) {
        ValidateSingleBinaryTree solution = new ValidateSingleBinaryTree();
//        TreeNode n1 = new TreeNode(1);
//        TreeNode n2 = new TreeNode(2);
//        TreeNode n3 = new TreeNode(3);
//        TreeNode n4 = new TreeNode(4);
//
//        n1.left = n2;
//        n1.right = n3;
//        n3.left = n4;
//        //expected true
//        System.out.println(solution.isBinaryTree(Arrays.asList(n4,n2,n3,n1)));

//        TreeNode n1 = new TreeNode(1);
//        TreeNode n2 = new TreeNode(2);
//        TreeNode n3 = new TreeNode(3);
//        TreeNode n4 = new TreeNode(4);
//
//        n1.left = n2;
//        n1.right = n3;
//        n2.right = n4;
//        n3.left = n4;
//        //expected false
//        System.out.println(solution.isBinaryTree(Arrays.asList(n4,n2,n3,n1)));


//        TreeNode n1 = new TreeNode(1);
//        TreeNode n2 = new TreeNode(2);
//
//        n1.left = n2;
//        n2.left = n1;
//        //expected false
//        System.out.println(solution.isBinaryTree(Arrays.asList(n2,n1)));

//        TreeNode n1 = new TreeNode(1);
//        TreeNode n2 = new TreeNode(2);
//        TreeNode n3 = new TreeNode(3);
//        TreeNode n4 = new TreeNode(4);
//        TreeNode n5 = new TreeNode(5);
//        TreeNode n6 = new TreeNode(6);
//
//        n1.left = n2;
//        n1.right = n3;
//
//        n4.left = n5;
//        n4.right = n6;
//        //expected false
//        System.out.println(solution.isBinaryTree(Arrays.asList(n2, n6, n4, n1, n3, n5)));


        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);

        n1.left = n2;
        n1.right = n3;
        n3.left = n4;

        //expected false
        System.out.println(solution.isBinaryTree(Arrays.asList(n2,n3,n1)));

    }
}
