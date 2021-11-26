package array;

public class MedianOfTwoSortedArray {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        boolean isEven = total % 2 == 0;
        int p1 = 0, p2 = 0;

        int[] comb = new int[total];
        while(p1 < nums1.length || p2 < nums2.length){
            int n1 = p1<nums1.length ? nums1[p1] : Integer.MAX_VALUE;
            int n2 = p2<nums2.length ? nums2[p2] : Integer.MAX_VALUE;
            System.out.println("p1:"+p1+",p2:"+p2);
            if(n1 < n2){
                comb[p1+p2] = nums1[p1];
                p1++;
            }else{
                comb[p1+p2] = nums2[p2];
                p2++;
            }
        }

        double mid = 0.0;
        if(isEven){
            int two = (comb[(total/2) - 1] + comb[(total/2)]);
            mid = two / 2.0;
        }else{
            mid = comb[(total/2)];
        }

        return mid;
    }

    public static void main(String[] args) {
//        System.out.println(findMedianSortedArrays(new int[]{1,3}, new int[]{2}));;
        System.out.println(findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}));;
    }
}
