package homework;

import java.util.Objects;

public class MyStack<E> {
    //Написати свій клас MyStack як аналог класу Stack, який працює за принципом LIFO (last-in-first-out).
    //Можна робити за допомогою Node або використати масив.
    //push(Object value) додає елемент в кінець
    //remove(int index) видаляє елемент за індексом
    //clear() очищає колекцію
    //size() повертає розмір колекції
    //peek() повертає перший елемент стеку
    //pop() повертає перший елемент стеку та видаляє його з колекції

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

    public void push(E value) {
        if (value == null) {
            throw new IllegalArgumentException("The given value is null, please set correct value");
        }
        Node<E> newNode = new Node<>(value);
        if(head == null) {
            head = tail = newNode;

        } else {
            tail.setNextNode(newNode);
            tail = newNode;
        }
        size++;
    }

    public void remove(int index) {
        Objects.checkIndex(index, size);
        Node<E> beforeDeleted = getNode(index - 1);
        beforeDeleted.setNextNode(beforeDeleted.getNextNode().getNextNode());
        size--;
    }

    public void clear() {
        head = tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public E peek() {
        return getNode(size - 1).getValue();
    }

    public E pop() {
        E deleted = getNode(size - 1).getValue();
        tail = getNode(size - 2);
        tail.nextNode = null;
        size--;
        return deleted;
    }

    /////////////////////////////////////////////////////////////////////

    private Node<E> getNode(int index) {
        Node<E> searchOfNode = head;
        for (int i = 0; i < index; i++) {
            searchOfNode = searchOfNode.getNextNode();
        }
        return searchOfNode;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            System.out.println("There is no such element by index " + index + " for size " + size);
            return null;
        }
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
