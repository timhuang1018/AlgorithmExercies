package array;

public class MinimumOperationsToMakeArrayAlternating {

    //find in odd index which number is the most frequency
    //find in even index which number is the most frequency
    //nums[0] != nums[1] need to consider
    //nums[0] == nums[1] then small frequency need to change (into smaller frequency ?)

    //[2,2,1,2,1]
    //[2,2,2,1] ->
    //[2,2,2,2,1,2]
    //[1,2,3,1,3]
    public int minimumOperations(int[] nums) {
        if(nums.length == 1) return 0;
        int counts = 0;
        int[] odd = new int[10];
        int[] even = new int[10];
        int oddMost = 0, oddValue = 0, evenMost = 0, evenValue = 0;

        for(int i = 0; i < nums.length; i+= 2){
            odd[nums[i]]++;
            if(odd[nums[i]] > oddMost){
                oddMost = odd[nums[i]];
                oddValue = nums[i];
            }
        }

        for(int i = 1; i < nums.length; i+= 2){
            even[nums[i]]++;
            if(even[nums[i]] > evenMost){
                evenMost = even[nums[i]];
                evenValue = nums[i];
            }
        }
        //5
        if(oddValue != evenValue){
            counts += ((nums.length / 2 + nums.length % 2) - oddMost) + (nums.length / 2 - evenMost);
        }else{
            if(oddMost > evenMost){
                int second = findSecondMost(even, evenValue);
                if(second == 0){
                    return ((nums.length / 2 + nums.length % 2) - oddMost) + evenMost;
                }else{
                    evenMost = second;
                }
            }else{
                int second = findSecondMost(odd, oddValue);
                if(second == 0){
                    return (nums.length / 2 - evenMost) + oddMost;
                }else{
                    oddMost = second;
                }

            }

            counts += ((nums.length / 2 + nums.length % 2) - oddMost) + (nums.length / 2 - evenMost);
        }
        return counts;
    }

    private int findSecondMost(int[] arr, int exceptValue){
        int sm = 0;
        for(int i = 0; i<arr.length; i++){
            if(i != exceptValue && arr[i] > sm){
                sm = arr[i];
            }
        }
        return sm;
    }

    public static void main(String[] args) {
        MinimumOperationsToMakeArrayAlternating m = new MinimumOperationsToMakeArrayAlternating();
        System.out.println(m.minimumOperations(new int[]{2,2}));
    }
}
