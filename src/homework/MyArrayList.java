package homework;

import java.util.Arrays;
import java.util.Objects;

public class MyArrayList<E> {
    //Можна використовувати 1 масив для зберігання даних.
    //add(Object value) додає елемент в кінець
    //remove(int index) видаляє елемент із вказаним індексом
    //clear() очищає колекцію
    //size() повертає розмір колекції
    //get(int index) повертає елемент за індексом

    private Object[] array;
    private int initialSize = 10;
    private int size = 0;

    public MyArrayList() {
        array = new Object[initialSize];
    }

    public void add(E value) {
        if (value == null) {
            throw new IllegalArgumentException("The given value is null, please set correct value");
        }
        resizeIfNeeded(size);
        array[size] = value;
        size++;
    }

    public void remove(int index) {
        Objects.checkIndex(index, size);
        System.arraycopy(array, index + 1, array, index, array.length - index - 1);
        size--;
    }

    public void clear() {
        size = 0;
        initialSize = 10;
        array = new Object[initialSize];
    }

    public int size () {
        return size;
    }

    public Object get(int index) {
        Objects.checkIndex(index, size);
        return array[index];
    }

    /////////////////////////////////////////////////////////////////////

    private void resizeIfNeeded(int index) {
        Objects.checkIndex(index, size + 1);
        if(array.length == index) {
            initialSize = (int)Math.ceil(initialSize * 1.5);
            Object[] toCopy = new Object[initialSize];
            System.arraycopy(array, 0, toCopy,0, size);
            array = toCopy;
        }
    }

    public void add(int index, E value) {
        if (value == null) {
            throw new IllegalArgumentException("The given value is null, please set correct value");
        }
        resizeIfNeeded(index);
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = value;
        size++;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(array, size));
    }
}
