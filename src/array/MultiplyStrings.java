package array;

/**
 * Given two non-negative integers num1 and num2 represented as strings,
 * return the product of num1 and num2, also represented as a string.
 * Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class MultiplyStrings {

    public static String multiply(String num1, String num2) {
        int[] result = new int[num1.length()+num2.length()];
        for (int i = num1.length()-1;i>=0;i--){
            int multiplier = Character.getNumericValue(num1.charAt(i));
            for (int j = num2.length()-1;j>=0;j--){
                int sub = multiplier * Character.getNumericValue(num2.charAt(j)) + result[i + j + 1];
                result[i + j] += sub / 10;
                result[i + j + 1] = sub % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int x: result){
            if (!(sb.length()==0 && x==0)) sb.append(x);
        }
        return sb.length()==0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
//        String t1 = multiply(
//                "123456789",
//                "987654321"
//        );
//        System.out.println(t1);
        String t2 = multiply(
                "123",
                "456"
        );
        System.out.println(t2);
//        multiply(
//                "6913259244",
//                "71103343"
//        );
//        multiply(
//                "498828660196",
//                "840477629533"
//        );
//        char c = (char)(2+'0');
//        System.out.println(c);
    }
}
