package DynamicArray.raw;

import java.lang.reflect.Array;

public class DynamicArray<T> {
    public T [] array;
    public int count;
    public int capacity;
    public Class<T> tClass;

    public DynamicArray(Class<T> tClass) {
        this.tClass = tClass;
        this.count = 0;
        this.capacity = 16;
        array = (T[]) Array.newInstance(tClass, capacity);
    }

    public void makeArray(int new_capacity) {
        //Implement
    }

    public T getItem(int index) {
        //Implement
        return null;
    }

    public void add(T item) {
        //Implement
    }

    public void add(int index, T item) {
        //Implement
    }

    public void remove(int index) {
        //Implement
    }

}
