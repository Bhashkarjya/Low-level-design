package elevator.components;


import java.util.ArrayList;
import java.util.List;
public class Building {
    private List<Floor> floors;
    private List<ElevatorCar> elevatorCars;

    public Building() {
        this.floors = new ArrayList<>();
        this.elevatorCars = new ArrayList<>();
    }

    public List<Floor> getFloors() {
        return this.floors;
    }

    public List<ElevatorCar> getElevatorCars() {
        return this.elevatorCars;
    }
}
