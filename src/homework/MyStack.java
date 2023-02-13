package homework;

public class MyStack<E> {
    //Написати свій клас MyStack як аналог класу Stack, який працює за принципом LIFO (last-in-first-out).
    //Можна робити за допомогою Node або використати масив.
    //push(Object value) додає елемент в кінець
    //remove(int index) видаляє елемент за індексом
    //clear() очищає колекцію
    //size() повертає розмір колекції
    //peek() повертає перший елемент стеку
    //pop() повертає перший елемент стеку та видаляє його з колекції

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

    public void push(E object) {
        Node<E> newNode = new Node<>(object);
        if(firstNode == null) {
            firstNode = lastNode = newNode;

        } else {
            lastNode.setNextNode(newNode);
            lastNode = newNode;
        }
        size++;
    }

    public void remove(int index) {
        Node<E> beforeDeleted = getNode(index - 1);
        beforeDeleted.setNextNode(beforeDeleted.getNextNode().getNextNode());
        size--;
    }

    public void clear() {
        firstNode = lastNode = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public E peek() {
        return getNode(size - 1).getObject();
    }

    public E pop() {
        E deleted = getNode(size - 1).getObject();
        lastNode = getNode(size - 2);
        lastNode.nextNode = null;
        size--;
        return deleted;
    }

    /////////////////////////////////////////////////////////////////////

    private Node<E> getNode(int index) {
        Node<E> getter = firstNode;
        for (int i = 0; i < index; i++) {
            getter = getter.getNextNode();
        }
        return getter;
    }

    public void stackToString() {
        for (int i = 0; i < size ; i++) {
            System.out.print(getNode(i).getObject() + " ");
        }
    }

}
