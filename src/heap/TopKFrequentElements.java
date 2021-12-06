package heap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length==k) return nums;

        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
        }

        //use a max heap record how many times a number show up in nums
        PriorityQueue<Map.Entry<Integer,Integer>> heap = new PriorityQueue<>((p1,p2)-> p2.getValue() - p1.getValue());

        Iterator mapIterator = map.entrySet().iterator();
        while (mapIterator.hasNext()){
            Map.Entry<Integer,Integer> entry = (Map.Entry)mapIterator.next();
            heap.add(entry);
        }

        int[] result = new int[k];

        while (k>0){
            result[k-1] = heap.poll().getKey();
            k--;
        }
        return result;
    }
}
