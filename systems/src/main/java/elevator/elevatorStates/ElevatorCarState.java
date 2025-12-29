package elevator.elevatorStates;

public interface ElevatorCarState {
    void moveTo(int floor);
    void stop();
    void enterMaintenance();
    void emergencyStop();
    String getName();
}
