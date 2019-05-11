package alg.laioffer.ood2.parkinglot;

/**
 * Created by yuding on 2/10/18.
 */
public class ParkingSpot {
    private final VehicleSize size;
    private Vehicle currentVehicle;

    ParkingSpot(VehicleSize size) {
        this.size = size;
    }

    boolean fit (Vehicle v) {
        return currentVehicle == null && size.getSize() >= v.getSize().getSize();
    }

    /**
     * Record a vehicel is parked in by updating the currentVehicle field
     */

    void park (Vehicle v) {
        currentVehicle = v;
    }

    void leave() {
        currentVehicle = null;
    }

    Vehicle getVehicle() {
        return currentVehicle;
    }
}
