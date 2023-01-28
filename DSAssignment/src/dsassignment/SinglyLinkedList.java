package dsassignment;

public class SinglyLinkedList<E> {
    private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E element) {
            this.element = element;
            this.next = null;
        }

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public SinglyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        if (isEmpty()) {
            return null;
        }
        return head.getElement();
    }

    public E last() {
        if (isEmpty()) {
            return null;
        }
        return tail.getElement();
    }

    public void addFirst(E element) {
        Node<E> newest = new Node<>(element);
        newest.next = head;
        head = newest;
        if (size == 0) {
            tail = head;
        }
        size++;
    }

    public void addLast(E element) {
        Node<E> newest = new Node<>(element);
        if (isEmpty()) {
            head = newest;
        } else {
            tail.next = newest;
        }
        tail = newest;
        size++;
    }

    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        E element = head.getElement();
        head = head.next;
        size--;
        if (size == 0) {
            tail = null;
        }
        return element;
    }

    public E removeLast() {
        if (isEmpty()) {
            return null;
        }
        E element = tail.getElement();
        if (size == 1) {
            head = tail = null;
        } else {
            Node<E> current = head;
            while (current.next != tail) {
                current = current.next;
            }
            current.next = null;
            tail = current;
        }
        size--;
        return element;
    }

    public void print() {
        Node<E> current = head;
        while (current != null) {
            System.out.println(current.getElement());
            current = current.next;
        }
        System.out.println();
    }
}
