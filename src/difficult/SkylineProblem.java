package difficult;

import java.util.*;

public class SkylineProblem {



    public static List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> cps = new ArrayList<>();
        //first pass find all critical points
        for(int[] building : buildings){
            cps.add(new int[]{building[0], building[2]});
            cps.add(new int[]{building[1], 0});
        }
        Collections.sort(cps, (o1, o2) -> o1[0] - o2[0]);
        for(int i=0; i< cps.size(); i++){
            for (int[] building : buildings){
//                if(cps.get(i)[1]> 0 && cps.get(i)[1]<= building[2] ){
//                    continue;
//                }
                int x = cps.get(i)[0];
                if (x >= building[0] && x < building[1]){
                    cps.get(i)[1] = Math.max(building[2], cps.get(i)[1]);
                }
            }
        }


        List<List<Integer>> result = new ArrayList<>();
        for (int j=0; j < cps.size(); j++){
            result.add(Arrays.asList(cps.get(j)[0],cps.get(j)[1]));
            while (j < cps.size()-1 && cps.get(j)[1] == cps.get(j+1)[1] ){
                j++;
            }
        }

        return result;
    }


    public static List<List<Integer>> getSkyline2(int[][] buildings) {
        List<int[]> cps = new ArrayList<>();
        //first pass find all critical points
        for(int[] building : buildings){
            cps.add(new int[]{building[0], building[2]});
            cps.add(new int[]{building[1], 0});
        }
        Collections.sort(cps, (o1, o2) -> o1[0] - o2[0]);
        for (int[] building : buildings){
            for(int i=0; i< cps.size(); i++){
                int x = cps.get(i)[0];
                if (x >= building[0] && x < building[1]){
                    cps.get(i)[1] = Math.max(building[2], cps.get(i)[1]);
                }
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int j=0; j < cps.size(); j++){
            result.add(Arrays.asList(cps.get(j)[0],cps.get(j)[1]));
            while (j < cps.size()-1 && cps.get(j)[1] == cps.get(j+1)[1] ){
                j++;
            }
        }

        return result;
    }

    //line sweep
    //out of memory for [0,2147483647,2147483647]
    public static List<List<Integer>> getSkyline3(int[][] buildings) {
        //each height has attr height, and right bound (use 1 for is right bound, 0 is not)
        int[][] heights = new int[buildings.length][2];
        for(int[] building : buildings){
            for(int i=building[0] ; i<=building[1]; i++){
                if (i == building[1]){
                    //assign right bound
                    //bu if already have height, no need
                    if (heights[i][0]==0){
                        heights[i][1] = 1;
                        heights[i][0] = Math.max(heights[i][0], building[2]);
                    }
                }else if(heights[i][1]==0){
                    heights[i][0] = Math.max(heights[i][0], building[2]);
                }else{
                    //there has been a right bound, but new building haven't reach right bound
                    //check if old right bound doesn't matter anymore if is smaller
                    heights[i][1] = 0;
                    //override value by new building height
                    heights[i][0] = building[2];
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        //edge skyline need to be added
        if(heights[0][0]!=0){
            result.add(Arrays.asList(0,heights[0][0]));
        }
        int index =1;
        while(index < heights.length){
            //there is a right bound, add result and prevent next value being added
            if(heights[index][1]==1){
                result.add(Arrays.asList(index, 0));
                index++;
            }
            //height change will be added
            else if(heights[index][0] != heights[index-1][0]){
                result.add(Arrays.asList(index, heights[index][0]));
            }
            index++;
        }

        return result;
    }

    public static void main(String[] args) {

        //expected [[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]
        System.out.println(getSkyline(new int[][]{
                        new int[]{2,9,10},
                new int[]{3,7,15},
                new int[]{5,12,12},
                new int[]{15,20,10},
                new int[]{19,24,8}
                }
        ));

        //expected [[0,3],[5,0]]
//        System.out.println(getSkyline(new int[][]{
//                new int[]{0,2,3},
//                new int[]{2,5,3}
//        }));

//        System.out.println(
//                getSkyline(new int[][]{
//                        new int[]{0,2147483647,2147483647}
//                })
//        );

    }
}
