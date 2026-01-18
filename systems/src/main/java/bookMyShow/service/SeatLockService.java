package bookMyShow.service;

import bookMyShow.entities.Seat;
import bookMyShow.entities.Show;
import bookMyShow.entities.Theatre;
import bookMyShow.enums.SeatStatus;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class SeatLockService {
    private static volatile SeatLockService instance;
    private static final long SEAT_LOCK_TTL_MILLIS = 5*60*1000;
    private static final long LOCK_WAIT_TIMEOUT_MILLIS = 2000;
    private SeatLockService() {}
    public static SeatLockService getInstance() {
        if(instance == null) {
            synchronized (SeatLockService.class) {
                if(instance == null) {
                    instance = new SeatLockService();
                }
            }
        }
        return instance;
    }
    public boolean lockSeats(Show show, List<Integer> seatIds) {
        //to prevent race conditions
        Collections.sort(seatIds);

        Map<Integer, Seat> seatMap = show.getSeatStatusMap();

        try{
            //try to acquire locks for all the seats
            for(int i=0;i<seatIds.size();i++) {
                Seat seat = seatMap.get(seatIds.get(i));
                boolean acquired = seat.getLock().tryLock(LOCK_WAIT_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS);
                if(!acquired) {
                    unlockAcquired(seatMap, seatIds, i);
                    return false;
                }
            }

            //validate the availability of the seats
            for(int i=0;i<seatIds.size();i++) {
                Seat seat = seatMap.get(seatIds.get(i));
                if(seat.getSeatStatus() == SeatStatus.BOOKED || seat.isLocked()) {
                    unlockSeats(show, seatIds);
                    return false;
                }
            }

            //Apply TTL Lock
            for(int i=0;i<seatIds.size();i++) {
                Seat seat = seatMap.get(seatIds.get(i));
                seat.lockWithTTL(SEAT_LOCK_TTL_MILLIS);
            }
        } catch(InterruptedException e) {
            Thread.currentThread().interrupt();
            unlockSeats(show, seatIds);
            return false;
        }

        return true;
    }

    public void unlockSeats(Show show, List<Integer> seatIds) {
        Map<Integer, Seat> seatMap = show.getSeatStatusMap();

        for(int i=0;i<seatIds.size();i++) {
            seatMap.get(seatIds.get(i)).getLock().unlock();
        }
    }

    private void unlockAcquired(Map<Integer, Seat> seatMap, List<Integer> seatIds, int upto) {
        for(int i=0;i<upto;i++) {
            seatMap.get(seatIds.get(i)).getLock().unlock();
        }
    }
}
