package design;

/**
 * This class provide hashmap function such as put, get, remove (CRUD)
 */
class MyHashMap {

    //create a doubly linkedlist data structure
    //init a dummy (psuedo head) at constructor
    //all crud move will take O(n) time
    //if we put in sorted order then could apply binary search , so it will be O(nlogn)
    DoublyNode dummy;

    public MyHashMap() {
        dummy = new DoublyNode(-1, -1);
    }

    //check if there is node have same key
    //if not, insert one in proper position
    //if so , increment exist value by new value
    public void put(int key, int value) {
        DoublyNode exist = null, visitor = dummy.next, tail = null;
        while(visitor != null){
            tail = visitor;
            if(visitor.key == key){
                exist = visitor;
            }
            visitor = visitor.next;
        }

        if(exist !=null){
            exist.value = value;
        }else if(tail !=null){
            tail.next = new DoublyNode(key, value);
            tail.next.previous = tail;
        }else{
            dummy.next = new DoublyNode(key, value);
            dummy.next.previous = dummy;
        }
    }

    public int get(int key) {
        DoublyNode visitor = dummy.next;
        while(visitor != null){
            if(visitor.key == key){
                return visitor.value;
            }
            visitor = visitor.next;
        }

        return -1;
    }

    public void remove(int key) {
        DoublyNode visitor = dummy.next;
        while(visitor != null){
            if(visitor.key == key){
                DoublyNode pre = visitor.previous;
                DoublyNode next = visitor.next;
                if(next == null){
                    pre.next = null;
                }else{
                    pre.next = next;
                    next.previous = pre;
                }
            }
            visitor = visitor.next;
        }
    }

    static class DoublyNode{
        DoublyNode previous;
        DoublyNode next;
        int key;
        int value;
        public DoublyNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        MyHashMap solution = new MyHashMap();
        solution.remove(27);
        solution.put(65,65);
        solution.remove(19);
        solution.remove(0);
        solution.get(18);
        solution.remove(3);
        solution.put(42,0);
        solution.get(19);
        solution.remove(42);
        solution.put(17,90);
        solution.put(31,76);
        solution.put(48,71);
        solution.put(5,50);
        solution.put(7,68);
        solution.put(73,74);
        solution.put(85,18);
        solution.put(74,95);
        solution.put(84,82);
        solution.put(59,29);
        solution.put(71,71);
        solution.remove(42);
        solution.put(51,40);
        solution.put(33,76);
        solution.get(17);
        solution.put(89,95);
        solution.get(95);
        solution.put(30,31);
        solution.put(37,99);
        solution.get(51);
        solution.put(95,35);
        solution.remove(65);
        solution.remove(81);
//    "put","put","get","remove","put","put","put","get","put","put","remove","put","remove","remove","remove","put","remove","get","put","put","put","put","remove","put","get","put","put","get","put","remove","get","get","remove","put","put","put","put","put","put","get","get","remove","put","put","put","put","get","remove","put","put","put","put","put","put","put","put","put","put","remove","remove","get","remove","put","put","remove","get","put","put"
//[61,46],[50,33],[59],[5],[75,89],[80,17],[35,94],[80],[19,68],[13,17],[70],[28,35],[99],[37],[13],[90,83],[41],[50],[29,98],[54,72],[6,8],[51,88],[13],[8,22],[85],[31,22],[60,9],[96],[6,35],[54],[15],[28],[51],[80,69],[58,92],[13,12],[91,56],[83,52],[8,48],[62],[54],[25],[36,4],[67,68],[83,36],[47,58],[82],[36],[30,85],[33,87],[42,18],[68,83],[50,53],[32,78],[48,90],[97,95],[13,8],[15,7],[5],[42],[20],[65],[57,9],[2,41],[6],[33],[16,44],[95,30]]
    }
}
