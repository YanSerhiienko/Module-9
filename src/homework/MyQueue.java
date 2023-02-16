package homework;

import java.util.Objects;

public class MyQueue<E> {
    //Написати свій клас MyQueue як аналог класу Queue, який буде працювати за принципом FIFO (first-in-first-out).
    //Можна робити за допомогою Node або використати масив.
    //add(Object value) додає елемент в кінець
    //clear() очищає колекцію
    //size() повертає розмір колекції
    //peek() повертає перший елемент з черги
    //poll() повертає перший елемент з черги і видаляє його з колекції

    private Node<E> head;
    private Node<E> tail;
    private int size = 0;

    private class Node<E> {
        private E value;
        private Node<E> nextNode;

        private Node(E value) {
            this.value = value;
            nextNode = null;
        }

        public E getValue() {
            return value;
        }

        public void setNextNode(Node<E> nextNode) {
            this.nextNode = nextNode;
        }

        public Node<E> getNextNode() {
            return nextNode;
        }
    }

    public void add(E object) {
        if (object == null) {
            throw new IllegalArgumentException("The given value is null, please set correct value");
        }
        Node<E> newNode = new Node<>(object);
        if(head == null) {
            head = tail = newNode;

        } else {
            tail.setNextNode(newNode);
            tail = newNode;
        }
        size++;
    }

    public void clear() {
        head = tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public E peek() {
        return head.getValue();
    }

    public E poll() {
        if (size == 0) {
            return null;
        }
        E deleted = head.getValue();
        head = head.getNextNode();
        size--;
        return deleted;
    }

    /////////////////////////////////////////////////////////////////////

    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> searchOfElement = head;
        for (int i = 0; i < index; i++) {
            searchOfElement = searchOfElement.getNextNode();
        }
        return searchOfElement.getValue();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < size; i++) {
            result.append(get(i)).append(" ");
        }
        return result.toString();
    }
}
