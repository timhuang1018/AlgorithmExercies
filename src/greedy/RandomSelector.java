package greedy;

import java.util.ArrayList;
import java.util.Random;

/**
 * Given a data stream of Pair(number, frequency),
 * every time when a new pair comes in,
 * return a randomly select number from the existing set of numbers.
 * input
 * streaming...
 * (10, 2) -> output 10
 * (20, 3) -> 40% chance to output 10;
 * 60% output 20. (30, 5) -> 20% output 2;
 * 30% output 3; 50% output 5
 */
public class RandomSelector {

    private ArrayList<Pair> list = new ArrayList<>();
    private int totalWeight = 0;

    public int readNextFromStream(Pair n) {
        list.add(n);
        totalWeight += n.weight;
        int atPoint = new Random().nextInt(totalWeight+1);
        int result = 0;
        int temp = 0;
        for (int i=0; i< list.size();i++){
            Pair p = list.get(i);
            temp += p.weight;
            if (temp >= atPoint){
                result = p.output;
                break;
            }
        }
        return result;
    }

    static class Pair{
        public int output;
        public int weight;
    }
}
