package array;

import java.util.HashMap;

/**
 * Given two sorted arrays A and B, and a target number.
 * Find a pair of elements that A[i] - B[k] == target.
 * Return null if the pair doesn't exist.
 *
 * Input
 * Alice = [2, 5, 7, 8, 14]
 * Bob =   [1, 6, 10, 15]
 * target = 2
 * Expected output
 * [8, 6]
 * Input
 * Alice = [2, 5, 7, 8, 14] Bob = [1, 6, 10, 15] target = -10
 * Expected output
 * [5, 15]
 */
public class FindPairInTwoArray {

    public static void main(String[] args) {
        int[] Alice = new int[]{2, 5, 7, 8, 14};
        int[] Bob =   new int[]{1, 6, 10, 15};
        //expected 8,6
        int[] result = findPairInInTwoArray(Alice,Bob, 2);
        System.out.println( result.length!=0 ? (String.valueOf(result[0])+" and "+String.valueOf(result[1])):null);


        int[] A = new int[]{2, 5, 7, 8, 14};
        int[] B =   new int[]{1, 6, 10, 15};
        //expected 5,15
        int[] result2 = findPairInInTwoArray(A,B, -10);
        System.out.println( result2.length!=0 ? (String.valueOf(result2[0])+" and "+String.valueOf(result2[1])):null);
    }

    //two pointers
    public static int[] findPairInInTwoArray(int[] first, int[] second, int target){
        int[] result = new int[2];
        if (first.length==0 || second.length==0) return null;
        int i = 0, j = 0;

        while ( i<first.length && j < second.length){

            if ( first[i] == target + second[j]){
                result[0] = first[i];
                result[1] = second[j];
                return result;
            }
            else if (first[i] < target + second[j]){
                i++;
            }else {
                j++;
            }
        }
        return null;
    }

    //use hashMap
    public static int[] findPairInInTwoArray2(int[] first, int[] second, int target){
        //<value, index> in first array
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i=0; i<first.length; i++){
            map.put(first[i],i);
        }

        for (int j=0; j<second.length; j++){
            if (map.containsKey(target + second[j])){
                return new int[]{target + second[j], second[j]};
            }
        }

        return null;
    }


}
