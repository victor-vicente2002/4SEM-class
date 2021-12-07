package utils;

import interfaces.Filter;
import interfaces.Map;
import interfaces.Reduce;

public class NodeStream{
    private DoubleLinkedList list;

    public NodeStream(Node node) {
        list = new DoubleLinkedList(node);
    }

    public DoubleLinkedList getList() {
        return list;
    }

    public void setList(DoubleLinkedList list) {
        this.list = list;
    }

    public NodeStream map(Map map) {
        Node node = list.head;
        while (node.getInfo() != null) {
            node.setInfo(map.execute(node.getInfo()));
            node = node.getNext();
        }
        return this;
    }

    public NodeStream filter(Filter filter) {
        NodeStream nodeStream = new NodeStream(new Node(null));
        Node node = list.head.getNext();
        while (node != null) {
            if (filter.validate(node.getInfo())) {
                nodeStream.list.insert(node.getInfo());
            }
            node = node.getNext();
        }
        return nodeStream;
    }

    public int reduce(Reduce reduce) {
        Node node = list.head.getNext();
        int acumulator = 0;
        while (node != null) {
            reduce.reduce(acumulator, node.getInfo());
            acumulator++;
            node = node.getNext();
        }
        return acumulator;
    }
}