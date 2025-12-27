package elevator.panels;

import elevator.button.HallButton;
import elevator.enums.Direction;

public class HallPanel {
    private HallButton upButton;
    private HallButton downButton;
    public HallPanel () {
        upButton = new HallButton(Direction.UP);
        downButton = new HallButton(Direction.DOWN);
    }

    public HallButton getUpButton() {
        return this.upButton;
    }

    public HallButton getDownButton() {
        return this.downButton;
    }
}
