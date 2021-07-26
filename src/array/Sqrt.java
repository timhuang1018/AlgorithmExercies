package array;

public class Sqrt {

    public static int mySqrt(int x) {
        if(x==0) return x;
        int lo = 1, hi = x;
        while (true){
            int mid = lo + ( hi - lo )/2;
            System.out.println(mid);
            if (mid > x / mid){
                hi = mid -1;
            }else if (mid+1 > x / (mid+1)){
                return mid;
            }else {
                lo = mid +1;
            }
        }
    }

    public static void main(String[] args) {
        int t1 = mySqrt(8);
        //expected 2
        System.out.println(t1);
    }
}
