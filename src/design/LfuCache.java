package design;

import java.util.HashMap;
import java.util.Map;

public class LfuCache {

    int capacity;
    Map<Integer, DListNode> map;
    DListNode head;
    DListNode tail;

    public LfuCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new DListNode(-1, -1);
        tail = new DListNode(-1, -1);
        tail.frequency = Integer.MAX_VALUE;
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        DListNode find = map.get(key);
        if(find != null){
            updateNode(find);
            return find.value;
        }

        return -1;
    }

    public void put(int key, int value) {
        DListNode find = map.get(key);

        if(find != null){
            find.value = value;
            updateNode(find);

        }else{
            find = new DListNode(key, value);

            if(map.size() >= capacity){
                DListNode removeNode = head.next;
                breakFromChain(removeNode);
                map.remove(removeNode.key);
            }

            map.put(key, find);
            addByFrequency(find);

        }
    }


    private void updateNode(DListNode node){
        breakFromChain(node);
        addByFrequency(node);
    }

    private void addByFrequency(DListNode node){
        node.frequency++;
        DListNode visitor = tail;
        //last one is the dummy head;
        while(visitor.frequency > node.frequency){
            visitor = visitor.pre;
        }
        visitor.next.pre = node;
        node.next = visitor.next;
        node.pre = visitor;
        visitor.next = node;
    }

    private void breakFromChain(DListNode node){
        //take the node out of chain
        DListNode pre = node.pre;
        DListNode next = node.next;
        pre.next = next;
        next.pre = pre;
    }

    static class DListNode{
        int key;
        int value;
        int frequency;
        DListNode next;
        DListNode pre;
        public DListNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LfuCache solution = new LfuCache(0);
//        solution.put(1,1);
//        solution.put(2,2);
//        //expected 1
//        solution.get(1);
//        solution.put(3,3);
//        //expected -1
//        solution.get(2);
//        //expected 3
//        solution.get(3);
//        solution.put(4,4);
//        //expected -1
//        solution.get(1);
//        //expected 3
//        solution.get(3);
//        //expected 4
//        solution.get(4);

        solution.put(0,0);
        solution.get(0);

    }
}
