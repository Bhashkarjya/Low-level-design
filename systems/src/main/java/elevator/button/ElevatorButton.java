package elevator.button;

public class ElevatorButton extends Button{
    private int floor;
    public ElevatorButton (int floor) {
        this.floor = floor;
    }

    public int getDestinationFloor() {
        return this.floor;
    }
    @Override
    public boolean isPressed() {
        return false;
    }

}
