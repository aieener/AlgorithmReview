package alg.laioffer.ood.vendingMVC.controller;

import alg.laioffer.ood.vendingMVC.service.VendingMachineService;
import alg.laioffer.ood.vendingmachine.VendingMachine;

public class VendingMachineController {
    VendingMachineService service;

    public VendingMachineController(VendingMachineService service) {
        this.service = service;
    }

    // public apis here
}
