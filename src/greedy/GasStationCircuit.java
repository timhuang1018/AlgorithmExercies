package greedy;

public class GasStationCircuit {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        //check if have answer
        int total = 0;
        for (int i=0; i < gas.length; i++){
            total = total + gas[i] - cost[i];
        }
        if (total<0){
            return -1;
        }

        int tank = 0;
        int start = 0;
        for (int i=0; i < gas.length; i++){
           tank = tank + gas[i] - cost[i];
           if (tank<0){
               start = i+1;
               tank = 0;
           }
        }
        return start;
    }

}
