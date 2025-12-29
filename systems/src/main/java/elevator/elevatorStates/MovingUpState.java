package elevator.elevatorStates;

import elevator.components.ElevatorCar;

public class MovingUpState implements ElevatorCarState{
    private final ElevatorCar car;
    public MovingUpState(ElevatorCar car) {
        this.car = car;
    }

    @Override
    public void moveTo(int floor) {
        // already moving, just queue
        car.registerRequest(floor);
    }

    @Override
    public void stop() {
        car.setState(car.getIdleState());
    }

    @Override
    public void enterMaintenance() {
        // cannot directly enter maintenance while moving
    }

    @Override
    public void emergencyStop() {
        car.forceStop();
        car.setState(car.getEmergencyState());
    }

    @Override
    public String getName() {
        return "MOVING_UP";
    }
}
