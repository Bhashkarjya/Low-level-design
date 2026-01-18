package bookMyShow.entities;

import bookMyShow.enums.SeatStatus;
import bookMyShow.enums.SeatType;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Seat {
    private final int seatNumber;
    private final SeatType seatType;
    private SeatStatus seatStatus;
    private final ReentrantLock lock = new ReentrantLock();
    private long lockExpiryTimeInMillis;

    public Seat(int seatNumber, SeatType seatType) {
        this.seatNumber = seatNumber;
        this.seatType = seatType;
        this.seatStatus = SeatStatus.AVAILABLE;
    }

    public int getSeatNumber() { return this.seatNumber; }
    public SeatStatus getSeatStatus() { return this.seatStatus; }
    public SeatType getSeatType() { return this.seatType; }

    public ReentrantLock getLock() { return this.lock; }

    public boolean isLocked() {
        if(lockExpiryTimeInMillis == 0) {
            return false;
        }

        if(System.currentTimeMillis() > lockExpiryTimeInMillis) {
            //TTL expired - unlock
            lockExpiryTimeInMillis = 0;
            return false;
        }
        return true;
    }

    public void lockWithTTL(long timeInMillis) {
        lockExpiryTimeInMillis = System.currentTimeMillis() + timeInMillis;
    }

    public void book() {
        //Mark the ticket as booked and and clear out the expiry time
        this.seatStatus = SeatStatus.BOOKED;
        lockExpiryTimeInMillis = 0;
    }
}
