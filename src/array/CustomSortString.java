package array;

/**
 * You are given two strings order and s.
 * All the words of order are unique and were sorted in some custom order previously.
 *
 * Permute the characters of s so that they match the order that order was sorted.
 * More specifically, if a character x occurs before a character y in order,
 * then x should occur before y in the permuted string.
 *
 * Return any permutation of s that satisfies this property.
 */
public class CustomSortString {

    //s might have duplicate letter, consider letter are 26 buckets, use bucket sort
    public static String customSortString(String order, String s) {
        int[] letters = new int[26];

        for(char c : s.toCharArray()){
            letters[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (char c : order.toCharArray()){
            while (letters[c-'a']-- >0){
                sb.append(c);
            }
        }

        for (int i=0; i<letters.length; i++){
            while (letters[i]-- >0){
                sb.append((char)( i+ 'a'));
            }
        }

        return sb.toString();
    }


    public static void main(String[] args) {
        String order = "kqep";
        String s = "pekeq";
        //expected "kqeep"
        System.out.println(customSortString(order, s));
    }
}
