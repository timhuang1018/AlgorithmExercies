package stack;

import java.util.ArrayList;

public class MinStack {

    /** initialize your data structure here. */
    ArrayList<Integer> container;
    ArrayList<Integer> minContainer;
    int min;
    public MinStack() {
        container = new ArrayList<>();
        minContainer = new ArrayList<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        container.add(x);
        if (x<=min){
            minContainer.add(x);
            min = x;
        }
    }

    public void pop() {
        if (container.isEmpty()) return;

        int last = container.get(container.size()-1);
        container.remove(container.size()-1);
        if (last==min){
            minContainer.remove(minContainer.size()-1);
            if (minContainer.isEmpty()) return;
            min = minContainer.get(minContainer.size()-1);
        }
    }

    public int top() {
        if (container.isEmpty()) return -1;
        return container.get(container.size()-1);
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args) {
        //["MinStack",,"push","top","getMin","pop","getMin"]
        //[[],[2147483646],[2147483646],[2147483647],[],[],[],[],[],[],[2147483647],[],[],[-2147483648],[],[],[],[]]
        MinStack m = new MinStack();
        m.push(2147483646);
        m.push(2147483646);
        m.push(2147483646);
        m.top();
        m.pop();
        m.getMin();
        m.pop();
        m.getMin();
        m.pop();
        m.push(2147483646);
        m.top();
        m.getMin();
        m.push(-2147483646);
        m.top();
        m.getMin();
        m.pop();
        m.getMin();

    }
}
