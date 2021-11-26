package array;

import helper.DataLogger;

public class KthLargestInArray {

    public static int findKthLargest(int[] nums, int k) {
        int lo = 0, hi = nums.length-1;
        //kth largest is (all - k + 1)th smallest
        k = nums.length - k;
        while (lo<=hi){
            int pivotIndex = partition(nums,lo,hi);
            if (pivotIndex == k){
                return nums[pivotIndex];
            }else  if (pivotIndex < k){
                lo = pivotIndex + 1;
            }else {
                hi = pivotIndex - 1;
            }
        }
        return 0;
    }

    public static int partition(int arr[], int start, int end){
        int pivot = arr[end];
        int i = start;
        for (int j = start;j<end;j++){
            if (arr[j]<=pivot){
                swap(arr,i,j);
                i++;
            }
        }
        swap(arr,i,end);
        return i;
    }

    public static void swap(int arr[], int i, int j){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
        DataLogger.printIntArray(arr);
    }



    public static void main(String[] args) {
        int t1 = findKthLargest(new int[]{3,2,1,5,6,4},2);
        //expected 5
        System.out.println(t1);

        int t2 = findKthLargest(new int[]{99, 99}, 1);
        //expected 99
        System.out.println(t2);

        int t3 = findKthLargest(new int[]{-1, 2 ,0}, 1);
        //expected 2
        System.out.println(t3);
    }
}
