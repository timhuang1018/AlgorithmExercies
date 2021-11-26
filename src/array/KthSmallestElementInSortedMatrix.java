package array;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthSmallestElementInSortedMatrix {

    //use heap sort the element of first index of each row
    //start taking out value from heap until kth element
    //after taking out element, increment column and add into heap again

    //time O(nlogn) space O(n)
    public static int kthSmallest(int[][] matrix, int k) {
        Queue<Cell> heap = new PriorityQueue<>((p1,p2)-> p1.val - p2.val);

        for (int row=0; row < matrix.length; row++){
            heap.offer(new Cell(row,0, matrix[row][0]));
        }

        int find = 0;

        while (k > 0 && !heap.isEmpty()){
            Cell cell = heap.poll();
            find = cell.val;
            cell.col += 1;
            if (cell.col == matrix[cell.row].length){
                k--;
                continue;
            }
            cell.val = matrix[cell.row][cell.col];
            heap.offer(cell);
            k--;
        }

        return find;
    }


    static class Cell{
        int row;
        int col;
        int val;

        public Cell(int row, int col,int val){
            this.row = row;
            this.col = col;
            this.val = val;
        }

        @Override
        public String toString() {
            return "Cell{" +
                    "row=" + row +
                    ", col=" + col +
                    ", val=" + val +
                    '}';
        }
    }

    public static void main(String[] args) {
        //expected 13
        kthSmallest(
                new int[][]{
                        new int[]{1,5,9},
                        new int[]{10,11,13},
                        new int[]{12,13,15}},
                8);

        kthSmallest(
                new int[][]{new int[]{-5}}, 1);
    }
}
