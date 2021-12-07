public class Main {
    public static void main(String[] args) {


        HashTable tab = new HashTable(5);

        System.out.println(tab.findHashIdx(5));
        System.out.println(tab.findHashIdx(1));
        System.out.println(tab.findHashIdx(2));
        System.out.println(tab.findHashIdx(3));
        System.out.println(tab.findHashIdx(4));

        tab.insert(54);
        tab.insert(21);
        tab.insert(15);
        tab.insert(46);
        tab.insert(7);
        tab.insert(33);
        tab.insert(9);

        System.out.println(tab.find(54));
        System.out.println(tab.find(10));

        System.out.println(tab.remove(54));
        System.out.println(tab.remove(10));

        
    }
}
