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
        int leftCells = n * m;
        int position = 0;
        while (leftCells>0){

            //random api start from 0
            int randomInt = new Random().nextInt(leftCells) + 1;
            if (randomInt<k){
                int column = position % m;
                int row = position / m;
                result[row][column] = true;
                k--;
                if (k==0) break;
            }
            position++;
            leftCells--;
        }
        return result;
    }
}
