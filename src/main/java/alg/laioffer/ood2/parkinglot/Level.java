package alg.laioffer.ood2.parkinglot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by yuding on 2/10/18.
 */
public class Level {
    private final List<ParkingSpot> spots;
    Level(int numOfSpots) {
        List<ParkingSpot> list = new ArrayList<>(numOfSpots);
        int i = 0;
        // half Compact, half Large
        for(; i < numOfSpots / 2; i++) {
            list.add(new ParkingSpot(VehicleSize.Compact));
        }

        for(; i < numOfSpots; i++) {
            list.add(new ParkingSpot(VehicleSize.Large));
        }
        spots = Collections.unmodifiableList(list);
    }

    boolean hasSpot(Vehicle v) {
        for(ParkingSpot s: spots) {
            if(s.fit(v)) {
                return true;
            }
        }
        return false;
    }

    boolean park (Vehicle v) {
        for(ParkingSpot s: spots) {
            if(s.fit(v)) {
                s.park(v);
                return true;
            }
        }
        return false;
    }

    // the parkingLot only cares about spots
    // it doesn't matter which car actually leaves
    boolean leave (Vehicle v) {
        for(ParkingSpot s: spots) {
            if(s.getVehicle() == v) {
                s.leave();
                return true;
            }
        }
        return false;
    }
}
