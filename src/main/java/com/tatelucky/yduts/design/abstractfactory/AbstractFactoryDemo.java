package com.tatelucky.yduts.design.abstractfactory;

/**
 * @author tangsheng
 * @since 2019-11-28
 */
interface Computer {
    public void printComputer();
}


class MacComputer implements Computer {

    @Override
    public void printComputer() {
        System.out.println("mac computer");
    }
}

class WindowsComputer implements Computer {

    @Override
    public void printComputer() {
        System.out.println("windows computer");
    }
}

interface OperatingSystem {
    public void printSystem();
}

class MacSystem implements OperatingSystem {

    @Override
    public void printSystem() {
        System.out.println("mac system");
    }
}

class WindowsSystem implements OperatingSystem {

    @Override
    public void printSystem() {
        System.out.println("windows system");
    }
}

interface ProductFactory {
    public Computer createComputer();

    public OperatingSystem createSystem();
}

class MacFactory implements ProductFactory {

    @Override
    public Computer createComputer() {
        return new MacComputer();
    }

    @Override
    public OperatingSystem createSystem() {
        return new MacSystem();
    }
}


class WindowsFactory implements ProductFactory {

    @Override
    public Computer createComputer() {
        return new WindowsComputer();
    }

    @Override
    public OperatingSystem createSystem() {
        return new WindowsSystem();
    }
}

public class AbstractFactoryDemo {
    public static void main(String[] args) {
        ProductFactory productFactory = new MacFactory();
        Computer computer = productFactory.createComputer();
        OperatingSystem operatingSystem = productFactory.createSystem();
        computer.printComputer();
        operatingSystem.printSystem();
    }
}
