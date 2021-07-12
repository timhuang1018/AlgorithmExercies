package array;

public class MergeSortedArray {

    public static int[] mergeSortedArray(int[] first, int[] second, int target){
        int[] mergeArray = new int[first.length+second.length];
        int i = 0, j = 0, k = 0;
        while ( i<first.length || j <second.length){
            if ( i<first.length && first[i] < second[j]){
                mergeArray[k++] = first[i];
                i++;
            }else {
                mergeArray[k++] = second[j];
                j++;
            }
        }
        return mergeArray;
    }
}
