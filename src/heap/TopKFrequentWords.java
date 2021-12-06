package heap;

import java.util.*;

public class TopKFrequentWords {

    //do word count with hash map
    //use priority queue sort in frequency and alphabet order
    public List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> map = new HashMap<>();

        for(String word : words){
            map.put(word, map.getOrDefault(word, 0)+1);
        }

        PriorityQueue<WordNCount> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.count == o2.count){
                return o1.word.compareTo(o2.word);
            }
            return o2.count - o1.count;
        });

        Iterator it = map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<String, Integer> entry = (Map.Entry)it.next();
            pq.offer(new WordNCount(entry.getKey(), entry.getValue()));
        }

        List<String> result = new ArrayList<>();
        while(k>0){
            result.add(pq.poll().word);
            k--;
        }

        return result;
    }

    static class WordNCount{
        String word;
        int count;

        public WordNCount(String word, int count){
            this.word = word;
            this.count = count;
        }
    }
}
