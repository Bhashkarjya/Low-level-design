package elevator.components;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.UUID;

import elevator.components.Door;
import elevator.display.Display;
import elevator.elevatorStates.ElevatorCarState;
import elevator.elevatorStates.EmergencyState;
import elevator.elevatorStates.IdleState;
import elevator.elevatorStates.MaintenanceState;
import elevator.elevatorStates.MovingDownState;
import elevator.elevatorStates.MovingUpState;
import elevator.panels.ElevatorPanel;

public class ElevatorCar {
    public static final int MAX_WEIGHT = 500;
    private final int elevatorId;
    private int currentFloor = 0;
    private final ElevatorPanel elevatorPanel;
    private final Display display;
    private ElevatorCarState currentState;
    private final ElevatorCarState idleState;
    private final ElevatorCarState movingUpState;
    private final ElevatorCarState movingDownState;
    private final ElevatorCarState maintenanceState;
    private final ElevatorCarState emergencyState;
    private final Door door;
    private int load = 0;
    private boolean overloaded = false;
    private final Queue<Integer> requestQueue;

    public ElevatorCar(int numFloors) {
        this.door = new Door();
        this.requestQueue = new ArrayDeque<>();
        this.elevatorId = UUID.randomUUID().hashCode();
        this.elevatorPanel = new ElevatorPanel(numFloors);
        this.display = new Display();
        this.idleState = new IdleState(this);
        this.movingUpState = new MovingUpState(this);
        this.movingDownState = new MovingDownState(this);
        this.maintenanceState = new MaintenanceState(this);
        this.emergencyState = new EmergencyState(this);
        this.currentState = this.idleState;
    }

    public int getCurrentFloor() {
        return this.currentFloor;
    }
    public ElevatorCarState getIdleState() { return this.idleState; }
    public ElevatorCarState getMovingUpState() { return this.movingUpState; }
    public ElevatorCarState getMovingDownState() { return this.movingDownState; }
    public ElevatorCarState getMaintenanceState() { return this.maintenanceState; }
    public ElevatorCarState getEmergencyState() { return this.emergencyState; }

    public ElevatorPanel getElevatorPanel() {
        return this.elevatorPanel;
    }

    public Display getDisplay() {
        return this.display;
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

    public void setState(ElevatorCarState state) {
        this.currentState = state;
    }


    public void registerRequest(int floor) {
        this.requestQueue.add(floor);
    }

    public void moveTo(int floor) {
        if(this.overloaded) {
            System.out.println("Elevator overloaded. Cannot move.");
            return;
        }
        this.currentState.moveTo(floor);
    }

    public void stop() {
        this.currentState.stop();
    }

    public void emergencyStop() {
        this.currentState.emergencyStop();
    }
    public void enterMaintenance() {
        System.out.println("Entering maintenance state");
        this.currentState.enterMaintenance();
    }

    public void startMoving(int floor) {
        System.out.println("Moving to floor");
        this.currentFloor = floor;
    }

    public void forceStop() {
        System.out.println("Emergency Stop");
    }


}
