package kz.aitu.assignment2.abstractfactory;

public class MacOSButton implements Button {
    @Override
    public void paint() {
        System.out.println("Rendering macOS button");
    }
}