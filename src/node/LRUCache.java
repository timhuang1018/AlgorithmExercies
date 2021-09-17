package node;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    int capacity, count = 0;
    Map<Integer, DListNode> map = new HashMap<>();
    //head being least used , tail being most used
    //remove and update head node if meet compacity
    DListNode head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    //get key will update the least recently used key
    public int get(int key) {
        DListNode node = map.get(key);

        //update used, move node to tail
        if(node != null){
            updateUsed(node);
            return node.val;
        }else{
            return -1;
        }
    }

    //put first find if key existed
    //if existed , update value and update the least recently used key
    //if not add key , and check if reach capacity, remove the least one and update the least used record
    public void put(int key, int value) {
        DListNode node = map.get(key);

        if(node == null){
            //add to tail
            addTail(key, value);

            count++;
            if(count>capacity){
                //remove head
                map.remove(head.key);
                removeHead();

                count--;
            }

        }else{
            node.val = value;
            //update used, move node to tail
            updateUsed(node);
        }
    }

    private void updateUsed(DListNode node) {
        if (node!=tail){
            if(node!=head){
                node.pre.next = node.next;
                node.next.pre = node.pre;
            }else {
                removeHead();
            }
            tail.next = node;
            node.pre = tail;
            tail = tail.next;
        }
    }

    private void removeHead() {
        head.next.pre = null;
        head = head.next;
    }

    private void addTail(int key, int value){
        if(tail==null){
            tail = new DListNode();
            tail.key = key;
            tail.val = value;
            head = tail;
        }else {
            tail.next = new DListNode();
            tail.next.pre = tail;
            tail = tail.next;
            tail.key = key;
            tail.val = value;
        }
        map.put(key, tail);
    }


    static class DListNode{
        int key;
        int val;
        public DListNode next;
        public DListNode pre;
    }

    public static void main(String[] args) {
        LRUCache t1 = new LRUCache(2);
        t1.put(1,1);
        t1.put(2,2);
        System.out.println(t1.get(1));
        t1.put(3,3);
        System.out.println(t1.get(2));
        t1.put(4,4);
        System.out.println(t1.get(1));
        System.out.println(t1.get(3));
        System.out.println(t1.get(4));
    }
}
