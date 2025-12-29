package elevator;

import elevator.components.Building;
import elevator.components.ElevatorCar;
import elevator.enums.Direction;
import elevator.strategy.ElevatorStrategy;
import elevator.strategy.NearestElevatorStrategy;

public class ElevatorDemo {
    private static final int MAX_FLOORS = 10;
    public static void main(String[] args) {
        Building building = new Building();

        ElevatorCar car1 = new ElevatorCar(MAX_FLOORS);
        ElevatorCar car2 = new ElevatorCar(MAX_FLOORS);

        building.getElevatorCars().add(car1);
        building.getElevatorCars().add(car2);

        ElevatorStrategy strategy =
                new NearestElevatorStrategy(building.getElevatorCars());

        ElevatorSystem system = ElevatorSystem.getInstance(building,strategy);

        system.callElevator(5, Direction.UP);
        system.callElevator(2, Direction.DOWN);

        car1.addLoad(600);          // overload
        system.callElevator(8, Direction.UP);

        car1.removeLoad(200);
        system.callElevator(8, Direction.UP);

        car2.emergencyStop();
        system.callElevator(10, Direction.UP);

        car1.enterMaintenance();
        system.callElevator(3, Direction.DOWN);
    }
}
