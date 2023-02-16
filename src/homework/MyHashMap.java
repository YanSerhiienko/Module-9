package homework;

import java.util.Objects;

public class MyHashMap<K, V> {
    //Потрібно робити за допомогою однозв'язної Node.
    //Не може зберігати дві ноди з однаковими ключами.
    //put(Object key, Object value) додає пару ключ + значення
    //remove(Object key) видаляє пару за ключем
    //clear() очищає колекцію
    //size() повертає розмір колекції
    //get(Object key) повертає значення (Object value) за ключем

    private Node<K, V> head;
    private Node<K, V> tail;
    private int size = 0;
    
    private class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> nextNode;
        private Node(K key, V value){
            this.key = key;
            this.value = value;
            nextNode = null;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public Node<K, V> getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node<K, V> nextNode) {
            this.nextNode = nextNode;
        }
    }
    
    public void put(K key, V value) {
        if (key == null || value == null) {
            throw new IllegalArgumentException("The given value is null, please set correct value");
        }
        Node<K, V> newNode = new Node<>(key, value);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.setNextNode(newNode);
            tail = newNode;
        }
        size++;
    }

    public void remove(K key) {
        Node<K, V> searchOfRemoved = head;
        int beforeRemoved = 0;
        while (!searchOfRemoved.getKey().equals(key)) {
            searchOfRemoved = searchOfRemoved.getNextNode();
            beforeRemoved++;
        }
        Node<K, V> searchBeforeRemoved = head;
        for (int i = 0; i < beforeRemoved - 1; i++) {
            searchBeforeRemoved = searchBeforeRemoved.getNextNode();
        }
        searchBeforeRemoved.setNextNode(searchBeforeRemoved.getNextNode().getNextNode());
        size--;
    }

    public void clear() {
        head = tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public V get(K key) {
        Node<K, V> searchOfValue = head;
        int counter = 0;
        while (!searchOfValue.getKey().equals(key)) {
            searchOfValue = searchOfValue.getNextNode();
            counter++;
            if (counter >= size) {
                break;
            }
        }
        return (counter >= size) ? (null) : (searchOfValue.getValue());
    }

    /////////////////////////////////////////////////////////////////////

    private Node<K, V> getNode(int index) {
        Objects.checkIndex(index, size);
        Node<K, V> searchOfNode = head;
        for (int i = 0; i < index; i++) {
            searchOfNode = searchOfNode.getNextNode();
        }
        return searchOfNode;
    }

    @Override
    public String toString() {
        Node<K, V> printer = head;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < size; i++) {
            result.append(printer.getKey()).append("=").append(printer.getValue()).append(" ");
            printer = printer.getNextNode();
        }
        return result.toString();
    }
}
