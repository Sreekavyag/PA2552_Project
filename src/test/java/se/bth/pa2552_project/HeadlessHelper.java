package se.bth.pa2552_project;

public class HeadlessHelper {
    public static void setupForHeadlessTesting() {
        String isRunningOnCi = System.getProperty("CI");
        if ("true".equalsIgnoreCase(isRunningOnCi)) {
            System.setProperty("monocle.platform", "Headless");
            System.setProperty("testfx.robot", "glass");
            System.setProperty("glass.platform", "Monocle");
            System.setProperty("embedded", "monocle");
            System.setProperty("testfx.headless", "true");
            System.setProperty("prism.order", "sw");

            // System.setProperty("prism.text", "t2k");
            System.setProperty("prism.text", "native");

            System.setProperty("java.awt.headless", "true");
        }
    }
}