package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeDecodeStrings {

    public static String encode(List<String> strings){
        String result = "";
        for (int i = 0; i<strings.size(); i++){
            result += strings.get(i).length() +":" + strings.get(i);
        }
        return result;
    }

    public static List<String> decode(String text){
        int index = 0;
        List<String> result = new ArrayList<>();

        while (index<text.length()){
            int found = text.indexOf(":",index);
            int length = Integer.parseInt(text.substring(index,found));
            result.add(text.substring(found+1,found + length + 1));
            index = found + length + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> t1 = Arrays.asList(":2tssssk:31:","cp3");
        System.out.println(
                decode(encode(t1))
        );

        List<String> t2 = Arrays.asList(":2:",":1:");
        System.out.println(
                decode(encode(t2))
        );
    }
}
