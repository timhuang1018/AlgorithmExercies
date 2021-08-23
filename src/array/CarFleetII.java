package array;

import java.util.Arrays;
import java.util.Stack;

/**
 * There are n cars traveling at different speeds in the same direction along a one-lane road.
 * You are given an array cars of length n, where cars[i] = [positioni, speedi] represents:
 *
 * positioni is the distance between the ith car and the beginning of the road in meters.
 * It is guaranteed that positioni < positioni+1.
 * speedi is the initial speed of the ith car in meters per second.
 * For simplicity, cars can be considered as points moving along the number line.
 * Two cars collide when they occupy the same position.
 * Once a car collides with another car, they unite and form a single car fleet.
 * The cars in the formed fleet will have the same position and the same speed, which is the initial speed of the slowest car in the fleet.
 *
 * Return an array answer, where answer[i] is the time, in seconds,
 * at which the ith car collides with the next car, or -1 if the car does not collide with the next car.
 * Answers within 10-5 of the actual answers are accepted
 */
public class CarFleetII {

    public double[] getCollisionTimes(int[][] cars) {
        double[] result = new double[cars.length];
        Stack<Integer> stack = new Stack<>();
        Arrays.fill(result,-1.0);

        for (int i=cars.length-1; i>=0; i--){
            int[] c1 = cars[i];
            while (!stack.isEmpty()){
                int j = stack.peek();
                int[] c2 = cars[j];
                //fulfill two conditions:
                //1. speed is faster than next car
                //2. c1 catches c2 before c2 vanishes into other car
                if (c1[1] > c2[1] && (result[j]== -1.0 || getTime(c1, c2)<= result[j])){
                    result[i] = getTime(c1,c2);
                    break;
                }
                stack.pop();
            }
            stack.push(i);
        }

        return result;
    }

    static double getTime(int[] car1, int[] car2){
        return (car1[0]-car2[0])/ (double)(car2[1]-car1[1]);
    }

    public static void main(String[] args) {
    }
}
