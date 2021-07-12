package array;

public class FindPairInInTwoArray {

    public static void main(String[] args) {
        int[] Alice = new int[]{2, 5, 7, 8, 14};
        int[] Bob =   new int[]{1, 6, 10, 15};
        int[] result = findPairInInTwoArray(Alice,Bob, 18);
        System.out.println( result.length!=0 ? (String.valueOf(result[0])+" and "+String.valueOf(result[1])):null);
    }


    public static int[] findPairInInTwoArray(int[] first, int[] second, int target){
        int[] result = new int[first.length+second.length];
        if (first.length==0 || second.length==0) return null;
        int i = 0, j = second.length-1;
        while ( i<first.length && j >=0){
            int sub = first[i] + second[j];
            if ( sub == target){
                result[0] = first[i];
                result[1] = second[j];
                return result;
            }
            else if (sub<target){
                i++;
            }else {
                j--;
            }
        }
        return null;
    }
}
