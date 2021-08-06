package greedy;

import java.util.Random;

/**
 * Given two integers N and M, randomly generate a mine sweeping board of size M x N,
 * with K mines on the board.
 * Every cell on the board has the same chance of getting mined.
 *
 * input
 * n = 3, m = 2, k = 2
 * a possible output
 * [[F, T, F], [T, F, F]]
 * 2 mines were placed randomly
 */

public class GenerateMineSweepBoard {
    //assume input n are rows, m are columns
    public boolean[][] generateMineSweepBoard(int n, int m, int k) {
        boolean[][] result = new boolean[n][m];
        while (k>0){
            int position = new Random().nextInt(k+1);
            int column = position % m;
            int row = position / m;
            //if happened to choose the one being mine already
            // set a cell to be mine from start
            if (result[row][column]){
                position = 0;
                while (position< n * m){
                    column = position % m;
                    row = position / m;
                    if (!result[row][column]){
                        result[row][column] = true;
                        break;
                    }
                    position++;
                }
            }else{
                result[row][column]= true;
            }
            k--;
        }
        return result;
    }
}
