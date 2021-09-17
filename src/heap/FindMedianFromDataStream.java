package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {

    /** initialize your data structure here. */
    private PriorityQueue<Long> heap1;
    private PriorityQueue<Long> heap2;

    /** initialize your data structure here. */
    public FindMedianFromDataStream() {
        heap1 = new PriorityQueue<Long>((o1, o2) -> (int)(o2-o1));
        heap2 = new PriorityQueue<Long>((p1,p2)-> (int) (p1 - p2));
    }

    public void addNum(int num) {
        if(heap1.isEmpty() || heap1.peek() > num){
            heap1.offer((long)num);
        }else{
            heap2.offer((long)num);
        }

        if(heap1.size() > heap2.size() + 1){
            heap2.offer(heap1.poll());
        }else if(heap2.size()>heap1.size()){
            heap1.offer(heap2.poll());
        }

    }

    public double findMedian() {
        return (heap1.size() + heap2.size()) % 2 != 0 ?
                heap1.peek() :
                (heap1.peek()+heap2.peek()) / 2.0;
    }
    public static void main(String[] args) {
        FindMedianFromDataStream solution = new FindMedianFromDataStream();
        solution.addNum(1);
        solution.addNum(2);
        System.out.println(solution.findMedian());
        solution.addNum(3);
        System.out.println(solution.findMedian());
    }
}
