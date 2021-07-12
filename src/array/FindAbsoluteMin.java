package array;

public class FindAbsoluteMin {

    public static int findAbsoluteMin(int[] first, int[] second){
        if (first==null || second==null) return 0;
        if (first.length==0 || second.length==0) return 0;
        int i = 0, j = 0;
        int min = Integer.MAX_VALUE;

        while ( i<first.length && j < second.length){
            int diff = Math.abs(first[i]-second[j]);
            if (diff<min){
                min = diff;
            }
            if (first[i]<second[j]){
                i++;
            }else {
                j++;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{-2, 5, 14, 23, 33,52,53,59, 60};
        int[] arr2 = new int[]{-10, 10, 47, 57, 62, 66,  111};
        int result = findAbsoluteMin(arr1,arr2);
        System.out.println(result);
    }
}
