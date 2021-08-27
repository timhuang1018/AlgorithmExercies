package helper;

public class ArrayGenerator {

    public static char[] fromStringArray(String[] array){
            char[] chars = new char[array.length];
            for (int i=0; i<array.length; i++){
                chars[i] = array[i].charAt(0);
            }

            return chars;
    }
}
