package array;

/**
 * Given two non-negative integers, num1 and num2 represented as string,
 * return the sum of num1 and num2 as a string.
 * You must solve the problem without using any built-in library for handling large integers (such as BigInteger). You must also not convert the inputs to integers directly.
 */
public class AddString {

    public static String addStrings(String num1, String num2) {
        int i = num1.length()-1, j = num2.length()-1, carry=0;
        String result = "";
        while (i>=0 || j >= 0){
            int charInt1 =  i>=0 ? Character.getNumericValue(num1.charAt(i)) : 0;
            int charInt2 =  j>=0 ? Character.getNumericValue(num2.charAt(j)) : 0;
            int sub = (charInt1 + charInt2 + carry);
            result = (sub % 10) + result ;
            carry = sub / 10;
            i--;
            j--;
        }
        if (carry!=0){
            result = carry + result;
        }
        return result;
    }

    public static void main(String[] args) {
        addStrings("11","123");
    }

}
