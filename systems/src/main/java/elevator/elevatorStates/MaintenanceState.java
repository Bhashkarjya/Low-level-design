package elevator.elevatorStates;

import elevator.components.ElevatorCar;

public class MaintenanceState implements ElevatorCarState {
    private final ElevatorCar car;
    public MaintenanceState(ElevatorCar car) {
        this.car = car;
    }

    @Override
    public void moveTo(int floor) {
        // ignored
    }

    @Override
    public void stop() {
        // ignored
    }

    @Override
    public void enterMaintenance() {
        // already in maintenance
    }

    @Override
    public void emergencyStop() {
        // ignored or logged
    }

    @Override
    public String getName() {
        return "MAINTENANCE";
    }
}
