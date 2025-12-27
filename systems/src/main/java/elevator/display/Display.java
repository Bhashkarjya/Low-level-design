package elevator.display;

import elevator.enums.Direction;
import elevator.enums.ElevatorState;

//Display should show the currentLoad, floor, direction, elevatorStatus
public class Display {
    private int floor;
    private int load;
    private Direction direction;
    private ElevatorState status;
    public void updateDisplay(int floor, Direction d, boolean maintenance, boolean overloaded) {

    }
    public void showElevatorDisplay() {}
    public void showHallDisplay() {}
}
