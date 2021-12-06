package array;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveAllAdjacentDuplicatesStringII {

    public static String removeDuplicates(String text, int k) {
        Deque<int[]> deque = new ArrayDeque<>();
        int start = 0;

        while(start < text.length()){
            char c = text.charAt(start);
            if (!deque.isEmpty() && deque.peekLast()[0] == c){
                int[] temp = deque.removeLast();
                if(++temp[1] < k){
                    deque.addLast(temp);
                }
            }else{
                deque.addLast(new int[]{c,1});
            }
            start++;
        }

        StringBuilder result = new StringBuilder();
        while (!deque.isEmpty()){
            char c = (char)(deque.peekFirst()[0]);
            int amount = deque.peekFirst()[1];
            while (amount>0){
                result.append(c);
                amount--;
            }
            deque.removeFirst();
        }
        return result.toString();
    }

    //Time Limit Exceeded
    public static String removeDuplicates2(String text, int k) {
        int start =0;
        String result = text;

        outerloop:
        while(start < result.length()-1){
            char c = result.charAt(start);
            int end = start+1;
            while(end < result.length() && c == result.charAt(end)){
                if(end - start + 1 == k){
                    result = result.substring(0,start) + result.substring(end+1);
                    start = 0;
                    continue outerloop;
                }
                end++;
            }
            start++;
        }
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        //expected "aa"
        System.out.println(removeDuplicates("deeedbbcccbdaa",3));;

        //expected "ps"
        System.out.println(removeDuplicates("pbbcggttciiippooaais",2));
    }
}
