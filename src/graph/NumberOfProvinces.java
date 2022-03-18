package graph;

import java.util.HashSet;
import java.util.Set;

public class NumberOfProvinces {

    //1,1,0
    //1,1,0
    //0,0,1

    public int findCircleNum(int[][] isConnected) {
        Set<Integer> visited = new HashSet<>();

        int row = 0, n = isConnected.length;
        int province = 0;

        while(row < n){

            if(!visited.contains(row)){
                province++;
                dfs(isConnected, visited, row);
            }
            row++;
        }

        return province;
    }

    private void dfs(int[][] isConnected, Set<Integer> visited, int row) {
        for(int col= 0; col < isConnected.length; col++){

            System.out.println("col:"+col+",row:"+row+",visited:"+visited);

            if(isConnected[row][col] == 1 && !visited.contains(col)){
                visited.add(col);
                dfs(isConnected, visited, col);
            }
        }
    }


    public static void main(String[] args) {
        NumberOfProvinces solution = new NumberOfProvinces();
        //expected 2
        System.out.println(solution.findCircleNum(new int[][]{
                new int[]{1,1,0},
                new int[]{1,1,0},
                new int[]{0,0,1}}));

        //expected 1
        System.out.println(solution.findCircleNum(new int[][]{
                new int[]{1,0,0,1},
                new int[]{0,1,1,0},
                new int[]{0,1,1,1},
                new int[]{1,0,1,1},
        }));
    }
}
