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
            System.out.print(node.getInfo() + " ");
            node = node.getNext();
        }
    }

    public Node getNode(int value) {
        Node node = head.getNext();
        while (node != null) {
            if  (node.getInfo() == value){
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

    public void concatenate(LinkedList list) {
        Node actualList2 = list.getHead().getNext();
        while (actualList2 != null){
            this.insert(actualList2.getInfo());
            actualList2 = actualList2.getNext();
        }
    }

    public boolean compare(LinkedList list){
        if (this.size() != list.size()){
            return false;
        }

        boolean isIdentical = false;
        Node actualListNode = this.head.getNext();
        Node actualList2Node = list.getHead().getNext();

        while (actualListNode != null) {
            if (!(actualListNode.getInfo() == actualList2Node.getInfo())) {
                isIdentical = false;
                break;
            }else {
                isIdentical = true;
                actualListNode = actualListNode.getNext();
                actualList2Node = actualList2Node.getNext();
            }
        }

        return isIdentical;
    }

    public void showRecursive(Node firstNode) {
        if (firstNode != null){
            System.out.print(firstNode.getInfo() + " ");
            showRecursive(firstNode.getNext());
        }
    }

    public Node getNodeRecursive(int value, Node firstNode) {
        if (firstNode != null){
            if (firstNode.getInfo() == value) {
                return firstNode;
            }else {
                return getNodeRecursive(value, firstNode.getNext());
            }
        }else {
            throw new IllegalArgumentException("Number "+ value +" doesn't exists in the list");
        }
    }

    public boolean removeNodeRecursive(int value, Node headNode){
        Node actual = headNode.getNext();
        if (actual != null){
            if (value == actual.getInfo()){
                headNode.setNext(actual.getNext());
                return true;
            }else {
                return removeNodeRecursive(value, headNode.getNext());
            }
        }else{
            return false;
        }
    }

    public int sizeRecursive(Node firstNode) {
        if (firstNode != null){
            return sizeRecursive(firstNode.getNext()) + 1;
        }else {
            return 0;
        }
    }
}
