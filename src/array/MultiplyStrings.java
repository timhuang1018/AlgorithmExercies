package array;

/**
 * Given two non-negative integers num1 and num2 represented as strings,
 * return the product of num1 and num2, also represented as a string.
 * Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class MultiplyStrings {
    //TODO not solved yet, have overflow problem
    public static String multiply(String num1, String num2) {
        long digits = 1;
        long result = 0;
        System.out.println(Long.MAX_VALUE);
        for (int i = num1.length()-1;i>=0;i--){
            long multiplier = Character.getNumericValue(num1.charAt(i)) * digits;
            System.out.println("multiplier:"+multiplier + " head:"+Character.getNumericValue(num1.charAt(i)));
            int innerDigit = 1;
            for (int j = num2.length()-1;j>=0;j--){
                long sub = multiplier * Character.getNumericValue(num2.charAt(j)) * innerDigit;
                innerDigit *= 10;
                result += sub;
                System.out.println("i:"+i+" j:"+j+" sub:"+sub+" result:" +result);
            }
            digits *= 10;
        }
        return String.valueOf(result);
    }

    public static void main(String[] args) {
        multiply(
                "123456789",
                "987654321"
        );
        multiply(
                "6913259244",
                "71103343"
        );
        multiply(
                "498828660196",
                "840477629533"
        );
    }
}
