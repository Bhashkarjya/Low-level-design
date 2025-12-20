package parkingLot.components;

import java.util.Map;
import java.util.List;
import parkingLot.parkingSpots.ParkingSpot;
import parkingLot.parkingSpots.ParkingSpotType;

public class DisplayBoard {
    private int id;
    //Map of a parkingSpot to the number of parkingSpots available for that particular type
    private Map<ParkingSpotType,Integer> parkingSpots;
    public DisplayBoard(int id) {
        this.id = id;
    }
    public void showOccupancy() {

    }
    public void onEntryUpdate(ParkingSpotType type) {
        parkingSpots.put(type, parkingSpots.getOrDefault(type, 0) + 1);
    }

    public void onExitUpdate(ParkingSpotType type) throws Exception{
        if(parkingSpots.get(type) == 0) {
            throw new Exception("Number of occupied parking spots for the particular parkingSpotType is already zero");
        }
        parkingSpots.put(type, parkingSpots.getOrDefault(type, 0) - 1);
    }

}
