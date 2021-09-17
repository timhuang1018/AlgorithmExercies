package helper;

public class DataLogger {

    public static void printLinkedList(ListNode head){
        System.out.print("linked list:");
        while (head!=null){
            System.out.print(head.val+"->");
            head = head.next;
        }
        System.out.println("end");
    }

    public static void printCharArray(char[] chars){
        System.out.print("[");
        for (int i=0; i<chars.length; i++){
            System.out.print(chars[i]);
            if (i!=chars.length-1) System.out.print(",");
            else System.out.print("]");
        }
    }

    public static void printIntArray(int[] chars){
        System.out.print("[");
        for (int i=0; i<chars.length; i++){
            System.out.print(chars[i]);
            if (i!=chars.length-1) System.out.print(",");
            else System.out.print("]");
        }
    }

    public static void print2DArray(int[][] chars){
        System.out.print("[");
        for (int j=0; j< chars.length; j++){
            System.out.print("[");
            for (int i=0; i<chars[0].length; i++){
                System.out.print(chars[j][i]);
                if (i!=chars.length-1) System.out.print(",");
                else System.out.print("]");
            }
        }
        System.out.print("]");
    }
}
