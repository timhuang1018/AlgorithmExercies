package graph;

public class MaxAreaOfIsland {

    //connection in four directions
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for(int i = 0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==1){
                    maxArea = Math.max(maxArea, dfs(i, j, grid));
                }
            }
        }

        return maxArea;
    }

    public int dfs(int row, int column, int[][] grid){
        if(row<0 || column<0 || row >= grid.length || column>= grid[0].length ||
                grid[row][column] ==0){
            return 0;
        }

        grid[row][column] = 0;

        return dfs(row+1, column, grid) +
                dfs(row-1, column, grid) +
                dfs(row, column+1, grid) +
                dfs(row, column-1, grid) + 1;
    }


    public static void main(String[] args) {
        MaxAreaOfIsland solution = new MaxAreaOfIsland();
        System.out.println(solution.maxAreaOfIsland(new int[][]{
                new int[]{0,0,1,0,0,0,0,1,0,0,0,0,0},
                new int[]{0,0,0,0,0,0,0,1,1,1,0,0,0},
                new int[]{0,1,1,0,1,0,0,0,0,0,0,0,0},
                new int[]{0,1,0,0,1,1,0,0,1,0,1,0,0},
                new int[]{0,1,0,0,1,1,0,0,1,1,1,0,0},
                new int[]{0,0,0,0,0,0,0,0,0,0,1,0,0},
                new int[]{0,0,0,0,0,0,0,1,1,1,0,0,0},
                new int[]{0,0,0,0,0,0,0,1,1,0,0,0,0}
        }));
    }
}
