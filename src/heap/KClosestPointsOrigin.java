package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Given an array of points where points[i] = [xi, yi]
 * represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).
 *
 * The distance between two points on the X-Y plane
 * is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
 *
 * You may return the answer in any order.
 * The answer is guaranteed to be unique (except for the order that it is in).
 */
public class KClosestPointsOrigin {

    public static int[][] kClosest(int[][] points, int k){
        PriorityQueue<int[]> heap = new PriorityQueue<>((p1,p2)->p2[0]*p2[0]+p2[1]*p2[1]- p1[0]*p1[0]- p1[1]*p1[1]);
        for (int[] point : points){
            heap.offer(point);
            if (heap.size()>k){
                heap.poll();
            }
        }
        int[][] result = new int[k][2];
        while (k>0){
            result[--k] = heap.poll();
        }
        return result;
    }

    //quick sort, could be use in find Kth problems
    public static int[][] kClosest2(int[][] points, int k) {
        int left =0, right = points.length-1;
        int index = -1;
        while (left<=right){
            index = partition(points, left, right);
            System.out.println(index);
            if (index == k-1){
                break;
            }else if (index > k-1){
                right = index -1;
            }else {
                left = index +1;
            }
        }
        return Arrays.copyOfRange(points, 0, index+1);
    }

    private static int partition(int[][] arr, int start, int end){
        double pivot = euclideanDistance(arr[end][0],arr[end][1]);
        int i = start;
        for (int j= start; j<end; j++){
            if (euclideanDistance(arr[j][0],arr[j][1]) <= pivot){
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, end);
        return i;
    }

    private static void swap(int[][] arr, int i, int j){
        int[] temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static double euclideanDistance(int x, int y){
        return Math.sqrt(x*x + y*y);
    }


    public static void main(String[] args) {
        int[][] t1 = kClosest(new int[][]{new int[]{1,3}, new int[]{-2,2}},1);
        System.out.println(t1[0][0]+ ",and "+t1[0][1]);
    }
}
