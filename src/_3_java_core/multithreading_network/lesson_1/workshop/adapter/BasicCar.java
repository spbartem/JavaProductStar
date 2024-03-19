package _3_java_core.multithreading_network.lesson_1.workshop.adapter;

/**
 * Паттер Адаптер - структурный шаблон проектирования,
 * предназначенный для организации использования функций объекта, недоступного для модификации,
 * через специально созданный интерфейс
 *
 * Паттер адаптер предусматривает создание класса-оболочки с требуемым интерфейсом
 */

public interface BasicCar {
    void drive();
    void xenonOn();
    void xenonOff();
}

interface BasicCarRus {
    void drive();
    void basicLightOn();
    void basicLightOff();
}

class AudiA3 implements BasicCar {
    final public int light = 100;

    @Override
    public void drive() {
        System.out.println("AudiA3 rides!");
    }

    @Override
    public void xenonOn() {
        System.out.println("AudiA3 xenon on");
    }

    @Override
    public void xenonOff() {
        System.out.println("AudiA3 xenon off");
    }
}

class AudiA3Rus implements BasicCarRus {
    final public int light = 100;

    @Override
    public void drive() {
        System.out.println("AudiA3 поехал!");
    }

    @Override
    public void basicLightOn() {
        System.out.println("AudiA3 включили свет");
    }

    @Override
    public void basicLightOff() {
        System.out.println("AudiA3 выключили свет");
    }
}

class CarAdapter implements BasicCar {
    BasicCarRus basicCarRus;

    public CarAdapter(BasicCarRus basicCarRus) {
        this.basicCarRus = basicCarRus;
    }

    @Override
    public void drive() {
        basicCarRus.drive();
    }

    @Override
    public void xenonOn() {
        basicCarRus.basicLightOn();
    }

    @Override
    public void xenonOff() {
        basicCarRus.basicLightOff();
    }
}

class CentralProcessor {
    private BasicCar car;

    public CentralProcessor(BasicCar car) {
        this.car = car;
    }

    public void work() {
        car.drive();
        car.xenonOn();
        car.xenonOff();
    }
}

class Example {
    public static void main(String[] args) {
        //создаём объект машины
        BasicCar audiA3 = new AudiA3();
        //создаём объект процессора и передаём ему в управление объект машины
        CentralProcessor cp = new CentralProcessor(audiA3);
        //процессор управляет работой машины
        cp.work();

        //создаём адаптер и передаём в него машину
        CarAdapter audiA3Rus = new CarAdapter(new AudiA3Rus());
        //создаём процессор и передаём в него адаптер
        CentralProcessor cpRus = new CentralProcessor(audiA3Rus);
        //процессор управляет машиной
        cpRus.work();
    }
}
