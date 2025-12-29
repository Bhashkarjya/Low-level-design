package elevator.display;

import elevator.elevatorStates.ElevatorCarState;
import elevator.enums.Direction;

//Display should show the currentLoad, floor, direction, elevatorStatus
public class Display {
    private int floor;
    private int load;
    private Direction direction;
    private ElevatorCarState state;
    public void updateDisplay(int floor, Direction d, boolean maintenance, boolean overloaded) {

    }
    public void showElevatorDisplay() {}
    public void showHallDisplay() {}
}
