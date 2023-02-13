package homework;

public class MyLinkedList<E> {
    //Не можна використовувати масив.
    //Кожний елемент повинен бути окремим об'єктом-посередником (Node - нода),
    //що зберігає посилання на попередній та наступний елемент колекції (двозв'язний список).
    //add(Object value) додає елемент в кінець
    //remove(int index) видаляє елемент із вказаним індексом
    //clear() очищає колекцію
    //size() повертає розмір колекції
    //get(int index) повертає елемент за індексом

    private Node<E> lastNull;
    private Node<E> firstNull;
    int sizeCounter = 0;

    public MyLinkedList() {
        lastNull = new Node<>(firstNull,null,null);
        firstNull = new Node<>(null,null, lastNull);
    }

    private class Node<E> {
        private E element;
        private Node<E> prevElement;
        private Node<E> nextElement;

        private Node(Node<E> prevElement, E element, Node<E> nextElement) {
            this.element = element;
            this.prevElement = prevElement;
            this.nextElement = nextElement;
        }

        public Node<E> getPrevElement() {
            return prevElement;
        }

        public void setPrevElement(Node<E> prevElement) {
            this.prevElement = prevElement;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getNextElement() {
            return nextElement;
        }

        public void setNextElement(Node<E> nextElement) {
            this.nextElement = nextElement;
        }




    }

    public void add(E object) {
        Node<E> next = lastNull;
        next.setElement(object);
        lastNull = new Node<>(next,null, null);
        next.setNextElement(lastNull);
        sizeCounter++;
    }

    public void remove(int index) {
        if (index == 0) {
            Node<E> after = getNode(index + 1);
            firstNull.setNextElement(after);
            after.setPrevElement(firstNull);
            sizeCounter--;
        }
        else if (index == sizeCounter - 1) {
            Node<E> before = getNode(index - 1);
            lastNull.setPrevElement(before);
            before.setNextElement(lastNull);
            sizeCounter--;
        }
        else {
            Node<E> after = getNode(index + 1);
            Node<E> before = getNode(index - 1);
            after.setPrevElement(before);
            before.setNextElement(after);
            sizeCounter--;
        }
    }

    public void clear() {
        lastNull = new Node<>(firstNull,null,null);
        firstNull = new Node<>(null,null, lastNull);
        sizeCounter = 0;
    }

    public int size() {
        return sizeCounter;
    }

    public E get(int index) {
        Node<E> getter = firstNull.getNextElement();
        for (int i = 0; i < index; i++) {
            getter = getter.getNextElement();
        }
        return getter.getElement();
    }

    /////////////////////////////////////////////////////////////////////

    private Node<E> getNode(int index) {
        Node<E> getter = firstNull.getNextElement();
        for (int i = 0; i < index; i++) {
            getter = getter.getNextElement();
        }
        return getter;
    }

}
