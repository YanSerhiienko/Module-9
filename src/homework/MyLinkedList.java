package homework;

import java.util.Objects;

public class MyLinkedList<E> {
    //Не можна використовувати масив.
    //Кожний елемент повинен бути окремим об'єктом-посередником (Node - нода),
    //що зберігає посилання на попередній та наступний елемент колекції (двозв'язний список).
    //add(Object value) додає елемент в кінець
    //remove(int index) видаляє елемент із вказаним індексом
    //clear() очищає колекцію
    //size() повертає розмір колекції
    //get(int index) повертає елемент за індексом

    private Node<E> tail;
    private Node<E> head;
    private int size = 0;

    private class Node<E> {
        private E element;
        private Node<E> prevNode;
        private Node<E> nextNode;

        private Node(E element) {
            this.element = element;
            this.prevNode = null;
            this.nextNode = null;
        }

        public Node<E> getPrevNode() {
            return prevNode;
        }

        public void setPrevNode(Node<E> prevNode) {
            this.prevNode = prevNode;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node<E> nextNode) {
            this.nextNode = nextNode;
        }
    }

    public void add(E value) {
        if (value == null) {
            throw new IllegalArgumentException("The given value is null, please set correct value");
        }

        Node<E> newNode = new Node<>(value);

        if (head == null) {
            head = tail = newNode;
        } else if (size == 1) {
            tail = newNode;
            head.setNextNode(tail);
            tail.setPrevNode(head);
        } else {
            tail.setNextNode(newNode);
            newNode.setPrevNode(tail);
            tail = newNode;
        }
        size++;
    }

    public void remove(int index) {
        Objects.checkIndex(index, size);
        if (index == 0) {
            Node<E> after = getNode(index + 1);
            head = after;
        }
        else if (index == size - 1) {
            Node<E> before = getNode(index - 1);
            tail = before;
        }
        else {
            Node<E> after = getNode(index + 1);
            Node<E> before = getNode(index - 1);
            after.setPrevNode(before);
            before.setNextNode(after);
        }
        size--;
    }

    public void clear() {
        tail = head = null;
//        tail = new Node<>(head,null,null);
//        head = new Node<>(null,null, tail);
        size = 0;
    }

    public int size() {
        return size;
    }

    public E get(int index) {
        Objects.checkIndex(index, size);
        if (index >= size) {
            return null;
        }
        Node<E> searchOfElement = head;
        for (int i = 0; i < index; i++) {
            searchOfElement = searchOfElement.getNextNode();
        }
        return searchOfElement.getElement();
    }

    /////////////////////////////////////////////////////////////////////

    private Node<E> getNode(int index) {
        Node<E> searchOfNode = head;
        for (int i = 0; i < index; i++) {
            searchOfNode = searchOfNode.getNextNode();
        }
        return searchOfNode;
    }



    /////////////////////// OLD VERSION /////////////////////////////////

//    private Node<E> tail;
//    private Node<E> head;
//    private int size = 0;
//
//    public MyLinkedList() {
//        head = new Node<>(null, null, tail);
//        tail = new Node<>(head, null, null);
//    }
//
//    private class Node<E> {
//        private E element;
//        private Node<E> prevNode;
//        private Node<E> nextNode;
//
//        private Node(Node<E> prevNode, E element, Node<E> nextNode) {
//            this.element = element;
//            this.prevNode = prevNode;
//            this.nextNode = nextNode;
//        }
//
//        public Node<E> getPrevNode() {
//            return prevNode;
//        }
//
//        public void setPrevNode(Node<E> prevNode) {
//            this.prevNode = prevNode;
//        }
//
//        public E getElement() {
//            return element;
//        }
//
//        public void setElement(E element) {
//            this.element = element;
//        }
//
//        public Node<E> getNextNode() {
//            return nextNode;
//        }
//
//        public void setNextNode(Node<E> nextNode) {
//            this.nextNode = nextNode;
//        }
//    }
//
//    public void add(E value) {
//        if (value == null) {
//            throw new IllegalArgumentException("The given value is null, please set correct value");
//        }
//        Node<E> newNode = tail;
//        if (size == 0) {
//            head.setNextNode(newNode);
//        }
//        newNode.setElement(value);
//        tail = new Node<>(newNode,null, null);
//        newNode.setNextNode(tail);
//        size++;
//    }
//
//    public void remove(int index) {
//        Objects.checkIndex(index, size);
//        if (index == 0) {
//            Node<E> after = getNode(index + 1);
//            head.setNextNode(after);
//            after.setPrevNode(head);
//        }
//        else if (index == size - 1) {
//            Node<E> before = getNode(index - 1);
//            tail.setPrevNode(before);
//            before.setNextNode(tail);
//        }
//        else {
//            Node<E> after = getNode(index + 1);
//            Node<E> before = getNode(index - 1);
//            after.setPrevNode(before);
//            before.setNextNode(after);
//        }
//        size--;
//    }
//
//    public void clear() {
//        tail = new Node<>(head,null,null);
//        head = new Node<>(null,null, tail);
//        size = 0;
//    }
//
//    public int size() {
//        return size;
//    }
//
//    public E get(int index) {
//        Objects.checkIndex(index, size);
//        if (index >= size) {
//            return null;
//        }
//        Node<E> searchOfElement = head.getNextNode();
//        for (int i = 0; i < index; i++) {
//            searchOfElement = searchOfElement.getNextNode();
//        }
//        return searchOfElement.getElement();
//    }
//
//    /////////////////////////////////////////////////////////////////////
//
//    private Node<E> getNode(int index) {
//        Node<E> searchOfNode = head.getNextNode();
//        for (int i = 0; i < index; i++) {
//            searchOfNode = searchOfNode.getNextNode();
//        }
//        return searchOfNode;
//    }
}
