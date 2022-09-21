package mindera.mindswap.aveiro.module2.springboot.myfirstapi.garbage;

public class SingletonExample {

    private static SingletonExample singletonExample;
    private long id;

    private SingletonExample() {
        id = 0;
    }

    public static SingletonExample get() {
        if (singletonExample == null) {
            singletonExample = new SingletonExample();
        }
        return singletonExample;
    }

    public int singletonMethod() {
        return 10;
    }


    public long getNext() {
        return ++id;
    }

}
