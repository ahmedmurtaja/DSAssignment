package dsassignment;

public class LLQueue<E> {
    private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> n) {
            next = n;
        }
    }

    private Node<E> front;
    private Node<E> rear;
    private int size;

    public LLQueue() {
        front = null;
        rear = null;
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
        return front.getElement();
    }

    public E last() {
        if (isEmpty()) {
            return null;
        }
        return rear.getElement();
    }

    public void enqueue(E elem) {
        Node<E> newest = new Node<E>(elem, null);
        if (isEmpty()) {
            front = newest;
        } else {
            rear.setNext(newest);
        }
        rear = newest;
        size++;
    }

    public E dequeue() {
        if (isEmpty()) {
            return null;
        }
        E answer = front.getElement();
        front = front.getNext();
        size--;
        if (size == 0) {
            rear = null;
        }
        return answer;
    }

    public void print() {
        if(isEmpty()){
            System.out.println("Queue is empty");
            return;
        }
        System.out.println("Front");
        Node<E> current = front;
        while (current != null) {
            System.out.println(current.getElement());
            current = current.getNext();
        }
        System.out.println("End");
    }
}
