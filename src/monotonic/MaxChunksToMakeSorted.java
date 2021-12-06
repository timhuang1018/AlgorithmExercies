package monotonic;

import java.util.Stack;

public class MaxChunksToMakeSorted {

    //back from end of array, compare each value with temp minimum at the time
    //if is smaller means we can get it split(chunked)
    //because we know after split , array could be sorted
    //if is bigger means could not be chunked
    //and also need to check previous chunked

    //time O(n)
    //space O(n)
    public int maxChunksToSorted(int[] arr) {
        int chunks = 1, tempMin = arr[arr.length-1];
        Stack<Integer> stack = new Stack<>();

        for(int i= arr.length - 2; i>=0; i--){
            if(arr[i] < tempMin){
                stack.push(tempMin);
                tempMin = arr[i];
                chunks++;
            }else{
                while(!stack.isEmpty() && arr[i] > stack.peek()){
                    stack.pop();
                    chunks--;
                }
            }
        }

        return chunks;
    }
}
