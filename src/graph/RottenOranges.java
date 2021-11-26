package graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    //find all cells value are 2, and count total 1
    //count level(minute) by BFS, and decrease fresh orange total
    //if total down to 0, return levels
    //if queue run out cell first, return -1
    public int orangesRotting(int[][] grid) {

        int freshTotal = 0;
        Queue<int[]> rottens = new LinkedList<>();
        int[][] neighbors = new int[][]{
                new int[]{0,1},
                new int[]{0,-1},
                new int[]{1,0},
                new int[]{-1,0}
        };

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1){
                    freshTotal++;
                }else if(grid[i][j] == 2){
                    rottens.offer(new int[]{i,j,0});
                }
            }
        }

        while(!rottens.isEmpty()){
            int[] rotten = rottens.poll();
            for(int[] shift : neighbors){
                int i = rotten[0] + shift[0], j = rotten[1] + shift[1];
                //only fresh is target
                if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]!=1){
                    continue;
                }
                grid[i][j] = 2;
                freshTotal--;
                if(freshTotal == 0){
                    return rotten[2] + 1;
                }
                rottens.offer(new int[]{i, j, rotten[2]+1});
            }
        }

        return freshTotal == 0? 0 : -1;
    }

    public static void main(String[] args) {
        RottenOranges solution = new RottenOranges();
        System.out.println(solution.orangesRotting(new int[][]{new int[]{2,1,1},new int[]{1,1,0},new int[]{0,1,1}}));
    }
}
