package array;

import java.util.ArrayList;
import java.util.Collections;

public class FindDiagonalOrder {

    public int[] findDiagonalOrder(int[][] mat) {
        int N = mat[0].length;
        int M = mat.length;
        int[] result = new int[mat.length * mat[0].length];
        ArrayList<Integer> temp = new ArrayList<>();
        int k=0;
        for (int i=0 ;i< N + M - 1;i++){
            //find the head, always start from top-right
            int r = i < N ? 0 : i - N + 1;
            int c = i < N ? i : N - 1;
            //top-right to bottom-left
            while (c>=0 && r < M){
                temp.add(mat[r++][c--]);
            }
            //adjust even times to start from bottom-left
            if (i % 2 == 0){
                Collections.reverse(temp);
            }
            for (int j=0;j<temp.size();j++){
                result[k++] = temp.get(j);
            }
            temp.clear();
        }

        return result;
    }

    public static void main(String[] args) {
    }
}
