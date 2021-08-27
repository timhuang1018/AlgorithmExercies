package helper;

public class LinkedListGenerator {

    public static ListNode fromArray(int[] array){
        ListNode iterator = new ListNode(-1,null), dummy = iterator;
        for (int i=0; i<array.length; i++){
            iterator.next = new ListNode(array[i],null);
            iterator = iterator.next;
        }
        return dummy.next;
    }

    public static ListNode fromNodeString(String nodes){
        try{
            String[] rawArray = nodes.split("->");
            int[] array = new int[rawArray.length];
            for (int i=0; i<rawArray.length; i++){
                 array[i] = Integer.parseInt(rawArray[i]);
            }
            return fromArray(array);
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

}
