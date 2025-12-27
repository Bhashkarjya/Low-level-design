package elevator.button;

public class DoorButton extends Button {
    @Override
    public boolean isPressed() {
        return this.pressed;
    }
}
