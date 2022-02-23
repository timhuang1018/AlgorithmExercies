package string;

public class RepeatLimitString {

    public static String repeatLimitedString(String s, int repeatLimit) {

        int[] letters = new int[26];
        for(char c : s.toCharArray()){
            letters[c - 'a']++;
        }

        StringBuilder res = new StringBuilder();
        boolean overLimit = false;
        int i = 25;
        while(i >=0){
            boolean restart = false;
            int count = 0;
            while(letters[i] > 0){
                res.append((char)(i + 'a'));
                letters[i]--;
                count++;
                if(overLimit){
                    overLimit = false;
                    restart = true;
                    break;
                }
                if(letters[i] > 0 && count == repeatLimit){
                    overLimit = true;
                    break;
                }
            }
            if(restart){
                i = 25;
                continue;
            }
            i--;
        }

        return res.toString();
    }

    public static void main(String[] args) {
        String t1 = repeatLimitedString("yxxvvvuusrrqqppopponliihgfeeddcbba", 2);
        System.out.println(t1);
    }
}
