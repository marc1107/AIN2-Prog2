package pruefungsvorbereitung.klausurws20.aufgabe4;

public class Queue {
    private class Node {
        public int data;
        public Node next;
        public Node(int d, Node n) {
            data = d;
            next = n;
        }
    }

    Node rear;
    int size;

    public Queue() {
        rear = null;
        size = 0;
    }

    public void offer(int x) {
        if (rear == null) {
            rear = new Node(x, null);
            rear.next = rear;
        } else {
            Node p = rear;
            while (p.next != rear) {
                p = p.next;
            }
            p.next = new Node(x, rear);
        }
        size++;
    }

    public Node poll() {
        if(rear.next == rear)
            throw new NullPointerException();
        Node p = rear.next;
        rear.next = rear.next.next;
        size--;
        return p;
    }

    public void offerAll(Queue q) {
            for(Node p = q.rear; p.next != q.rear; p = p.next) {
                offer(p.data);
            }
    }

    public int size() {
        return size;
    }
}
