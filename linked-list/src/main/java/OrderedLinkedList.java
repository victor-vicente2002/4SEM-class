public class OrderedLinkedList extends LinkedList{

    @Override
    public void insert(int value) {
        Node actual = getHead().getNext();
        Node previous = getHead();
        boolean isAdded = false;
        while (!isAdded) {
            if (actual == null) {
                previous.setNext(new Node(value));
                isAdded = true;
            }else {
                if (actual.getInfo() <= value){
                    Node newNode = new Node(value);
                    newNode.setNext(actual);
                    previous.setNext(newNode);
                    isAdded = true;
                }else {
                    actual = actual.getNext();
                    previous = previous.getNext();
                }
            }
        }
    }

    @Override
    public Node getNode(int value) {
        Node node = getHead().getNext();
        boolean foundNode = false;
        while (node != null) {
            if  (node.getInfo() == value){
                return node;
            }else {
                if (node.getInfo() < value){
                    return null;
                }
                node = node.getNext();
            }
        }
        return null;
    }
}
