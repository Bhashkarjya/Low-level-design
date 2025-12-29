package elevator.strategy;

import elevator.components.ElevatorCar;
import elevator.enums.Direction;
import java.util.List;

public class NearestElevatorStrategy implements ElevatorStrategy{
    private final List<ElevatorCar> cars;
    public NearestElevatorStrategy(List<ElevatorCar> cars) {
        this.cars = cars;
    }
    @Override
    public ElevatorCar assignElevatorCar(int destinationFloor, Direction direction) {
        ElevatorCar best = null;
        int minDistance = Integer.MAX_VALUE;

        for(ElevatorCar car : this.cars) {
            int dist = Math.abs(car.getCurrentFloor() - destinationFloor);
            if( dist < minDistance) {
                minDistance = dist;
                best = car;
            }
        }

        return best;
    }
}
