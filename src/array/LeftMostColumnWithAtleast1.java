package array;

/**
 * Given a binary matrix mat[][] containing 0’s and 1’s.
 * Each row of the matrix is sorted in the non-decreasing order,
 * the task is to find the left-most column of the matrix with at least one 1 in it.
 * Note: If no such column exists return -1.
 */
public class LeftMostColumnWithAtleast1 {

    public static int search(int mat[][], int n, int m){
        int i =0, j=mat[0].length -1, leftMost = -1;
        while (i<mat.length && j>=0){
            int result = mat[i][j];
            if (result==0){
                i++;
            }else {
                leftMost = j;
                j--;
            }
        }
        return leftMost;
    }

    public static void main(String[] args) {
        int[][] mat1 = new int[][]{ {0, 0}, {1, 1} };
        assert search(mat1,1,1) == 1;
        int[][] mat2 = new int[][]{{0, 0}, {0, 0}};

    }
}
