package backtrack;

import data.NestedInteger;
import data.NestedIntegerImpl;

import java.util.*;

public class NestedIterator implements Iterator<Integer> {

    /*
        iterate using deque
     */
    Deque<NestedInteger> deque = new ArrayDeque<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        for (int i = 0; i < nestedList.size(); i++){
            deque.addLast(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        if (!hasNext()){
            return null;
        }
        return deque.pollFirst().getInteger();
    }

    @Override
    public boolean hasNext() {

        while(!deque.isEmpty() && !deque.peekFirst().isInteger()){
            List<NestedInteger> nestedList = deque.pollFirst().getList();
            for (int j = nestedList.size() - 1; j >= 0;j--){
                deque.addFirst(nestedList.get(j));
            }
        }

        return !deque.isEmpty();
    }




    /*
        original thought: preprocess and get all integer at construct phase using recursion
     */

//    NestedInteger head;
//    int listIndex = 0;
//    List<Integer> numbers = new ArrayList<>();
//
//    public NestedIterator(List<NestedInteger> nestedList) {
//        //nestedList.length >= 1
//        head = nestedList.get(0);
//
//        for(int i = 0; i < nestedList.size(); i++){
//            dfs(numbers, nestedList.get(i));
//        }
//    }
//
//    private void dfs(List<Integer> numbers, NestedInteger nested){
//        if(nested.isInteger()){
//            numbers.add(nested.getInteger());
//            return;
//        }
//
//        for(int j = 0; j < nested.getList().size(); j++){
//            dfs(numbers, nested.getList().get(j));
//        }
//    }
//
//    @Override
//    public Integer next() {
//        if(!hasNext()){
//            return null;
//        }
//        return numbers.get(listIndex++);
//    }
//
//    @Override
//    public boolean hasNext() {
//        return listIndex < numbers.size();
//    }
}
