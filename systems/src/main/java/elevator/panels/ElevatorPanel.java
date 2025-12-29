package elevator.panels;

import java.util.ArrayList;
import java.util.List;

import elevator.button.DoorButton;
import elevator.button.ElevatorButton;
import elevator.button.EmergencyButton;

public class ElevatorPanel {
    private List<ElevatorButton> floorButtons;
    private DoorButton openButton;
    private DoorButton closeButton;
    private EmergencyButton emergencyButton;
    //We will consider the floor numbers from 0 to floorCount
    public ElevatorPanel (int floorCount) {
        this.floorButtons = new ArrayList<>();
        for( int i=0;i<=floorCount;i++) {
            this.floorButtons.add(new ElevatorButton(i));
        }
        this.openButton = new DoorButton();
        this.closeButton = new DoorButton();
        this.emergencyButton = new EmergencyButton();
    }

    public List<ElevatorButton> getFloorButtons() {
        return this.floorButtons;
    }

    public DoorButton getDoorCloseButton() {
        return this.closeButton;
    }
    public DoorButton getDoorOpenButton() { return this.openButton; }

    public EmergencyButton getEmergencyButton() {
        return this.emergencyButton;
    }

    public void enterEmergency() {
        this.emergencyButton.pressed();
    }

    public void exitEmergency() {

    }
}
