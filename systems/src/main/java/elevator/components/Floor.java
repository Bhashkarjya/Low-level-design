package elevator.components;

import java.util.ArrayList;
import java.util.List;

import elevator.display.Display;
import elevator.enums.Direction;
import elevator.panels.HallPanel;

public class Floor {
    private int floorNumber;
    private List<HallPanel> hallPanels;

    private Display display;

    public Floor(int floorNumber, int numPanels) {
        this.floorNumber = floorNumber;
        this.hallPanels = new ArrayList<>();
        for(int i=0;i<numPanels;i++) {
            this.hallPanels.add(new HallPanel());
        }
    }

    public int getFloorNumber() { return this.floorNumber; }
    public List<HallPanel> getHallPanels() { return this.hallPanels; }
    public HallPanel getPanel(int index) { return this.hallPanels.get(index); }
    public Display display() { return this.display; }

}
