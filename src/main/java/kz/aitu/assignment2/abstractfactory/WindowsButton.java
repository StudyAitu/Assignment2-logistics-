package kz.aitu.assignment2.abstractfactory;

public class WindowsButton implements Button {
    @Override
    public void paint() {
        System.out.println("Rendering Windows button");
    }
}