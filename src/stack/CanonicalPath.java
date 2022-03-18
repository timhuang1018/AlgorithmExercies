package stack;

import java.util.Stack;

/**
 * return an integer which is the length of the canonical path.
 */
public class CanonicalPath {

    //need to eliminate the unnecessary path
    //canonical start only from root directory to the target directory
    public static int pathConverter(char[] path){
        String canonical = "/";
        Stack<Character> stack = new Stack<>();
        stack.push('/');
        // //ss/../
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
                    if (canonical.lastIndexOf('/')>0){
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
        //not counting last '/' but if only one '/'
        return canonical.length()>1 ? canonical.length()-1 : 1;
    }


    //using two pointer instead of stack
    public static int pathConverter2(char[] path){
        if (path.length<=1) return path.length;
        int head = 0, tail = 0;
        String segment = "";

        while (tail<path.length){
            if (path[tail]=='/'){

                if (segment.equals(".")){
                    //ignore
                }else if (segment.equals("..")){
                    //not only contain root dir
                    if (head!=0){
                        while (head>0){
                            head--;
                            if (path[head]=='/') break;
                        }
                    }

                }else if (segment.isEmpty()){
                    //ignore
                }else {
                    //have to count '/' in
                    head += segment.length() + 1;
                }

                segment = "";
            }else {
                segment += path[tail];
                path[head + segment.length()] = path[tail];
            }
            tail++;
        }
        //not consider last '/' but if only one '/'
        return head>0 ? head : 1;
    }

    public static void main(String[] args) {
        char[] t1 = new char[]{'/','.','/','d','i','r','/','.','.','/','f','o','o','/'};
        //expected 4
        System.out.println(pathConverter2(t1));

        char[] t2 = new char[]{'/','a','/','/','b','/','.','.','/','.','.','/','c','/'};
        //expected 2
        System.out.println(pathConverter2(t2));

        char[] t3 = "/a/b/./c/../d/../e/../../f/../../g/h/".toCharArray();
        //expected 4
        System.out.println(pathConverter2(t3));

        char[] t4 = "/../dir/..//..//.././////".toCharArray();
        //expected 1
        System.out.println(pathConverter(t4));
    }
}
