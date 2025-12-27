package elevator;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.UUID;

import elevator.display.Display;
import elevator.enums.ElevatorState;
import elevator.panels.ElevatorPanel;

public class ElevatorCar {
    public static final int MAX_WEIGHT = 500;
    private int elevatorId;
    private int floor = 0;
    private ElevatorPanel elevatorPanel;
    private Display display;
    private ElevatorState status;
    private Door door;
    private int load = 0;
    private boolean overloaded = false;
    private boolean maintenance = false;
    private final Queue<Integer> requestQueue;

    public ElevatorCar() {
        this.door = new Door();
        this.requestQueue = new ArrayDeque<>();
        this.elevatorId = UUID.randomUUID().hashCode();
        this.elevatorPanel = new ElevatorPanel(10);
        this.display = new Display();
        this.status = ElevatorState.IDLE;
    }

    public int getCurrentFloor() {
        return this.floor;
    }

    public ElevatorPanel getElevatorPanel() {
        return this.elevatorPanel;
    }

    public ElevatorState getStatus() {
        return this.status;
    }

    public Display getDisplay() {
        return this.display;
    }

    public boolean isInMaintenance() {
        return this.maintenance;
    }

    public void enterMaintenance() {
        this.maintenance = true;
    }

    public void exitMaintenance() {
        this.maintenance = false;
    }

    public boolean isOverloaded() {
        return this.overloaded;
    }

    public void addLoad(int weight) {
        this.load += weight;
        if(this.load > MAX_WEIGHT) {
            this.overloaded = true;
        }
    }

    public void removeLoad(int weight) {
        this.load -= weight;
        if(this.overloaded && this.load <= MAX_WEIGHT) {
            this.overloaded = false;
        }
    }

    public void changeState(ElevatorState state) {
        this.status = state;
    }

    public void emergencyStop() {
        this.elevatorPanel.enterEmergency();
        changeState(ElevatorState.IDLE);
    }

    public void move() {

    }

    public void stop() {

    }

    public void registerRequest(int floor) {

    }


}
