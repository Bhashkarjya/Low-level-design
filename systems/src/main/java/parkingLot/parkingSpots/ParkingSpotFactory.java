package parkingLot.parkingSpots;

public class ParkingSpotFactory {
    public static ParkingSpot getParkingSpot(ParkingSpotType type, int id) {
        return switch(type) {
            case COMPACT -> new CompactParkingSpot(id);
            case LARGE -> new LargeParkingSpot(id);
            case MOTORCYCLE -> new MotorcycleParkingSpot(id);
        };
    }
}
