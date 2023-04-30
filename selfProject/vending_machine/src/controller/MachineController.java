package controller;

import service.MachineService;

public class MachineController {

    private final MachineService machineService = new MachineService();
    public void run(){
        machineService.OnMachine();
        machineService.runningMachine();
        machineService.OffMachine();
    }
}
