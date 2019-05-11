package alg.laioffer.ood2.parkinglot;

/**
 * Created by yuding on 2/10/18.
 */
public enum VehicleSize {
    Compact(1), Large(2); // enum ordinal

    private final int size;
    VehicleSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
