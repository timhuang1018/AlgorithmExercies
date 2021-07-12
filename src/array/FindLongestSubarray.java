package array;


public class FindLongestSubarray {

    /**
     * From an array of positive integers,
     * find the length of the longest subarray summing to target value
     */
    public static int findLongestSubarray(int[] array, int target){
        int maxLength = 0, left = 0, right = 0, sub = 0;
        while (right < array.length){
            if (sub < target){
                sub += array[right];
                right++;
            }else{
                sub -= array[left];
                left++;
            }
            if (sub==target){
                maxLength = Math.max(maxLength, right-left);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int t1 = findLongestSubarray(new int[]{7, 3, 2, 6, 4, 5, 5, 8, 1, 10, 9, 6},20);
        assert t1 == 5;
        int t2 = findLongestSubarray(new int[]{7, 3, 2, 2, 6, 4, 5, 5, 8, 1, 7, 10, 9, 6},19);
        assert t2 == 5;
    }

}
