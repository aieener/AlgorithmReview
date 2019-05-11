package alg.laioffer.ood2.parkinglot;

/**
 * Created by yuding on 2/10/18.
 */
public class Car extends Vehicle {
    @Override
    public VehicleSize getSize() {
        return VehicleSize.Compact;
    }
}
