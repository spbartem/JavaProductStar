package _3_java_core.collection.lesson_8.workshop;

public class Main {
    /* параметризация класса
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car());

        Wrapper<Car> carWrapper = new Wrapper(400000, new Car());
        Car newCar = carWrapper.getObject();
    }

    public static void driveAndAdjustPrice(Wrapper<Car> wrapper) {
        wrapper.getObject().drive();
        wrapper.setPrice(wrapper.getPrice() + 10000);
    }
    */

    /*параметризация метода через тип
    public static void main(String[] args) {
        List<String> stringList = spawnList();
        List<Integer> intList = spawnList();
    }

    public static <C> List<C> spawnList() {
        return new ArrayList<>();
    }
    */

    /*параметризация метода через параметр
    public static void main(String[] args) {
        String str = "Some String";
        str = validate(str);

        Integer integer = validate(0);
    }

    public static <C> C validate(C object ) {
        if (object == null) {
            throw new RuntimeException("Object is null");
        }
        return object;
    }
    */

    /*множественная параметризация классов
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        ObjectSpawner<String, ArrayList> os = new ObjectSpawner<>(String.class, ArrayList.class);
        String newString = os.createC();
        ArrayList newList = os.createT();

        ObjectSpawner<Object, HashSet> os2 = new ObjectSpawner<>(Object.class, HashSet.class);
        Object obj = os2.createC();
        HashSet set = os2.createT();
    }
    */

    /* о параметрах и типах
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Student student = new Student();
        Docent docent = new Docent();

        Processor<Student> studentProcessor = new Processor<>(student);
        Processor<Docent> docentProcessor = new Processor<>(docent);

        studentProcessor.process();
        studentProcessor.getObject();
    }
    */

    public static void main(String[] args) {
        Garage<Car> carGarage = new Garage<>();
        Garage<Drivable> newGarage = new Garage<>();

        move(carGarage, newGarage);
    }

    public static <T> void move (Garage<? extends T> source, Garage<? super T> destination) {
        destination.addAll(source.assets);
    }

}
