public class LinkedQueue {

    private Node head;
    private Node lastNode;
    private int size;

    public LinkedQueue() {
        head = new Node(0);
        lastNode = new Node(0);
        size = 0;
    }

    public boolean isEmpty() {
        return head.getNext() == null;
    }

    public void insert(int value) {
        Node newNode = new Node(value);
        if (isEmpty()){
            head.setNext(newNode);
            lastNode.setNext(newNode);
        }else {
            Node penultimate = lastNode.getNext();
            penultimate.setNext(newNode);
            lastNode.setNext(newNode);
        }
        size++;
    }

    public Node poll() {
        if (!isEmpty()) {
            Node removed = head.getNext();
            head.setNext(removed.getNext());
            size--;
            return removed;
        }
        return null;
    }

    public Node peekFirst() {
        return isEmpty() ?
                null :
                head.getNext();

    }

    public Node peekLast() {
        return isEmpty() ?
                null :
                lastNode.getNext();

    }

    public void show() {
        Node selected = this.head.getNext();
        while (selected != null){
            System.out.println(selected.getInfo());
            selected = selected.getNext();
        }
    }
}
