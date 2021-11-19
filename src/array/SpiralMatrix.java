package array;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return res;

        //use four border as condition and location
        int n = matrix.length, m = matrix[0].length;
        int up = 0,  down = n - 1;
        int left = 0, right = m - 1;
        while (res.size() < n * m) {
            //top-left to top-right
            for (int j = left; j <= right && res.size() < n * m; j++)
                res.add(matrix[up][j]);

            //top-right to bottom-right
            for (int i = up + 1; i <= down - 1 && res.size() < n * m; i++)
                res.add(matrix[i][right]);

            //bottom-right to bottom-left
            for (int j = right; j >= left && res.size() < n * m; j--)
                res.add(matrix[down][j]);

            //bottom-left to top-left
            for (int i = down - 1; i >= up + 1 && res.size() < n * m; i--)
                res.add(matrix[i][left]);

            //update border
            left++; right--; up++; down--;
        }
        return res;
    }




    //moving order: right -> down -> left -> up -> right -> ...
    private int[][] directions = new int[][]{
            new int[]{0,1},
            new int[]{1,0},
            new int[]{0,-1},
            new int[]{-1,0}
    };

    public List<Integer> spiralOrder2(int[][] matrix) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        List<Integer> result = new ArrayList<>();
        int[] location = new int[2];

        spiralVisit(matrix, visited, result, location, 0);

        return result;
    }

    public void spiralVisit(int[][] matrix,boolean[][] visited,List<Integer> result, int[] location, int indexDirs){


        result.add(matrix[location[0]][location[1]]);
        visited[location[0]][location[1]] = true;

        int[] direction = directions[indexDirs];
        int original = indexDirs;

        //check if need to change direction
        while(!isValidUpdate(matrix, visited, location, direction)){
            System.out.println("original:"+original+", index now:"+indexDirs);
            indexDirs++;
            if(indexDirs == directions.length){
                indexDirs = 0;
            }
            //all cells in matrix are visited
            if(indexDirs == original){
                return;
            }
            direction = directions[indexDirs];
        }
        System.out.println("index:"+indexDirs);
        //update location
        location[0] += direction[0];
        location[1] += direction[1];

        spiralVisit(matrix, visited, result, location, indexDirs);
    }

    private boolean isValidUpdate(int[][] matrix, boolean[][] visited,int[] location ,int[] direction){
        return  location[0] + direction[0] >= 0 &&
                location[0] + direction[0] < matrix.length &&
                location[1] + direction[1] >= 0 &&
                location[1] + direction[1] < matrix[0].length &&
                !visited[location[0]+direction[0]][location[1]+direction[1]];
    }

    public static void main(String[] args) {
        SpiralMatrix solution = new SpiralMatrix();
        System.out.println(solution.spiralOrder(
                new int[][]{
                        new int[]{1,2,3},
                        new int[]{4,5,6},
                        new int[]{7,8,9}}));
    }
}
