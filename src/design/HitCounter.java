package design;

/**
 * Design a hit counter which counts the number of hits received in the past 5 minutes (i.e., the past 300 seconds).
 *
 * Your system should accept a timestamp parameter (in seconds granularity),
 * and you may assume that calls are being made to the system in chronological order (i.e., timestamp is monotonically increasing).
 * Several hits may arrive roughly at the same time.
 *
 * Implement the HitCounter class:
 *
 * HitCounter() Initializes the object of the hit counter system.
 * void hit(int timestamp) Records a hit that happened at timestamp (in seconds). Several hits may happen at the same timestamp.
 * int getHits(int timestamp) Returns the number of hits in the past 5 minutes from timestamp (i.e., the past 300 seconds).
 */
public class HitCounter {

    //two array, one store timestamp, one store hit count
    int[] buckets = new int[300];
    int[] hits = new int[300];

    public HitCounter() {

    }
    //update outdated record and record hit
    public void hit(int timestamp) {
        int index = timestamp % 300;
        //if bucket need to refresh
        if(timestamp != buckets[index]){
            hits[index] = 0;
            buckets[index] = timestamp;
        }
        hits[index]++;
    }

    //update those outdated record, and get count
    public int getHits(int timestamp) {
        int total = 0;
        for(int i=0; i<hits.length; i++){
            if(buckets[i] + 300 > timestamp){
                total += hits[i];
            }
        }

        return total;
    }
}