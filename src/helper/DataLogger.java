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
}
