package homework;

import java.util.Arrays;

public class MyQueue<E> {
    //Написати свій клас MyQueue як аналог класу Queue, який буде працювати за принципом FIFO (first-in-first-out).
    //Можна робити за допомогою Node або використати масив.
    //add(Object value) додає елемент в кінець
    //clear() очищає колекцію
    //size() повертає розмір колекції
    //peek() повертає перший елемент з черги
    //poll() повертає перший елемент з черги і видаляє його з колекції

    private Node<E> firstNode;
    private Node<E> lastNode;
    private int size = 0;

    private class Node<E> {
        private E object;
        private Node<E> nextNode;

        private Node(E object) {
            this.object = object;
            nextNode = null;
        }

        public E getObject() {
            return object;
        }

        public void setNextNode(Node<E> nextNode) {
            this.nextNode = nextNode;
        }

        public Node<E> getNextNode() {
            return nextNode;
        }
    }

    public void add(E object) {
        Node<E> newNode = new Node<>(object);
        if(firstNode == null) {
            firstNode = lastNode = newNode;

        } else {
            lastNode.setNextNode(newNode);
            lastNode = newNode;
        }
        size++;
    }

    public void clear() {
        firstNode = lastNode = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public E peek() {
        return firstNode.getObject();
    }

    public E poll() {
        if (size == 0) {
            return null;
        }
        E deleted = firstNode.getObject();
        firstNode = firstNode.getNextNode();
        size--;
        return deleted;
    }

    /////////////////////////////////////////////////////////////////////

    public E get(int index) {
        Node<E> getter = firstNode;
        for (int i = 0; i < index; i++) {
            getter = getter.getNextNode();
        }
        return getter.getObject();
    }

    public void myQueToString() {
        for (int i = 0; i < size; i++) {
            System.out.print(get(i) + " ");
        }
    }

}
