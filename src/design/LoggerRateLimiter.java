package design;

import java.util.HashMap;
import java.util.Map;

/**
 * Design a logger system that receives a stream of messages along with their timestamps.
 * Each unique message should only be printed at most every 10 seconds
 * (i.e. a message printed at timestamp t will prevent other identical messages from being printed until timestamp t + 10).
 *
 * All messages will come in chronological order. Several messages may arrive at the same timestamp.
 *
 * Implement the Logger class:
 *
 * Logger() Initializes the logger object.
 * bool shouldPrintMessage(int timestamp, string message) Returns true if the message should be printed in the given timestamp,
 * otherwise returns false.
 */
public class LoggerRateLimiter {

    private Map<String, Integer> newMap = new HashMap<>();
    private Map<String, Integer> oldMap = new HashMap<>();
    int timeToRenew = 0;

    public LoggerRateLimiter() {

    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        //update storage: clear old, keep new, and create a fresh new
        if(timestamp >= timeToRenew + 10){
            oldMap = newMap;
            newMap = new HashMap<>();
            timeToRenew = timestamp;
        }else if(timestamp >= timeToRenew + 20){ //clear all
            oldMap.clear();
            newMap.clear();
            timeToRenew = timestamp;
        }

        if(newMap.containsKey(message)){
            return false;
        }else if(oldMap.containsKey(message) && oldMap.get(message) + 10 > timestamp){
            return false;
        }
        newMap.put(message, timestamp);

        return true;
    }
}
