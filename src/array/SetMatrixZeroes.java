package array;

public class SetMatrixZeroes {

    //1 0 1         0 0 1     0 0 1     0 0 0
    //1 1 1   =>    1 1 1  => 1 0 1 =>  0 0 1
    //0 1 1         0 1 1     0 0 0     0 0 0
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length,left = 0, up = 0;
        int firstRow = 1, firstCol = 1;
        //check firstRow, firstCol separately from others.
        if(matrix[0][0] == 0){
            firstRow = 0;
            firstCol = 0;
        }
        for(int x=0; x < n; x++){
            if(matrix[up][x]==0) firstRow = 0;
        }
        for(int y=0; y < m; y++){
            if(matrix[y][left] == 0) firstCol = 0;
        }
        //check others and mark 0 at left and up;
        for(int i=1; i< m; i++){
            for(int j=1; j< n; j++){
                if(matrix[i][j] == 0){
                    matrix[left][j] = 0;
                    matrix[i][up] = 0;
                }
            }
        }

        //make every cell except first row and col turn into 0
        for(int i=1; i< m ; i++){
            for(int j=1; j< n; j++){
                if(matrix[left][j] == 0 || matrix[i][up] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        //at last, make boudary to be 0 if necessary
        if(firstRow == 0){
            for(int x=0; x < n; x++) matrix[up][x] = 0;
        }
        if(firstCol == 0){
            for(int y=0; y < m; y++) matrix[y][left] = 0;
        }
    }
}
