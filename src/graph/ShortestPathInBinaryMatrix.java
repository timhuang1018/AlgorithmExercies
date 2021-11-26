package graph;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {

    //shortest clear path is shortest level
    //start from top-left(0,0) , finish at bottom-right
    //only use cell has 0 value
    //consider all 8 directions at each level
    public int shortestPathBinaryMatrix(int[][] grid) {
        //8 directions
        int[][] directions = new int[][]{
                new int[]{0,1},
                new int[]{1,1},
                new int[]{1,0},
                new int[]{0,-1},
                new int[]{-1,0},
                new int[]{-1,-1},
                new int[]{-1,1},
                new int[]{1,-1},

        };
        Queue<int[]> queue = new LinkedList<>();
        int endRow = grid.length - 1, endCol = grid[0].length -1;

        if(grid[0][0] == 0 && grid[endRow][endCol] == 0){
            //row, col, level
            queue.add(new int[]{0,0,0});
            grid[0][0] = 1;
        }

        while(!queue.isEmpty()){
            int[] parent = queue.poll();
            if(parent[0] == endRow && parent[1] == endCol){
                return parent[2] + 1;
            }

            for(int[] dir : directions){
                int nextRow = parent[0] + dir[0], nextCol = parent[1]+ dir[1];

                if(nextRow >= 0 && nextCol >= 0 && nextRow<= endRow && nextCol <= endCol &&
                        grid[nextRow][nextCol] == 0){

                    grid[nextRow][nextCol] = 1;
                    queue.offer(new int[]{nextRow, nextCol, parent[2]+1});
                }
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        ShortestPathInBinaryMatrix solution = new ShortestPathInBinaryMatrix();

//        //expected 4
//        System.out.println(solution.shortestPathBinaryMatrix(new int[][]{
//                new int[]{0,0,0},
//                new int[]{1,1,0},
//                new int[]{1,1,0}
//        }));
//
//        //expected -1
//        System.out.println(solution.shortestPathBinaryMatrix(new int[][]{
//                new int[]{1,0,0},
//                new int[]{1,1,0},
//                new int[]{1,1,0}
//        }));

        //expected 1
        System.out.println(solution.shortestPathBinaryMatrix(new int[][]{new int[]{0}}));
    }
}
