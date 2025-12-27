package elevator.button;

import elevator.enums.Direction;

public class HallButton extends Button {
    private Direction direction;
    public HallButton (Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return this.direction;
    }
    @Override
    public boolean isPressed() {
        return false;
    }
}
