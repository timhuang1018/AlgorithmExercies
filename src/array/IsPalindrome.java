package array;

public class IsPalindrome {
    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        if(chars.length<=1){
            return true;
        }
        int i = 0;
        int j = chars.length -1;
        while (i<=j){
            if (Character.isLetterOrDigit(chars[i]) && Character.isLetterOrDigit(chars[j])){
                if (Character.toLowerCase(chars[i])!=Character.toLowerCase(chars[j])){
                    return false;
                }
                i++;
                j--;
            }else if (!Character.isLetterOrDigit(chars[i])){
                i++;
            }else {
                j--;
            }
        }
        return true;
    }
}
