package elevator.components;

import elevator.enums.DoorState;

public class Door {

    private DoorState state;
    public void open() {
        System.out.println("Open the elevator door");
        this.state = DoorState.OPEN;
    }
    public void close() {
        System.out.println("Close the elevator door");
        this.state = DoorState.CLOSED;
    }
    public boolean isOpen() {
        return this.state == DoorState.OPEN;
    }

    public DoorState getDoorState() {
        return this.state;
    }
}
