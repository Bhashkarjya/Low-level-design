package elevator.elevatorStates;

import elevator.components.ElevatorCar;

public class IdleState implements ElevatorCarState {
    private final ElevatorCar car;
    public IdleState(ElevatorCar car) {
        this.car = car;
    }

    @Override
    public void moveTo(int floor) {
        if (floor > car.getCurrentFloor()) {
            car.setState(car.getMovingUpState());
        } else if (floor < car.getCurrentFloor()) {
            car.setState(car.getMovingDownState());
        }
        car.startMoving(floor);
    }

    @Override
    public void stop() {
        // already idle
    }

    @Override
    public void enterMaintenance() {
        car.setState(car.getMaintenanceState());
    }

    @Override
    public void emergencyStop() {
        car.setState(car.getEmergencyState());
    }

    @Override
    public String getName() {
        return "IDLE";
    }
}
