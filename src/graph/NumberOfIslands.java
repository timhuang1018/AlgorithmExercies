package graph;

/**
 * Given an m x n 2D binary grid grid which represents a map of '1's (land)
 * and '0's (water), return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally
 * or vertically. You may assume all four edges of the grid are all surrounded by water.
 */
public class NumberOfIslands {

    int[][] directions = new int[][]{ new int[]{1,0}, new int[]{0,1}, new int[]{0,-1}, new int[]{-1,0}};

    //run through all location on grid
    //resursively check if the island have neighbors, set them visited
    public int numIslands(char[][] grid) {
        int islands = 0;
        for(int i=0; i<grid.length; i++){
            for(int j =0; j<grid[0].length; j++){
                if(grid[i][j] == '1'){
                    islands++;
                    dfs(i, j, grid);
                }
            }
        }

        return islands;
    }

    private void dfs(int x, int y, char[][] grid){
        if( x < 0 || x >= grid.length //boundary
                || y < 0 || y >= grid[0].length //boundary
                || grid[x][y] == '0' //visited
        ){
            return;
        }

        grid[x][y] = '0';
        dfs(x+directions[0][0],y+directions[0][1], grid);
        dfs(x+directions[1][0],y+directions[1][1], grid);
        dfs(x+directions[2][0],y+directions[2][1], grid);
        dfs(x+directions[3][0],y+directions[3][1], grid);
    }

}
