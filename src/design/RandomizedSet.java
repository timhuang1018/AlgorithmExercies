package design;

import java.util.*;

/**
 * Implement the RandomizedSet class:
 *
 * RandomizedSet() Initializes the RandomizedSet object.
 * bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
 * bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
 * int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.
 * You must implement the functions of the class such that each function works in average O(1) time complexity.
 *
 * Constraints:
 *
 * -231 <= val <= 231 - 1
 * At most 2 * 105 calls will be made to insert, remove, and getRandom.
 * There will be at least one element in the data structure when getRandom is called.
 */
public class RandomizedSet {

    //use Map to validate insert and remove
    //use list and do the O(1) get with random index within its size

    //value, index in list
    Map<Integer, Integer> map = new HashMap<>();
    //for random method to do at O(1)
    List<Integer> list = new ArrayList<>();

    public RandomizedSet() {
    }

    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }

        list.add(val);
        map.put(val, list.size()-1);
        return true;
    }

    public boolean remove(int val) {
        if(map.containsKey(val)){
            int index = map.get(val);
            if(index < list.size()-1){ // not the last one then use last one overwrite this val's index
                int lastOne = list.remove(list.size()-1);
                list.set(index, lastOne);
                map.put(lastOne, index); //update old lastOne index
            }else{
                list.remove(index);
            }
            map.remove(val);

            return true;
        }
        return false;
    }

    public int getRandom() {
        return list.get(new Random().nextInt(list.size()));
    }
}
