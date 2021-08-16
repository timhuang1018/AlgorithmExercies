package stack;

import java.util.Stack;

/**
 * Given n non-negative integers representing an elevation map
 * where the width of each bar is 1,
 * compute how much water it can trap after raining.
 */
public class TrappingRainWater {

    public int trap(int[] height) {
        if (height==null || height.length<=1) return 0;

        Stack<Integer> stack = new Stack<>();
        int water = 0, i = 0;

        while (i<height.length){
            if (!stack.isEmpty() && height[stack.peek()] < height[i]){

                int previous = stack.pop();
                if (!stack.isEmpty()){
                    int minHeight = Math.min(height[stack.peek()], height[i]);

                    water+= (minHeight - height[previous]) * (i - stack.peek() - 1);
                }
            }else {
                stack.push(i);
                i++;
            }
        }

        return water;
    }
}
