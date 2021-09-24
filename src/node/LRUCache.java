package node;

import helper.DListNode;

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
        //put dummy node at both end
        this.head = new DListNode();
        this.tail = new DListNode();
        head.next = tail;
        tail.pre = head;
        System.out.println("dummy head:"+head);
        System.out.println("dummy tail:"+tail);
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
            DListNode addNode = new DListNode();
            addNode.key = key;
            addNode.val = value;
            map.put(key, addNode);
            addTail(addNode);

            count++;
            System.out.println("count:"+count+",map:"+map);
            if(count>capacity){
                //remove head
                DListNode realHead = head.next;
                map.remove(realHead.key);
                removeNode(realHead);

                count--;
            }

        }else{
            node.val = value;
            //update used, move node to tail
            updateUsed(node);
        }
    }

    private void updateUsed(DListNode node) {
        removeNode(node);
        addTail(node);
    }

    private void removeNode(DListNode node) {
        node.next.pre = node.pre;
        node.pre.next = node.next;
    }

    //always insert before dummy tail
    private void addTail(DListNode addNode){
        tail.pre.next = addNode;
        addNode.pre = tail.pre;
        tail.pre = addNode;
        addNode.next = tail;
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
