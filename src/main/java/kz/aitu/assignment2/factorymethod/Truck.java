package kz.aitu.assignment2.factorymethod;

public class Truck implements Transport {
    @Override
    public void deliver(String cargo, String destination) {
        System.out.printf("Truck delivers %s to %s warehouse%n", cargo, destination);
    }
}