package elevator;

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

    public ElevatorSystem getInstance(Building building, ElevatorStrategy strategy) {
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

    }

    public ElevatorCar getNearestElevator(int floor) {
        return null;
    }

    public void dispatcher() {

    }


}
