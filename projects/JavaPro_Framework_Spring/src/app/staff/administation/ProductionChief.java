package app.staff.administation;

import app.staff.specialists.production.MachineOperator;
import app.staff.specialists.production.Storekeeper;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductionChief {
    @Autowired
    private MachineOperator machineOperator;
    @Autowired
    private Storekeeper storekeeper;

    public void giveOrders() {
        machineOperator.work();
        storekeeper.work();
    }
}
