package homework;

public class MyArrayList<E> {
//    Можна використовувати 1 масив для зберігання даних.
//    add(Object value) додає елемент в кінець
//    remove(int index) видаляє елемент із вказаним індексом
//    clear() очищає колекцію
//    size() повертає розмір колекції
//    get(int index) повертає елемент за індексом

    private Object[] array;
    private int initialSize = 10;
    private int indexAdd = 0;

    public MyArrayList() {
        array = new Object[initialSize];
    }

    public void add(E value) {
        resizeIfNeeded();
        array[indexAdd] = value;
        indexAdd++;
    }

    public void remove(int index) {
        //Objects.checkIndex(index, indexAdd);
        System.arraycopy(array, index + 1, array, index, array.length - index - 1);
        indexAdd--;
        /*for (int i = index; i < array.length - 1; i++) {
            array[i] = array[i+1];
        }
        array[array.length - 1] = null;*/
    }

    public void clear() {
        initialSize = 10;
        indexAdd = 0;
        array = new Object[initialSize];
    }

    public int size () {
        return array.length;
    }

    public Object get(int index) {
        //Objects.checkIndex(index, indexAdd);
        return array[index];
    }

    /////////////////////////////////////////////////////////////////////

    private void resizeIfNeeded() {
        if(array.length == indexAdd) {
            initialSize *= 1.5;
            Object[] toCopy = new Object[initialSize];
            System.arraycopy(array, 0, toCopy,0, indexAdd);
            array = toCopy;
        }
    }

    public void add(int index, Object value) {
        //Objects.checkIndex(index, indexAdd);
        resizeIfNeeded();
        System.arraycopy(array, index, array, index + 1, indexAdd - index);
        array[index] = value;
    }

}
