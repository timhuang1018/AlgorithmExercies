package array;

import java.util.Stack;

/**
 * We are given an array asteroids of integers representing asteroids in a row.
 *
 * For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
 *
 * Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
 *
 *
 * Example 1:
 *
 * Input: asteroids = [5,10,-5]
 * Output: [5,10]
 * Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
 * Example 2:
 *
 * Input: asteroids = [8,-8]
 * Output: []
 * Explanation: The 8 and -8 collide exploding each other.
 * Example 3:
 *
 * Input: asteroids = [10,2,-5]
 * Output: [10]
 * Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
 */
public class AsteroidCollision {

    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> keeps = new Stack<>();
        int index = 0;
        while(index < asteroids.length){
            int a = asteroids[index];
            //collide only when top of keep is going forward and new one is going backward
            if(!keeps.isEmpty() && keeps.peek() > 0 && a < 0){
                //separa conditions:
                if(keeps.peek() < -a){
                    keeps.pop();
                }else if(keeps.peek()== -a){
                    keeps.pop();
                    index++;
                }else{
                    index++;
                }
            }else{
                keeps.push(a);
                index++;
            }
        }

        int[] result = new int[keeps.size()];
        for(int j=result.length-1; j>=0; j--){
            result[j] = keeps.pop();
        }
        return result;
    }
}
