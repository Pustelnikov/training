public class CustomLinkedList<T extends Comparable<T>>
        implements CustomList<T> {

    private static class Node<T> {
        private T value;
        private Node<T> next;

        Node(T value){
            this.value = value;
        }
    }

    private int listSize;
    private Node<T> head;

    @Override
    public void add(T value) {
        if (this.head == null) {
            this.head = new Node<>(value);
            this.listSize++;
            return;
        }
        Node<T> currentNode = this.head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = new Node<>(value);
        this.listSize++;
    }

    private boolean isIndexOutOfBounds(int index) {
        return index < 0 || index > this.listSize;
    }

    public void addFirst(T value){
        Node<T> firstNode = new Node<>(value);
        firstNode.next = this.head;
        this.head = firstNode;
        this.listSize++;
    }

    @Override
    public void add(T value, int index) {
        if (isIndexOutOfBounds(index)) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        if (index == 0) {
            this.addFirst(value);
            return;
        }
        Node<T> newNode = new Node<>(value);
        Node<T> currentNode = this.head;
        for (int i = 1; i < index; i++) {
            currentNode = currentNode.next;
        }
        newNode.next = currentNode.next;
        currentNode.next = newNode;
        this.listSize++;
    }

    @Override
    public T get(int index) {
        if (isIndexOutOfBounds(index)) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        Node<T> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.value;
    }

    @Override
    public void remove(T value) {
        if (this.head == null) {
            return;
        }
        if (this.head.value == value) {
            this.head = this.head.next;
            this.listSize--;
            return;
        }
        Node<T> currentNode = this.head;
        while (currentNode.next != null) {
            if (currentNode.next.value.equals(value)) {
                currentNode.next = currentNode.next.next;
                this.listSize--;
                return;
            }
            currentNode = currentNode.next;
        }
    }

    @Override
    public void clear() {
        this.head = null;
        this.listSize = 0;
    }

    @Override
    public void sort() {
        for (int i = 0; i < listSize - 1; i++) {
            Node<T> currentNode = head;
            for (int j = 0; j < listSize - 1 - i; j++) {
                if (currentNode.value.compareTo(currentNode.next.value)>0) {
                    T temp = currentNode.value;
                    currentNode.value = currentNode.next.value;
                    currentNode.next.value = temp;
                }
                currentNode = currentNode.next;
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> currentNode = head;
        for (int i = 0; i < listSize; i++) {
            sb.append("Object ");
            sb.append(i);
            sb.append(" : ");
            sb.append(currentNode.value);
            sb.append(" \n");
            currentNode = currentNode.next;
        }
        return sb.toString();
    }
}
