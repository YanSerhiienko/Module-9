package homework;

public class MyHashMap<E> {
    //Потрібно робити за допомогою однозв'язної Node.
    //Не може зберігати дві ноди з однаковими ключами.
    //put(Object key, Object value) додає пару ключ + значення
    //remove(Object key) видаляє пару за ключем
    //clear() очищає колекцію
    //size() повертає розмір колекції
    //get(Object key) повертає значення (Object value) за ключем

    private Node<E> firstNode;
    private Node<E> lastNode;
    private int size = 0;
    
    private class Node<E> {
        E key;
        E value;
        Node<E> nextNode;
        private Node(E key, E value){
            this.key = key;
            this.value = value;
            nextNode = null;
        }

        public E getKey() {
            return key;
        }

        public E getValue() {
            return value;
        }

        public Node<E> getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node<E> nextNode) {
            this.nextNode = nextNode;
        }
    }
    
    public void put(E key, E value) {
        Node<E> newNode = new Node<>(key, value);
        if (firstNode == null) {
            firstNode = lastNode = newNode;
        } else {
            lastNode.setNextNode(newNode);
            lastNode = newNode;
        }
        size++;
    }

    public void remove(E key) {
        Node<E> getter = firstNode;
        int beforeRemoved = 0;
        while (!getter.getKey().equals(key)) {
            getter = getter.nextNode;
            beforeRemoved++;
        }
        Node<E> beforeGetter = firstNode;
        for (int i = 0; i < beforeRemoved - 1; i++) {
            beforeGetter = beforeGetter.getNextNode();
        }
        beforeGetter.setNextNode(beforeGetter.getNextNode().getNextNode());
        size--;
    }

    public void clear() {
        firstNode = lastNode = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public E get(E key) {
        Node<E> getter = firstNode;
        while (!getter.getKey().equals(key)) {
            getter = getter.nextNode;
        }
        return getter.getValue();
    }

    /////////////////////////////////////////////////////////////////////

    private Node<E> nodeGetter(int index) {
        Node<E> nodeGetter = firstNode;
        for (int i = 0; i < index; i++) {
            nodeGetter = nodeGetter.getNextNode();
        }
        return nodeGetter;
    }

    public void hashMapToString() {
        for (int i = 0; i < size; i++) {
            System.out.print(nodeGetter(i).getValue() + " ");
        }
    }

}
