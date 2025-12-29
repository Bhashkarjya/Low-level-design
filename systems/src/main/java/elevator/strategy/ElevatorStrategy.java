package elevator.strategy;

import elevator.components.ElevatorCar;
import elevator.enums.Direction;

public interface ElevatorStrategy {
    ElevatorCar assignElevatorCar(int destinationFloor, Direction direction);
}
