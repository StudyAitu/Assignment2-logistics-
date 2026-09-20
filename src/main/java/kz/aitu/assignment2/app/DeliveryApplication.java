package kz.aitu.assignment2.app;

import kz.aitu.assignment2.abstractfactory.Button;
import kz.aitu.assignment2.abstractfactory.Checkbox;
import kz.aitu.assignment2.abstractfactory.GUIFactory;
import kz.aitu.assignment2.factorymethod.Logistics;

public class DeliveryApplication {
    private final GUIFactory guiFactory;
    private final Logistics logistics;

    public DeliveryApplication(GUIFactory guiFactory, Logistics logistics) {
        this.guiFactory = guiFactory;
        this.logistics = logistics;
    }

    public void run(String cargo, String destination) {
        Button button = guiFactory.createButton();
        Checkbox checkbox = guiFactory.createCheckbox();

        button.paint();
        checkbox.paint();
        logistics.planDelivery(cargo, destination);
    }
}