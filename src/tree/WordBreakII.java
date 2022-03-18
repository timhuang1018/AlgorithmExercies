//package tree;
//
//import java.util.*;
//
//public class WordBreakII {
//
//    int end = 0;
//
//
//    public List<String> wordBreak(String s, List<String> wordDict) {
//
//        this.end = s.length();
//
//        List<String> result = new ArrayList<>();
//        Set<Integer> visited = new HashSet<>();
//        Queue<Integer> queue = new LinkedList<>();
//        Map<Integer, Set<String>> graph = new HashMap<>();
//        queue.add(0);
//        //build graph by bfs, any length of matching word is the edge, traverse to every node and edge
//        while(!queue.isEmpty()){
//
//            int start = queue.poll();
//            if(start == s.length()){
//                continue; //ignore leave node
//            }
//
//            graph.put(start, new HashSet<>());
//            visited.add(start);
//
//            for(String word : wordDict){
//                if(s.indexOf(word, start) == start){
//                    int newStart = start + word.length();
//
//                    if(newStart < s.length()) {
//                        graph.get(start).add(word);
//                    }
//                    if(visited.contains(newStart)){
//                        continue;
//                    }
//                    queue.offer(newStart);
//                }
//            }
//        }
//
//        dfs(0, graph, result, new StringBuilder());
//
//        System.out.println(result.size());
//        return result;
//    }
//
//    private void dfs(int node, Map<Integer, Set<String>> graph, List<String> result, StringBuilder path){
//
//        if(node == end){
//            result.add(path.toString().trim()); //ignore the last white space
//            return;
//        }
//
//        for(String childString : graph.get(node)){
//            path.append(childString);
//            path.append(' ');
//            dfs(node + childString.length(), graph, result, path);
//            path.delete(node, node + childString.length()+1); //include white space
//        }
//    }
//
//    public static void main(String[] args) {
//        WordBreakII solution = new WordBreakII();
//        System.out.println(solution.wordBreak("aaaaaaa", Arrays.asList("aaaa","aa","a")));
//
//        System.out.println(
//                new String[]{"a a a a a a a","aa a a a a a","a aa a a a a","a a aa a a a","aa aa a a a","aaaa a a a","a a a aa a a","aa a aa a a","a aa aa a a","a aaaa a a","a a a a aa a","aa a a aa a","a aa a aa a","a a aa aa a","aa aa aa a","aaaa aa a","a a aaaa a","aa aaaa a","a a a a a aa","aa a a a aa","a aa a a aa","a a aa a aa","aa aa a aa","aaaa a aa","a a a aa aa","aa a aa aa","a aa aa aa","a aaaa aa","a a a aaaa","aa a aaaa","a aa aaaa"}.length
//        );
//    }
//}
