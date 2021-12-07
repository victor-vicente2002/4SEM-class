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
        Node returnedValue = null;
        while (node != null) {
            if  (node.getInfo() == value){
                returnedValue = node;
                break;
            }else {
                if (node.getInfo() < value){
                    throw new IllegalArgumentException("The number " + value + " doesn't exists in the list");
                }
                node = node.getNext();
            }
        }
        return returnedValue;
    }

    @Override
    public boolean removeNode(int value) {
        Node previous = getHead();
        Node actual = getHead().getNext();
        boolean found = false;
        while (actual != null) {
            if (actual.getInfo() == value){
                previous.setNext(actual.getNext());
                found = true;
                break;
            }else {
                if (actual.getInfo() < value){
                    found = false;
                    break;
                }
                previous = actual;
                actual = actual.getNext();
            }
        }
        return found;
    }
}
