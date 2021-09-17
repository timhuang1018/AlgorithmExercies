package array;

/**
 * The two-pointer template not only works on a single array,
 * but also could manage pointers on two arrays at the same time.
 *
 * Help Amazon pick a route for its drone delivery.
 * The drone takes off on a forward shipping route and gets back by a return shipping route.
 * The drone has a maximum operating distance limit on each delivery.
 * Your duty is to select one forward shipping route and one return shipping route that add up (equal) to maximum total distance.
 * Return the indices of the selected routes
 *
 * input
 * forwardRoutes = [2000, 6000, 8000, 12000, 14000]
 * returnRoutes  = [5000, 7500, 8000, 10000, 20000, 22000]
 * maximumOperatingDistance = 20000
 * AOneCode.com
 * output
 * [3, 2]
 */
public class FindIndicesOfRoutes {
    public static void main(String[] args) {
        int[] forwardRoutes = new int[]{2000, 6000, 8000, 12000, 14000};
        int[] returnRoutes  = new int[]{5000, 7500, 8000, 10000, 20000, 22000};

    }

    public static int[] findIndicesOfRoutes(int[] forwardRoutes, int[] returnRoutes, int maximum){
        int point1 = 0, point2 = returnRoutes.length - 1;

        while (point1 < forwardRoutes.length-1 && point2>=0){
            if (forwardRoutes[point1] + returnRoutes[point2]== maximum){
                return new int[]{point1, point2};
            }else if(forwardRoutes[point1] + returnRoutes[point2] > maximum){
                point2--;
            }else{
                point1++;
            }
        }

        return null;
    }
}
