package elevator;

import elevator.enums.DoorState;

public class Door {

    private DoorState state;
    public void open() {}
    public void close() {}
    public boolean isOpen() {
        return false;
    }

    public DoorState getDoorState() {
        return this.state;
    }
}
