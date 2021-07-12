package array;

public class AddBinary {

    public static String addBinary(String a, String b) {
        if (a.length()==0) return b;
        if (b.length()==0) return a;
        String[] arr1 = a.split("");
        String[] arr2 = b.split("");
        String[] container = new String[arr1.length+arr2.length+1];
        int i = arr1.length-1, j = arr2.length-1, k = 0,carry = 0;
        while (i>=0 || j>=0){
            int sub = (i>=0? Integer.parseInt(arr1[i]) : 0)
                    + (j>=0? Integer.parseInt(arr2[j]) : 0)
                    + carry;
            carry = sub / 2;
            container[k] = String.valueOf(sub % 2);
            i--;
            j--;
            k++;
        }
        if (carry!=0){
            container[k] = String.valueOf(carry);
        }else {
            k--;
        }
        String result = "";
        for (;k>=0;k--){
            result += container[k];
        }
        return result;
    }

    public static void main(String[] args) {
        addBinary("1","11");
    }
}
