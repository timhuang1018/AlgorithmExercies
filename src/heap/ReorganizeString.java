package heap;

import java.util.PriorityQueue;

public class ReorganizeString {
    //one pass to find each char count
    //start using first and second to realign string
    //if we can use up all char from map -> return output
    //if can't satisfy -> empty string
    public static String reorganizeString(String s) {
        if(s.length() == 1) return s;
        int[] charCounts = new int[26];

        for(char c : s.toCharArray()){
            charCounts[c - 'a']++;
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>((p1, p2)-> p2[1] - p1[1]);

        for(int i=0; i<charCounts.length; i++){
            if(charCounts[i]>0){
                heap.add(new int[]{i, charCounts[i]});
            }
        }

        StringBuilder result = new StringBuilder();
        while(heap.size()>=2){
            int[] first = heap.poll();
            int[] second = heap.poll();

            result.append((char)(first[0] + 'a'));
            result.append((char)(second[0] + 'a'));
            second[1]--;
            first[1]--;

            if(first[1]>0){
                heap.add(first);
            }
            if(second[1]>0){
                heap.add(second);
            }
        }

        if(heap.size()==1){
            int[] last = heap.poll();
            if(last[1]>1){
                return "";
            }
            result.append((char)(last[0] + 'a'));
        }


        return result.toString();
    }

    public static void main(String[] args) {
        //expected "abacbc"
        System.out.println(reorganizeString("aabbcc"));
    }
}
