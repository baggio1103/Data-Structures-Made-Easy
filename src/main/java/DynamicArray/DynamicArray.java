package DynamicArray;

import java.lang.reflect.Array;
import java.util.Arrays;

public class DynamicArray<T> {
    public T [] array;
    public int count;
    public int capacity;
    public Class<T> tClass;

    public DynamicArray(Class<T> tClass) {
        this.tClass = tClass;
        this.count = 0;
        this.capacity = 16;
        array = initNewArray(tClass, capacity);
    }

    public void makeArray(int newCapacity) {
        T[] originalArray = array;
        capacity = newCapacity;
        array = initNewArray(tClass, newCapacity);
        for (int i = 0; i < arrayToCopyFrom(originalArray, array).length; i++) {
            array[i] = originalArray[i];
        }
    }

    private T[] arrayToCopyFrom(T[] originalArray, T[] newArray) {
        return originalArray.length > newArray.length ? newArray : originalArray;
    }

    public T get(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + count);
        }
        return array[index];
    }

    public void add(T item) {
        if (count == capacity) {
            makeArray(capacity * 2);
        }
        array[count] = item;
        count++;
    }

    public void add(int index, T item) {
        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException("Index " + index + ", Size " + count);
        }
        if (count == capacity) {
            makeArray(capacity * 2);
        }
        for (int i = count; i > index; i--) {
            array[i] = array[i-1];
        }
        array[index] = item;
        count++;
    }

    public void remove(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Index " + index + ", Size " + count);
        }
        for (int i = index; i < count-1; i++) {
            array[i] = array[i+1];
        }
        array[count-1] = null;
        count--;
        reduceCapacity(count);
    }

    private void reduceCapacity(int count) {
        if (count < capacity / 2) {
            int newCapacity = (int) (capacity / 1.5);
            makeArray(Math.max(newCapacity, 16));
        }
    }

    public int size() {
        return count;
    }

    private T[] initNewArray(Class<T> tClass, int capacity) {
        return (T[]) Array.newInstance(tClass, capacity);
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

}