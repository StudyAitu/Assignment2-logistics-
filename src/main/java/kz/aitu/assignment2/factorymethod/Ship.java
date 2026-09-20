package kz.aitu.assignment2.factorymethod;

public class Ship implements Transport {
    @Override
    public void deliver(String cargo, String destination) {
        System.out.printf("Ship delivers %s to %s warehouse%n", cargo, destination);
    }
}