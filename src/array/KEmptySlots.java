package array;


/**
 * There is a garden with N slots.
 * In each slot, there is a flower.
 * The N flowers will bloom one by one in N days.
 * In each day, there will be exactly one flower blooming and it will be in the status of blooming since then.
 *
 * Given an array flowers consists of number from 1 to N.
 * Each number in the array represents the place where the flower will open in that day.
 *
 * For example, flowers[i] = x means that the unique flower that blooms at day i will be at position x,
 * where i and x will be in the range from 1 to N.
 *
 * Also given an integer k, you need to output in which day there exists two flowers in the status of blooming,
 * and also the number of flowers between them is k and these flowers are not blooming.
 *
 * If there are multiple answers, choose the smallest.
 * If there isn't such day, output -1.
 */
public class KEmptySlots {

    /**
     * @param flowers: the place where the flower will open in that day
     * @param k:  an integer
     * @return: in which day meet the requirements
     */
    public static int kEmptySlots(int[] flowers, int k) {
        int[] slotByDays = new int[flowers.length];

        for (int i=0; i< flowers.length; i++){
            //make it 0 ~ N-1
            slotByDays[flowers[i]-1] = i;
        }
        //elastic sliding window
        int left= 0, right= left + k +1;
        int minDay = Integer.MAX_VALUE;

        for (int i =1; right<slotByDays.length; i++){
            //between left and right should be bigger
            int bigger = Math.max(slotByDays[left],slotByDays[right]);
            if (i < right && slotByDays[i]> bigger){
                continue;
            }
            //check if has legit minDay
            if (i==right){
                minDay = Math.min(minDay, bigger+1);
            }
            //assign new left and right
            left = i;
            right = left + k + 1;
        }

        return minDay==Integer.MAX_VALUE? -1: minDay;
    }

    //original
    //inner while loop could be optimized
    public static int kEmptySlots2(int[] flowers, int k) {
        int[] slotByDays = new int[flowers.length];

        for (int i=0; i< flowers.length; i++){
            //make it 0 ~ N-1
            slotByDays[flowers[i]-1] = i;
        }
        int pos = 0;
        int minDay = Integer.MAX_VALUE;

        //find between k slots
        while (pos + k + 1 < slotByDays.length){
            int bigger = Math.max(slotByDays[pos], slotByDays[pos + k +1]);
            int j = pos+1;
            //if day is bigger than
            while (j < pos+k+1 && slotByDays[j]>bigger){
                j++;
            }
            if (j==pos+k+1){
                //bigger is N-1 , need to return +1
                minDay = Math.min(minDay, bigger+1);
            }
            pos++;
        }

        return minDay==Integer.MAX_VALUE? -1: minDay;
    }

    public static void main(String[] args) {
        int t1 = kEmptySlots(new int[]{1,2,3,4},1);
        //expected -1
        System.out.println(t1);

        int t2 = kEmptySlots(new int[]{6,5,8,9,7,1,10,2,3,4}, 2);
        //expected 8
        System.out.println(t2);

        int t3 = kEmptySlots(new int[]{3,9,2,8,1,6,10,5,4,7}, 1);
        //expected 6
        System.out.println(t3);
    }
}
