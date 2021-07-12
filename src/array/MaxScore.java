package array;

public class MaxScore {

    //time complexity O(n)
    //space complexity O(1)
    public static int maxScore(int[] cardPoints, int k) {
        int left = 0, right = 0, maximun = 0, sub = 0;
        while ( left < cardPoints.length){
            int indexRight = right>=cardPoints.length? right-cardPoints.length : right;
            sub += cardPoints[indexRight];
            if ( right - left >= k ){
                sub -= cardPoints[left];
                left++;
                if (left==0 || right >= cardPoints.length-1){
                    maximun = Math.max(maximun, sub);
                }
            }

            right++;
        }
        return maximun;
    }

    public static void main(String[] args) {
        System.out.println(
                maxScore(
                        new int[]{1,2,3,4,5,6,1},
                        3
                )
        );
        System.out.println(
                maxScore(
                        new int[]{100,40,17,9,73,75},
                        3
                )
        );
    }

}
