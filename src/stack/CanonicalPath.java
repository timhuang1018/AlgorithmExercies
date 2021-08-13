package stack;

import java.util.Stack;

public class CanonicalPath {

    //need to eliminate the unnecessary path
    //canonical start only from root directory to the target directory
    public static int pathConverter(char[] path){
        String canonical = "/";
        Stack<Character> stack = new Stack<>();
        stack.push('/');
        for (int i = 1; i<path.length; i++){
            char c = path[i];
            if (c=='/'){
                String cd = "";
                while (stack.peek()!='/'){
                    cd += stack.pop();
                }

                if (cd.isEmpty()){
                   //ignore
                }else if (cd.equals(".")){
                    //ignore
                }else if (cd.equals("..")){
                    //not only contain root dir
                    if (canonical.lastIndexOf('/')!=1){
                        int lenEnd = canonical.substring(0,canonical.length()-1).lastIndexOf('/');
                        canonical = canonical.substring(0,lenEnd+1);
                    }
                }else {
                    canonical = canonical + cd + '/';
                }
            }else {
                stack.push(c);
            }
        }
        //not counting last '/'
        return canonical.length()-1;
    }

    public static void main(String[] args) {
        char[] t1 = new char[]{'/','.','/','d','i','r','/','.','.','/','f','o','o','/'};
        //expected 4
        System.out.println(pathConverter(t1));

        char[] t2 = new char[]{'/','a','/','/','b','/','.','.','/','.','.','/','c','/'};
        //expected 2
        System.out.println(pathConverter(t2));

        char[] t3 = "/a/b/./c/../d/../e/../../f/../../g/h/".toCharArray();
        //expected 4
        System.out.println(pathConverter(t3));
    }
}
