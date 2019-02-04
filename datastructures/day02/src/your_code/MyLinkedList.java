package your_code;

public class MyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    private class Node {
        Chicken val;
        Node prev;
        Node next;

        private Node(Chicken d, Node prev, Node next) {
            this.val = d;
            this.prev = prev;
            this.next = next;
        }

        private Node(Chicken d) {
            this.val = d;
            prev = null;
            next = null;
        }
    }

    public MyLinkedList() {
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

    public void add(Chicken c) {
        addLast(c);
    }

    public Chicken pop() {
        return removeLast();
    }

    public void addLast(Chicken c) {
        Node n1 = new Node(c, tail, null);
        if (head == null) {
            head = n1;
        }

        if (tail != null) {
            tail.next = n1;

        }
        tail = n1;
        size++;
    }

    public void addFirst(Chicken c) {
        Node n1 = new Node(c, null, head);
        if (tail == null)
            tail = n1;

        if (head != null) {
            head.prev = n1;

        }
        head = n1;
        size++;
    }

    public Chicken get(int index) {
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;

        }
        Chicken chick = current.val;
        return chick;
    }

    public Chicken remove(int index) {
        Node current = head;

        if (index == 0) {
            return removeFirst();
        }
        if (index == size - 1 || index==size) {
            return removeLast();
        } else {

            for (int i = 0; i < index; i++) {
                current = current.next;
            }

            current.prev.next= current.next;
            current.next.prev = current.prev;
            size--;
        }
        return current.val;
    }

    public Chicken removeFirst() {
        Node old = head;
        Chicken end = old.val;
        if (isEmpty()) {
            end = null;
        }
        if (size == 1) {
            head = null;
            tail = null;

        } else {
            head = head.next;
        }
        size--;

        return end;
    }

    public Chicken removeLast() {
        Node old = tail;
        Chicken end = old.val;
        if (isEmpty()) {
            end = null;
        }
        if (size == 1) {
            head = null;
            tail = null;

        } else {
            tail = tail.prev;
        }
        size--;

        return end;
    }
}