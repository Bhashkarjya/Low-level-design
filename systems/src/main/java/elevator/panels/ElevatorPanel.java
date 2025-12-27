package elevator.panels;

import java.util.ArrayList;
import java.util.List;

import elevator.button.DoorButton;
import elevator.button.ElevatorButton;
import elevator.button.EmergencyButton;

public class ElevatorPanel {
    private List<ElevatorButton> floorButtons;
    private DoorButton doorButton;
    private EmergencyButton emergencyButton;
    //We will consider the floor numbers from 0 to floorCount
    public ElevatorPanel (int floorCount) {
        this.floorButtons = new ArrayList<>();
        for( int i=0;i<=floorCount;i++) {
            this.floorButtons.add(new ElevatorButton(i));
        }
        this.doorButton = new DoorButton();
        this.emergencyButton = new EmergencyButton();
    }

    public List<ElevatorButton> getFloorButtons() {
        return this.floorButtons;
    }

    public DoorButton getDoorButton() {
        return this.doorButton;
    }

    public EmergencyButton getEmergencyButton() {
        return this.emergencyButton;
    }

    public void enterEmergency() {
        this.emergencyButton.pressed();
    }

    public void exitEmergency() {

    }
}
