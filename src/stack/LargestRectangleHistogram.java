package stack;

import java.util.Stack;

public class LargestRectangleHistogram {

    public static int largestRectangleArea(int[] heights) {
        int maxArea = 0, i = 0;
        //store index
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        while (i< heights.length){
            if (stack.size()>1 && heights[stack.peek()] > heights[i]){
                System.out.println("stack peek:"+stack.peek()+",height:"+heights[stack.peek()]+",i:"+i);
                int height = heights[stack.pop()];
                int width =  i - stack.peek() - 1;
                int area = height * width;
                System.out.println("area:"+area+",peek"+stack.peek());
                maxArea = Math.max(area, maxArea);
            }else {
                stack.push(i);
                i++;
            }
        }
        //accending in the end
        while (stack.size()>1){
            System.out.println("stack peek:"+stack.peek()+",height:"+heights[stack.peek()]);
            int height = heights[stack.pop()];
            int width = heights.length - stack.peek() -1;
            int area = height * width;
            maxArea = Math.max(area , maxArea);
            System.out.println("area:"+area+",peek"+stack.peek());
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] t1 = new int[]{2,1,5,0,6,2,3};
        //expected 10
        System.out.println(largestRectangleArea(t1));

        int[] t2 = new int[]{2,4};
        //expected 4
        System.out.println(largestRectangleArea(t2));
    }
}
