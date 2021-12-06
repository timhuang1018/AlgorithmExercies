package tree;

import java.util.concurrent.locks.ReentrantLock;

/**
 * You are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size rows x columns,
 * where heights[row][col] represents the height of cell (row, col). You are situated in the top-left cell, (0, 0),
 * and you hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed). You can move up, down, left, or right, and you wish to find a route that requires the minimum effort.
 *
 * A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.
 *
 * Return the minimum effort required to travel from the top-left cell to the bottom-right cell.
 */
public class PathWithMinimumEffort {

    int min= Integer.MAX_VALUE;

    //return min effort to walk from top-left to bottom-right
    public int bestRoute(int[][] matrix){
        int[] location = new int[]{0,0};
        boolean[][] visited = new boolean[matrix.length][matrix.length];
        moveDfs(matrix, visited ,location, matrix[location[0]][location[1]], 0);
        return min;
    }

    public void moveDfs(int[][] matrix, boolean[][] visited ,int[] location, int previousVal ,int temp){

        //already visited or out of boundary
        if(visited[location[0]][location[1]] || (location[0] > matrix.length - 1 && location[1] > matrix.length - 1)){
            return;
        }


        //result
        if(location[0] == matrix.length - 1 && location[1] == matrix.length - 1){
            //get now value
            int nowVal = matrix[location[0]][location[1]];
            //update max difference in this route
            temp = Math.max(temp, Math.abs(nowVal - previousVal));
            min = Math.min(min, temp);
        }

        //get now value
        int nowVal = matrix[location[0]][location[1]];
        //update max difference in this route
        temp = Math.max(temp, Math.abs(nowVal - previousVal));
        System.out.println("nowVal:"+nowVal+", previous:"+previousVal+",temp:"+temp);

        if(location[0] < matrix.length - 1){
            ++location[0];
            visited[location[0]][location[1]] = true;
            moveDfs(matrix, visited, location, nowVal, temp);
            --location[0];
            visited[location[0]][location[1]] = false;
        }

        if(location[1] < matrix.length - 1){
            ++location[1];
            visited[location[0]][location[1]] = true;
            moveDfs(matrix, visited, location, nowVal, temp);
            --location[1];
            visited[location[0]][location[1]] = false;
        }

    }

    public static void main(String[] args) {

//        PathWithMinimumEffort solution = new PathWithMinimumEffort();
//        //heights = [[1,2,2],[3,8,2],[5,3,5]]
//        int[][] t1 = new int[][]{
//                new int[]{1, 2, 2},
//                new int[]{3, 8, 2},
//                new int[]{5, 3, 5}};
//
//        System.out.println(solution.bestRoute(t1));

        //[[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]

        PathWithMinimumEffort solution2 = new PathWithMinimumEffort();
        //heights = [[1,2,2],[3,8,2],[5,3,5]]
        int[][] t2 = new int[][]{
                new int[]{1,2,1,1,1},
                new int[]{1,2,1,2,1},
                new int[]{1,2,1,2,1},
                new int[]{1,2,1,2,1},
                new int[]{1,1,1,2,1}
        };

        System.out.println(solution2.bestRoute(t2));
    }
}
