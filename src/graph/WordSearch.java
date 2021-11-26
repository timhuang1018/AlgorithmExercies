package graph;

public class WordSearch {

    //visit all cell to find the first char of word
    //then find word in sequentially
    //recursion in 4 directions and char not reused
    //only return true when all char
    public boolean exist(char[][] board, String word) {

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(dfs(i, j, board, word, 0)) return true;
            }
        }

        return false;
    }

    public boolean dfs(int row, int col, char[][] board, String word, int index){
        //found
        if(index == word.length()){
            return true;
        }

        //not qualified
        if(row<0 || col<0 || row>= board.length || col>= board[0].length ||
                word.charAt(index) != board[row][col]){
            return false;
        }
        //mark visited
        board[row][col] = '*';

        boolean result = dfs(row+1, col, board, word, index+1) ||
                dfs(row, col+1, board, word, index+1) ||
                dfs(row-1, col, board, word, index+1) ||
                dfs(row, col-1, board, word, index+1);

        board[row][col] = word.charAt(index);

        return result;
    }
}
