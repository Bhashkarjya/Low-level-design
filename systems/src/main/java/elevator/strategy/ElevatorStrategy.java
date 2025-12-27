package elevator.strategy;

import elevator.ElevatorCar;
import elevator.enums.Direction;

public interface ElevatorStrategy {
    ElevatorCar assignElevatorCar(int destinationFloor, Direction direction);
}
