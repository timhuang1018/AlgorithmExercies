package design;

import java.util.Stack;

/**
 * Implement a first in first out (FIFO) queue using only two stacks.
 * The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).
 */
public class ImplementQueueUsingStacks {


    Stack<Integer> stack = new Stack<>();
    Stack<Integer> queueLike = new Stack<>();

    //push will do operation in stack
    public void push(int x) {
        stack.push(x);
    }

    //ignore invalid case
    public int pop() {
        if(!queueLike.isEmpty()){
            return queueLike.pop();
        }

        updateStack();

        return queueLike.pop();
    }

    public int peek() {
        if(!queueLike.isEmpty()){
            return queueLike.peek();
        }

        updateStack();

        return queueLike.peek();
    }

    public boolean empty() {
        return stack.isEmpty() && queueLike.isEmpty();
    }

    //move all value in stack to another, this reverse the order
    //now queueLike stack could perform just like queue
    private void updateStack(){
        while(!stack.isEmpty()){
            queueLike.push(stack.pop());
        }
    }
}
