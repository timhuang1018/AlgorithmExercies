package greedy;

import helper.DataLogger;

import java.util.*;
import java.util.logging.Logger;

/**
 * Given a time represented in the format "HH:MM",
 * form the next closest time by reusing the current digits.
 * There is no limit on how many times a digit can be reused.
 * You may assume the given input string is always valid.
 * For example, "01:34", "12:09" are all valid. "1:34", "12:9" are all invalid.
 *
 * Input: "19:34"
 * Output: "19:39"
 * Explanation: The next closest time choosing from digits 1, 9, 3, 4, is 19:39,
 * which occurs 5 minutes later.
 * It is not 19:33, because this occurs 23 hours and 59 minutes later.
 *
 * Input: "23:59"
 * Output: "22:22"
 * Explanation: The next closest time choosing from digits 2, 3, 5, 9, is 22:22.
 * It may be assumed that the returned time is next day's time since it is smaller than the input time numerically.
 */
public class NextClosestTime {

    private static final int MAXIMUM_HOURS = 24;
    private static final int MAXIMUM_MINUTES = 60;

    public static String nextClosestTime(String time){

        char[] chars = (time.substring(0,2)+time.substring(3)).toCharArray();
        List<Integer> usableNumbers = ascendingNumbers(chars);
        //start compare from last 2 to last one
        int i = chars.length-2;

        while (i>=0){
            int index = chars[i+1]<chars[i] ? i : i+1;
            Integer bigger = findBigger(usableNumbers, chars[index]-'0');

            if (bigger!=null && isValid(chars, index, bigger)){
                chars[index] = (char)(bigger + '0');
                return mergeChars(chars);
            }
            i--;
        }

        //no next closest time today, use min number to form the time at tomorrow
        String min = usableNumbers.get(0).toString();
        return min+min+":"+min+min;
    }

    public static String mergeChars(char[] array){
        StringBuilder sb = new StringBuilder();
        for (int j=0; j<array.length; j++){
            sb.append(array[j]);
            if (j==1) sb.append(':');
        }
        return sb.toString();
    }

    public static Integer findBigger(List<Integer> list, int target){
        for (int i=0; i<list.size(); i++){
            if (list.get(i)>target){
                return list.get(i);
            }
        }
        return null;
    }

    public static List<Integer> ascendingNumbers(char[] numbers){
        Set<Integer> set = new HashSet<>();
        for (int i=0; i<numbers.length; i++){
            set.add(numbers[i]-'0');
        }
        Iterator<Integer> it = set.iterator();
        List<Integer> list = new ArrayList<>();
        while (it.hasNext()){
            list.add(it.next());
        }
        Collections.sort(list);
        return list;
    }

    public static boolean isValid(char[] timeArray, int index, int afterValue){
        int i=0;
        while (i<timeArray.length){
            int tens = (i==index? afterValue : (timeArray[i] - '0')) * 10;
            int digit = (i+1==index? afterValue : (timeArray[i] - '0'));
            //HH
            if (i==0 && tens+digit > MAXIMUM_HOURS){
                return false;
            }
            //MM
            if (i==2 && tens+digit > MAXIMUM_MINUTES){
                return false;
            }
            i+=2;
        }
        return true;
    }

    public static void main(String[] args) {

        String t1 = nextClosestTime("19:34");
        //expected 19:39
        System.out.println(t1);
        String t2 = nextClosestTime("23:59");
        //expected 22:22
        System.out.println(t2);
        String t3 = nextClosestTime("13:59");
        //expected 1559
        System.out.println(t3);


    }
}
