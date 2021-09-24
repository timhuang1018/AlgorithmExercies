package string;


/**
 * Given a string s, return the longest palindromic substring in s.
 * Example 1:
 *
 * Input: s = "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: s = "cbbd"
 * Output: "bb"
 * Example 3:
 *
 * Input: s = "a"
 * Output: "a"
 * Example 4:
 *
 * Input: s = "ac"
 * Output: "a"
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters.
 */
public class LongestPalindromicSubstring {

    int maxLen = 0;
    int start = 0;

    // O(n*n) time complexity
    //possible middle point is K for odd length
    //K - 1 for even length
    public String longestPalindrome(String s){
        if (s.length() < 2) return s;

        for (int i = 0; i<s.length(); i++){
            expandPalindrome(s, i, i); //odd length palindrome
            expandPalindrome(s, i - 1, i); //even length palindrome
        }
        System.out.println("start:"+start +",maxLen:"+maxLen);
        return s.substring(start, start+maxLen);
    }

    //use helper method, given middle point
    // find the longest palindrome start from middle
    // middle - i and middle + i for odd length
    // middle - i and middle for even length
    private void expandPalindrome(String s, int left, int right){
        while (left >=0 && right< s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        System.out.println("right:"+right +",left:"+left);
        if ((right - left) - 2 + 1 > maxLen){
            // - 2 because last expand not valid, + 1
            // + 1 because substring end is exclusive, need to add it back
            maxLen = right - left - 2 + 1;
            start = left + 1;
        }
    }

    public static void main(String[] args) {
//        LongestPalindromicSubstring solution = new LongestPalindromicSubstring();
//        String t1 = solution.longestPalindrome("babad");
//        //expected bab or aba
//        System.out.println(t1);
//
//        LongestPalindromicSubstring solution2 = new LongestPalindromicSubstring();
//        String t2 = solution2.longestPalindrome("cbbd");
//        //expected bb
//        System.out.println(t2);
//
        LongestPalindromicSubstring solution3 = new LongestPalindromicSubstring();
        String t3 = solution3.longestPalindrome("ac");
        //expected a
        System.out.println(t3);

        LongestPalindromicSubstring solution4 = new LongestPalindromicSubstring();
        String t4 = solution4.longestPalindrome("bb");
        //expected a
        System.out.println(t4);
    }


}
