package array;

import java.util.ArrayList;
import java.util.List;

public class CamelMatch {

    //time complexity O(n2)
    //space complexity O(n)
    public static List<Boolean> camelMatch(String[] queries, String pattern) {
        int i = 0;
        List<Boolean> result = new ArrayList<>();
        for (;i<queries.length;i++){
            String query = queries[i];
            result.add(isMatch(query,pattern));
        }
        return result;
    }

    private static boolean isMatch(String query, String pattern) {
        int j = 0;
        for (int i=0;i<query.length();i++){

            if (j<pattern.length() && pattern.charAt(j)==query.charAt(i)){
                j++;
            }else if (Character.isUpperCase(query.charAt(i))){
                return false;
            }
        }
        return j==pattern.length();
    }
}
