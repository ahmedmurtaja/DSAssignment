package dsassignment;

public class LLStack<E> {

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

    private Node<E> top;
    private int size;

    public LLStack() {
        top = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return top.getElement();
    }

    public void push(E element) {
        Node<E> newNode = new Node<>(element, top);
        top = newNode;
        size++;
    }

    public E pop() {
        if (isEmpty()) {
            return null;
        }
        E element = top.getElement();
        top = top.getNext();
        size--;
        return element;
    }

    public void print() {
        LLStack<E> tempStack = new LLStack<>();

        System.out.println("Top");
        while (!isEmpty()) {
            E element = pop();
            System.out.println(element);
            tempStack.push(element);
        }
        while (!tempStack.isEmpty()) {
            push(tempStack.pop());
        }
        System.out.println("Bottom");
    }
}
