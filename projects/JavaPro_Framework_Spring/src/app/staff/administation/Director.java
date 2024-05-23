package app.staff.administation;

import app.staff.specialists.Secretary;
import org.springframework.beans.factory.annotation.Autowired;

public class Director {
    @Autowired
    private Secretary secretary;
    @Autowired
    private ProductionChief productionChief;
    @Autowired
    private SalesChief salesChief;

    public void manageCompany() {
        secretary.work();
        productionChief.giveOrders();
        salesChief.giveOrders();
    }
 }
