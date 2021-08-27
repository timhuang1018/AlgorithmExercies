package heap;

import java.util.PriorityQueue;

/**
 * Given an array of n elements, where each element is at most k away from its target position,
 * devise an algorithm that sorts in O(n log k) time. For example,
 * let us consider k is 2, an element at index 7 in the sorted array,
 * can be at indexes 5, 6, 7, 8, 9 in the given array.
 *
 * Input : arr[] = {6, 5, 3, 2, 8, 10, 9}, k = 3
 * Output : arr[] = {2, 3, 5, 6, 8, 9, 10}
 *
 * Input : arr[] = {10, 9, 8, 7, 4, 70, 60, 50}, k = 4
 * Output : arr[] = {4, 7, 8, 9, 10, 50, 60, 70}
 */
public class SortNearlySortedArray {

    //sliding window size k
    //nlogK
    public static void insertionSort(int A[], int size){
        PriorityQueue<Integer> heap = new PriorityQueue<>((p1,p2)-> p1-p2);
        int j=0;

        for (int i=0; i<A.length; i++){
            heap.offer(A[i]);

            if (heap.size() > size){
                A[j] = heap.poll();
                j++;
            }
        }

        while (!heap.isEmpty()){
            A[j++] = heap.poll();
        }

        printArray(A);
    }

    public static void printArray(int[] arr){
        for (int i=0; i<arr.length; i++){
            System.out.print(arr[i]+",");
        }
    }

    public static void main(String[] args) {
        insertionSort(new int[]{10, 9, 8, 7, 4, 70, 60, 50},4);
    }
}
