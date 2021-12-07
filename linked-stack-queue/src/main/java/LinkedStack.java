public class LinkedStack {

    int top;
    private Node head;


    public LinkedStack() {
        head = new Node(0);
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public Node getHead() {
        return head;
    }

    public void push(int value){
        Node node = new Node(value);
        node.setNext(head.getNext());
        head.setNext(node);
        top++;
    }

    public Node pop() {
        if (this.isEmpty()){
            Node removed = this.getHead().getNext();
            this.getHead().setNext(removed.getNext());
            return removed;
        }
        return null;
    }

    public Node peek() {
        return this.getHead().getNext();
    }

    public void show() {
        Node selected = this.getHead().getNext();
        while (selected != null){
            System.out.println(selected.getInfo());
            selected = selected.getNext();
        }
    }
}
