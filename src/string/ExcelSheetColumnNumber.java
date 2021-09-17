package string;

/**
 * Given a string columnTitle that represents the column title as appear in an Excel sheet,
 * return its corresponding column number.
 *
 * For example:
 *
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 *
 *
 * Example 1:
 *
 * Input: columnTitle = "A"
 * Output: 1
 * Example 2:
 *
 * Input: columnTitle = "AB"
 * Output: 28
 *
 * 1 <= columnTitle.length <= 7
 * columnTitle consists only of uppercase English letters.
 * columnTitle is in the range ["A", "FXSHRXW"]
 */
public class ExcelSheetColumnNumber {
    // 'A' is 65 and 'Z' is 90 in ASCII
    // 'A' is 1 if represent column, each digit need to multiply 26
    public static int titleToNumbers(String columnTitle){
        int total = 0;
        int multiply = 1;

        for (int i= columnTitle.length()-1; i>=0; i--){
            int charValue = columnTitle.charAt(i) - 64; //64 or 'A'+1
            total += charValue * multiply ;
            multiply *= 26;
        }

        return total;
    }
}
