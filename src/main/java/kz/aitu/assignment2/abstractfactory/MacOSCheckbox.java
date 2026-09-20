package kz.aitu.assignment2.abstractfactory;

public class MacOSCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("Rendering macOS checkbox");
    }
}