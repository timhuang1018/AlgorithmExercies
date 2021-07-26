package array;

/**
 * Given an array that represents elements of arithmetic progression in order.
 * One element is missing in the progression, find the missing number.
 */
public class MissingNumberArithmeticProgression {


    public static int missingElement(int arr[], int n) {
        int lo = 0, hi = n -1 ;
        while (lo <= hi){
            int mid = lo + (hi - lo)/2 ;
            System.out.println("mid:"+mid);
            //target will be double value since left is 1d, then right will be 2d
            if (mid!=0 && (arr[mid] - arr[mid-1] == (arr[mid+1] - arr[mid])/2)){
                return arr[mid] + (arr[mid] - arr[mid-1]);
            }
            //check which distance is longer
            else if (arr[mid] - arr[lo] > arr[hi] - arr[mid]){
                hi = mid - 1;
            }else {
                lo = mid + 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] arr1 = new int[]{ 3, 6, 12, 15, 18};
        int t1 = missingElement(arr1,arr1.length);
        //expected 9
        System.out.println(t1);
        int[] arr2 = new int[]{ 1,2,3,4,6};
        int t2 = missingElement(arr2,arr2.length);
        //expected 5
        System.out.println(t2);
    }
}
