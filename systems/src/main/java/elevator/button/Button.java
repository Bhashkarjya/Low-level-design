package elevator.button;

public abstract class Button {
    protected boolean pressed;
    public void pressDown() {}
    public void rest() {}
    public abstract boolean isPressed();
}
