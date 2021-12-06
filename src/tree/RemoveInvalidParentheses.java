package tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveInvalidParentheses {

//    public List<String> removeInvalidParentheses(String s) {
//        List<String> result = new ArrayList();
//        Set<String> set = new HashSet<>();
//
//        for(int i =0; i< s.length(); i++){
//            StringBuilder sb = new StringBuilder(s);
//            sb.deleteCharAt(i);
//
//            String caseString = sb.toString();
//            int balance = 0;
//            for(int j =0; j<caseString.length(); j++){
//                char c = caseString.charAt(j);
//                if(c == '('){
//                    balance++;
//                }else if(c == ')'){
//                    balance--;
//                    if(balance < 0){
//                        break;
//                    }
//                }
//            }
//
//            if(balance == 0 && !set.contains(caseString)){
//                result.add(caseString);
//                set.add(caseString);
//            }
//        }
//
//        return result;
//    }

    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList();
        Set<String> set = new HashSet<>();

        findSubsets(s, set, 0, 0);
        return result;
    }

    public void findSubsets(String text, Set<String> set, int index, int balance){

        System.out.println("text:"+text+",index:"+index+",balance:"+balance);
        if(index > text.length() -1){
            return;
        }

        if(index == text.length() -1 && balance == 0){
            set.add(text);
            return;
        }

        StringBuilder sb = new StringBuilder(text);
        //with or without the char at index
        sb.deleteCharAt(index);
        findSubsets(sb.toString(), set, index, balance);
        char c = text.charAt(index);
        if(c == '('){
            balance++;
        }else if(c == ')'){
            balance--;
        }
        findSubsets(sb.toString(), set, index + 1, balance);

    }


    public static void main(String[] args) {
        RemoveInvalidParentheses solution = new RemoveInvalidParentheses();

        System.out.println(solution.removeInvalidParentheses("()())()"));
    }
}
