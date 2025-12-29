package elevator.elevatorStates;

import elevator.components.ElevatorCar;

public class EmergencyState implements ElevatorCarState {
    private final ElevatorCar car;
    public EmergencyState(ElevatorCar car) {
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
        // ignored
    }

    @Override
    public void emergencyStop() {
        // already stopped
    }

    @Override
    public String getName() {
        return "EMERGENCY";
    }
}
