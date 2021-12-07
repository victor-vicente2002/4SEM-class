public class LinkedList {

    private Node head;

    public LinkedList() {
        head = new Node(0);
    }

    public Node getHead() {
        return head;
    }

    public void insert(int value) {
        Node node = new Node(value);
        node.setNext(head.getNext());
        head.setNext(node);
    }

    public void show() {
        Node node = head.getNext();
        while (node != null){
            System.out.println(node.getInfo());
            node = node.getNext();
        }
    }

    public Node getNode(int valor) {
        Node node = head.getNext();
        while (node != null) {
            if  (node.getInfo() == valor){
                return node;
            }else {
                node = node.getNext();
            }
        }
        return null;
    }

    public boolean removeNode(int value){
        Node previous = head;
        Node actual = head.getNext();
        while (actual != null) {
            if (actual.getInfo() ==value){
                previous.setNext(actual.getNext());
                return true;
            }else {
                previous = actual;
                actual = actual.getNext();
            }
        }
        return false;
    }

    public int size() {
        Node node = head.getNext();
        int size = 0;
        while (node != null){
            size++;
            node = node.getNext();
        }
        return size;
    }
}
