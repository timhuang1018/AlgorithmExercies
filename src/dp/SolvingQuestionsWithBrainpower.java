package dp;

import java.util.PriorityQueue;

public class SolvingQuestionsWithBrainpower {

    public static long mostPoints(int[][] questions) {
        long max = 0l;
        int index=0;
        // long startTime = System.currentTimeMillis();

        long[] dp = new long[questions.length+1];

        while(index < questions.length){
            long temp = questions[index][0];
            int j = index + questions[index][1] + 1;
            max = Math.max(max, temp);
            System.out.println("before adding "+temp);
            if(j < questions.length && dp[j] > 0){
                index++;
                continue;
            }

            while(j < questions.length){

//                System.out.println("index:"+index+", j:"+j);

                int next = j + questions[j][1];
                int k = j + 1;
                while(k < next && next < questions.length){
                    if(questions[k][1] > questions[next][1]){
                        next = k;
                        break;
                    }
                    k++;
                }

                j = next;
                if(j>= questions.length) break;
                temp += questions[j][0];
                max = Math.max(max, temp);
                // if(j+questions[j][1] + 1 >= questions.length){
                //     dp[j] = temp;
                // }

            }


            index++;
        }
        // System.out.println(System.currentTimeMillis() - startTime);


        System.out.println(max);
        return max;
    }

    public static void main(String[] args) {
//        mostPoints(new int [][]{new int[]{3,2},new int[]{4,3},new int[]{4,4},new int[]{2,5}});
        //],[],[],[],[
//        mostPoints(new int [][]{new int[]{1,1},new int[]{2,2},new int[]{3,3},new int[]{4,4},new int[]{5,5}});
//        [[],[],[],[],[],[],[],[]]

        //expected 157

        mostPoints(new int [][]{new int[]{21,5},new int[]{92,3},
                new int[]{74,2},new int[]{39,4},
                new int[]{58,2},new int[]{5,5},
                new int[]{49,4},new int[]{65,3}
        });

    }
}
