package array;

import helper.DataLogger;

public class SpiralMatrixII {

    public static int[][] generateMatrix(int n) {
        int[][] grid = new int[n][n];
        //moving order: right -> down -> left -> up -> right -> ...
        int[][] directions = new int[][]{
                new int[]{0, 1},
                new int[]{1, 0},
                new int[]{0, -1},
                new int[]{-1, 0}};
        int[] location = new int[2];
        int count = 1;
        //visit first cell before loop
        grid[location[0]][location[1]] = count;
        int direction = 0;

        while (count < n*n) {
            //moving in this direction is legal and the cell has not been visited yet (no value)
            while (location[0] + directions[direction][0] >= 0 &&
                    location[0] + directions[direction][0] < n &&
                    location[1] + directions[direction][1] >= 0 &&
                    location[1] + directions[direction][1] < n &&
                    grid[location[0]+ directions[direction][0]][location[1] + directions[direction][1]] ==0
            ) {
                location[0] += directions[direction][0];
                location[1] += directions[direction][1];
                grid[location[0]][location[1]] = ++count;
            }
            //change direction or reset if direction reach last one (3)
            if (direction == 3) {
                direction = 0;
            } else {
                direction += 1;
            }
        }
        return grid;
    }

    public static void main(String[] args) {
        DataLogger.print2DArray(generateMatrix(3));
    }
}
