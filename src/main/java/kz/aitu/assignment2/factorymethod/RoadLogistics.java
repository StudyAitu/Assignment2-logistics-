package kz.aitu.assignment2.factorymethod;

public class RoadLogistics extends Logistics {
    @Override
    protected Transport createTransport() {
        return new Truck();
    }
}