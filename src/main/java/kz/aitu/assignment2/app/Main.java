package kz.aitu.assignment2.app;

import kz.aitu.assignment2.abstractfactory.GUIFactory;
import kz.aitu.assignment2.abstractfactory.MacOSFactory;
import kz.aitu.assignment2.abstractfactory.WindowsFactory;
import kz.aitu.assignment2.factorymethod.Logistics;
import kz.aitu.assignment2.factorymethod.RoadLogistics;
import kz.aitu.assignment2.factorymethod.SeaLogistics;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Logistics Application ===");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Delivery mode (ROAD/SEA): ");
        String deliveryInput = scanner.nextLine().trim().toUpperCase();
        if (deliveryInput.isEmpty()) {
            System.out.println("Missing input. Application stopped.");
            return;
        }

        System.out.print("UI platform (WINDOWS/MACOS): ");
        String uiInput = scanner.nextLine().trim().toUpperCase();
        if (uiInput.isEmpty()) {
            System.out.println("Missing input. Application stopped.");
            return;
        }

        Logistics logistics = configureLogistics(deliveryInput);
        if (logistics == null) {
            System.out.println("Unsupported delivery mode: " + deliveryInput);
            return;
        }

        GUIFactory factory = configureGUIFactory(uiInput);
        if (factory == null) {
            System.out.println("Unsupported UI platform: " + uiInput);
            return;
        }

        System.out.println("Delivery mode: " + deliveryInput);
        System.out.println("UI platform: " + uiInput);

        DeliveryApplication app = new DeliveryApplication(factory, logistics);
        app.run("laboratory equipment", "Aktau");
    }

    private static Logistics configureLogistics(String mode) {
        return switch (mode) {
            case "ROAD" -> new RoadLogistics();
            case "SEA" -> new SeaLogistics();
            default -> null;
        };
    }

    private static GUIFactory configureGUIFactory(String platform) {
        return switch (platform) {
            case "WINDOWS" -> new WindowsFactory();
            case "MACOS" -> new MacOSFactory();
            default -> null;
        };
    }
}