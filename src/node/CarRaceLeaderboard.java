package node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * m cars are racing on a track with n checkpoints. (n >> m)
 * The checkpoints are sequential as checkpoint0, checkpoint1, checkpoint2 ... checkpoint(n-1).
 * Checkpoint0 is the starting line and checkpoint(n-1) is the destination.
 * Build a leaderboard class that implements 2 public functions:
 * 1. each time a car passes a checkpoint, a signal is sent to update the leaderboard:
 * 2. when user requests, return the ranking of all cars.
 */
public class CarRaceLeaderboard {

    Checkpoint[] checkpoints;

    public CarRaceLeaderboard(int cars, int checkpoints){
        this.checkpoints = new Checkpoint[checkpoints];
        initCars(cars);
    }

    //one car check means previous checkpoint exist
    //but new current check point might not
    public void checked(int carId, int checkpointId){
        if (checkpointId >= checkpoints.length){
            //throw exception, checkpointId over limit
            return;
        }
        //update previous checkpoint
        Checkpoint preCheckpoint = checkpoints[checkpointId - 1];
        if (preCheckpoint!=null){

            CarNode car = preCheckpoint.removeCar(carId);

            updatePrevious(preCheckpoint, checkpointId - 1);

            //update current checkpoint
            updateCurrent(car, checkpointId);
        }else {
            //throw exception, check point already finished
        }
    }

    //car's next and pre status might not be up to date now
    //but will be newest in updateCurrent
    private void updatePrevious(Checkpoint preCheckpoint, int preId) {
        if (preCheckpoint.isEmpty()){
            checkpoints[preId] = null;
        }
    }

    private void updateCurrent(CarNode car, int checkpointId) {

        if (checkpoints[checkpointId] == null){
            checkpoints[checkpointId] = new Checkpoint();
        }

        checkpoints[checkpointId].addCar(car);
    }

    public List<Integer> getRanking(){
        List<Integer> result = new ArrayList<>();

        for (int i = checkpoints.length - 1; i>=0; i--){
            if(checkpoints[i]!=null){
                result.addAll(checkpoints[i].ranking());
            }
        }

        return result;
    }

    //init cars from starting line, from id 1 to m
    private void initCars(int cars){
        this.checkpoints[0] = new Checkpoint();
        int carId = 1;

        while (carId <= cars){
            CarNode newCar = new CarNode();
            newCar.val = carId;
            this.checkpoints[0].addCar(newCar);
            carId++;
        }
    }

    static class Checkpoint{
        //Doubly ListNode val as car id
        private final CarNode headCar;
        private final CarNode tailCar;
        //car id, car
        public HashMap<Integer, CarNode> map;

        public Checkpoint(){
            map = new HashMap<>();
            headCar = new CarNode();
            tailCar = new CarNode();
            headCar.next = tailCar;
            tailCar.pre = headCar;
        }

        public CarNode removeCar(Integer carId){
            CarNode car = map.get(carId);
            if (car!=null){
                car.pre.next = car.next;
                car.next.pre = car.pre;
            }
            return car;
        }

        //always add before tail
        public void addCar(CarNode car){
            map.put(car.val, car);

            tailCar.pre.next = car;
            car.pre = tailCar.pre;
            car.next = tailCar;
            tailCar.pre = car;
        }

        public boolean isEmpty() {
            return map.isEmpty();
        }

        public List<Integer> ranking() {
            List<Integer> ranks = new ArrayList<>();
            CarNode visitor = headCar.next;
            while (visitor != tailCar){
                ranks.add(visitor.val);
                visitor = visitor.next;
            }
            return ranks;
        }
    }

    public static class CarNode {
        public int val;
        public CarNode next;
        public CarNode pre;
    }

    public static void main(String[] args) {
        CarRaceLeaderboard board = new CarRaceLeaderboard(4,4);
        board.checked(1,1);
        board.checked(2,1);
        board.checked(3,1);
        //expected 1,2,3,4
        System.out.println(board.getRanking());
        board.checked(3,2);
        board.checked(2,2);
        System.out.println(board.getRanking());
        board.checked(2,3);
        //expected 2,3,1,4
        System.out.println(board.getRanking());
    }
}
