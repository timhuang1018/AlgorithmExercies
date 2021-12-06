package array;

import java.util.*;

public class FindKClosestElements {


    //search and compare x in array to get best start index
    //best start index is considering value which
    //determined by smaller absolute distance and if  a diff <= b diff
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();

        //right bound should be all - k, the limit bound can be start
        int left = 0, right = arr.length - k ;

        while(left < right){
            int mid = left + (right - left)/2;
            // in terms of midpoint of the two values x > (A[mid + k] + A[mid])/2
            if(x - arr[mid] > arr[mid + k] -x){
                left = mid + 1;
            }else{
                right = mid;
            }
        }

        while (k>0){
            result.add(arr[left++]);
            k--;
        }
        return result;
    }

    public static void main(String[] args) {
        //expected [1,2,3,4]
        System.out.println(findClosestElements(new int[]{1,2,3,4,5},4 ,3));
        //expected [1,2,3,4]
        System.out.println(findClosestElements(new int[]{1,2,3,4,5},4 ,-1));
//        expected [1]
        System.out.println(findClosestElements(new int[]{1, 2},1 ,1));

//        expected [3,3,4]
        System.out.println(findClosestElements(new int[]{0,0,1,2,3,3,4,7,7,8},3 ,5));

        System.out.println(findClosestElements(new int[]{1,2,3,4,5},4 ,3));

//        expected [3,6,8,8,9]
        System.out.println(findClosestElements(new int[]{0,1,2,2,2,3,6,8,8,9},5 ,9));

        System.out.println(findClosestElements(new int[]{1,2,3,3,6,6,7,7,9,9},8 ,8));
    }
}
