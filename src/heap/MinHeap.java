package heap;

import java.util.List;

public class MinHeap {

    List<Integer> heap;

    public void add(int n) {
        int index = heap.size();
        heap.add(n);

        //compare to parent
        while (index>0 && heap.get((index-1)/2)> n){
            swap(heap, index, (index-1)/2);
            index = (index-1)/2;
        }
    }

    //remove and return the top (min) element
    public int poll() {
        int top = heap.get(0);
        swap(heap, 0, heap.size()-1);
        heap.remove(heap.size()-1);

        int index = 0;
        while ( 2*index+1 < heap.size()){
            int left = 2*index +1, right = 2*index +2;
            int leftChild = heap.get(left), rightChild = right<heap.size()? heap.get(right) : Integer.MAX_VALUE;
            int parent = heap.get(index);

            //compare three elements
            if (parent<= leftChild && parent <= rightChild){
                return top;
            }else if (leftChild < parent && leftChild<= rightChild){
                swap(heap, index, left);
                index = left;
            }else {
                swap(heap, index, right);
                index = right;
            }
        }

        return top;
    }

    //return the top (min) element
    public int peek() {
        return heap.get(0);
    }

    private void swap(List<Integer> list, int index1, int index2){
        Integer temp = list.get(index1);

        list.set(index1, list.get(index2));
        list.set(index2, temp);
    }
}
