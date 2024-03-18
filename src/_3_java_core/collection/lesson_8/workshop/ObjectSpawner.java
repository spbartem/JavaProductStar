package _3_java_core.collection.lesson_8.workshop;
/*множественная параметризация классов
public class ObjectSpawner<C, T> {
    private Class<C> classC;

    private Class<T> classT;

    public ObjectSpawner(Class<C> classC, Class<T> classT) {
        this.classC = classC;
        this.classT = classT;
    }

    public C createC() throws InstantiationException, IllegalAccessException {
        return classC.newInstance();
    }
    public T createT() throws InstantiationException, IllegalAccessException {
        return classT.newInstance();
    }
}
*/
public class ObjectSpawner<C> {
    private Class<C> clazz;
    public ObjectSpawner(Class<C> classC) {
        this.clazz = classC;
    }
    public C create() throws InstantiationException, IllegalAccessException {
        return clazz.newInstance();
    }
}