public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.insert(50);

        System.out.println("Show: ");
        list.show();

        System.out.println("get node: ");
        System.out.println(list.getNode(10).getInfo());

        System.out.println("List after remove:");
        list.removeNode(10);
        list.show();

        System.out.println("size: "+ list.size());

        System.out.println("************************");
        OrderedLinkedList orderedList = new OrderedLinkedList();


        orderedList.insert(10);
        orderedList.insert(100);
        orderedList.insert(20);
        orderedList.insert(60);
        orderedList.insert(50);
        orderedList.insert(40);

        orderedList.show();

    }
}
