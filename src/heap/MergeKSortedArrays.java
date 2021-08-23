package heap;

import java.util.*;

/**
 * Merge all of the sorted arrays given into a sorted array.
 * input
 * List<List<Integer> arrays = [[2, 5, 5, 9, 10],
 * [3, 4, 6, 10, 19, 20, 25, 27], [7, 16],
 * [-2, 0, 2, 14, 33]]
 *
 * expected output
 * [-2, 0, 2, 2, 3, 4, 5, 5, 6, 7, 9, 10, 10, 14, 16, 19, 20, 25, 27, 33
 */
public class MergeKSortedArrays {

    public static List<Integer> mergeArrays(List<List<Integer>> arrays){
        //heap store int[] which contain
        // 1.outer index among arrays
        // 2.inner index among the array
        // 3. the value at inner index
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(p -> p[2]));

        for (int i=0; i<arrays.size(); i++){
            if (arrays.get(i).size()==0) continue;
            heap.add(new int[]{i,0,arrays.get(i).get(0)});
        }

        List<Integer> result = new ArrayList<>();
        while (!heap.isEmpty()){
            int[] pair = heap.poll();
            List<Integer> array = arrays.get(pair[0]);
            result.add(pair[2]);
            ++pair[1];
            if (pair[1]<array.size()){
                heap.add(new int[]{pair[0],pair[1],array.get(pair[1])});
            }
        }

        return result;
    }


    public static void main(String[] args) {
        List<List<Integer>> arrays = new ArrayList<>();
        List<Integer> arr1 = new ArrayList<>();
        arr1.add(2);
        arr1.add(5);
        arr1.add(5);
        arr1.add(9);
        arr1.add(10);
        arrays.add(arr1);
        List<Integer> arr2 = new ArrayList<>();
        arr2.add(3);
        arr2.add(4);
        arr2.add(6);
        arr2.add(10);
        arr2.add(19);
        arr2.add(20);
        arr2.add(25);
        arr2.add(27);
        arrays.add(arr2);
        List<Integer> arr3 = new ArrayList<>();
        arr3.add(7);
        arr3.add(16);
        arrays.add(arr3);
        List<Integer> arr4 = new ArrayList<>();
        arr4.add(-2);
        arr4.add(0);
        arr4.add(2);
        arr4.add(14);
        arr4.add(33);
        arrays.add(arr4);
        //-2, 0, 2, 2, 3, 4, 5, 5, 6, 7, 9, 10, 10, 14, 16, 19, 20, 25, 27, 33
        System.out.println(mergeArrays(arrays));
    }
}
