package array;

import java.util.*;

public class FindKClosestElements {

    //search and compare x in array to get closest index
    //use two pointer to and compare each two number which is more qualified
    //determined by smaller absolute distance and if equeal , a < b
    //find by loop until k integers are found
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        if (arr.length == k){
            for (int number: arr){
                result.add(number);
            }
            return result;
        }
        int left = 0, right = arr.length -1, closestIndex = -1;

        while(left <= right){
            int mid = left + (right - left)/2;
            if(arr[mid] >= x){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        //two pointers for go backward and forward
        int bwp = left, fwp = left + 1;
        System.out.println("left:"+left);
        Queue<Integer> heap = new PriorityQueue<>((p1, p2)-> p1 - p2);
        while(heap.size() < k){
            int bwNumber = (bwp >= 0 && bwp < arr.length) ? arr[bwp] : Integer.MIN_VALUE;
            int fwNumber = fwp < arr.length ? arr[fwp] : Integer.MIN_VALUE;
            System.out.println("b:"+bwNumber+",f:"+fwNumber);
            int candidate = 0;
            if(Math.abs(bwNumber - x) < Math.abs(fwNumber - x) ||
                    (Math.abs(bwNumber - x) == Math.abs(fwNumber - x) && bwNumber < fwNumber)){
                candidate = bwNumber;
                bwp--;
            }else{
                candidate = fwNumber;
                fwp++;
            }
            //the first insert number will be at last
            heap.offer(candidate);
        }
        while (!heap.isEmpty()){
            result.add(heap.poll());
        }

        return result;
    }

    public static void main(String[] args) {
//        //expected [1,2,3,4]
//        System.out.println(findClosestElements(new int[]{1,2,3,4,5},4 ,3));
//        //expected [1,2,3,4]
//        System.out.println(findClosestElements(new int[]{1,2,3,4,5},4 ,-1));
        //expected [1]
        System.out.println(findClosestElements(new int[]{1, 2},1 ,1));

    }
}
