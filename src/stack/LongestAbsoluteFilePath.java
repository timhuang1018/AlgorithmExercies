package stack;

import java.util.Stack;

public class LongestAbsoluteFilePath {

    public int lengthLongestPath(String input) {
        int maxLen = 0;
        //need to keep total length up until each level
        Stack<Integer> stack = new Stack<>();
        String[] array = input.split("\n");
        stack.push(0);

        for (String line : array){
            //no layer (root) would be 0
            int levelNow = line.lastIndexOf("\t") + 1;
            //plus one for dummy level
            while (levelNow + 1 < stack.size()){
                stack.pop();
            }

            int lenNow = line.length() - (levelNow==0? 0 : levelNow - 1) + stack.peek();

            if (line.contains(".")){
                maxLen = Math.max(maxLen, lenNow);
            }

            stack.push(lenNow);

            //pop same level
            //count max length when line has file
            //push deeper level
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String s = "\t\t\t23";
        System.out.println(s.length() - s.lastIndexOf("\t"));
    }
}
