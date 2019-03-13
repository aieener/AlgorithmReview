package OOD_JRI_VendingMachine;

public class VendingMachineFactory {
    public static VendingMachine createVendingMachine() {
        return new VendingMachineImpl() ;
    }
}
