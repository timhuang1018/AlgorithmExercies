package stack;

import java.util.Stack;

/**
 * Given an array of integers temperatures represents the daily temperatures,
 * return an array answer such that answer[i] is the number of days
 * you have to wait after the ith day to get a warmer temperature.
 * If there is no future day for which this is possible, keep answer[i] == 0 instead.
 *
 * Example 1:
 *
 * Input: temperatures = [73,74,75,71,69,72,76,73]
 * Output: [1,1,4,2,1,1,0,0]
 * Example 2:
 *
 * Input: temperatures = [30,40,50,60]
 * Output: [1,1,1,0]
 * Example 3:
 *
 * Input: temperatures = [30,60,90]
 * Output: [1,1,0]
 */
public class DailyTemperatures {

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<DayWrapper> stack = new Stack<>();

        for (int i=0; i<temperatures.length; i++){
            int now = temperatures[i];

            while (!stack.isEmpty() && stack.peek().temperature < now){
                DayWrapper dw = stack.pop();
                result[dw.day] = i - dw.day;
            }

            stack.push(new DayWrapper(i,now));
        }

        return result;
    }

    static class DayWrapper{
        public DayWrapper(int day, int temperature){
            this.day = day;
            this.temperature = temperature;
        }
        int day;
        int temperature;
    }

    public static void main(String[] args) {
        int[] temps = new int[]{73,74,75,71,69,72,76,73};
        dailyTemperatures(temps);
    }
}
