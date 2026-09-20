package kz.aitu.assignment2.factorymethod;

public class SeaLogistics extends Logistics {
    @Override
    protected Transport createTransport() {
        return new Ship();
    }
}