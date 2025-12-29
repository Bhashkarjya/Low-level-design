package elevator;

import elevator.components.Building;
import elevator.components.ElevatorCar;
import elevator.enums.Direction;
import elevator.strategy.ElevatorStrategy;

public class ElevatorSystem {
    private static ElevatorSystem instance;
    private ElevatorStrategy strategy;
    private Building building;
    private ElevatorSystem(Building building, ElevatorStrategy strategy) {
        this.building = building;
        this.strategy = strategy;
    }

    public static ElevatorSystem getInstance(Building building, ElevatorStrategy strategy) {
        if (instance == null) {
            synchronized (ElevatorSystem.class) {
                if(instance == null) {
                    instance = new ElevatorSystem(building, strategy);
                }
            }
        }
        return instance;
    }

    public Building getBuilding() {
        return this.building;
    }

    public void callElevator(int floorNumber, Direction direction) {
        ElevatorCar car = this.strategy.assignElevatorCar(floorNumber, direction);
        if( car != null) {
            car.moveTo(floorNumber);
        }
    }
}
