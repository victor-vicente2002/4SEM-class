public class Main2 {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.insert(50);

        list.show();
        System.out.println();

        LinkedList list2 = new LinkedList();

        list2.insert(10);
        list2.insert(20);
        list2.insert(30);
        list2.insert(40);
        list2.insert(50);

        System.out.println(list.compare(list2));
        list2.show();
        System.out.println();
        list.concatenate(list2);
        list.show();
        System.out.println();

        System.out.println("Recursive");
        list2.showRecursive(list2.getHead().getNext());
        System.out.println();
        System.out.println(list2.getNodeRecursive(20, list2.getHead().getNext()).getInfo());
        System.out.println(list2.removeNodeRecursive(10, list2.getHead()));
        list2.show();
        System.out.println();
        System.out.println(list2.size() + " " + list2.sizeRecursive(list2.getHead().getNext()));
    }
}
