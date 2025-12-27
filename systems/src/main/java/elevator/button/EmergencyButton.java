package elevator.button;

public class EmergencyButton extends Button {
    @Override
    public boolean isPressed() {
        return false;
    }
    public void pressed() {
        this.pressed = true;
    }
}
