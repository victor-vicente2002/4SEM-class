public class HashTable {

    LinkedList[] tab;

    public HashTable(int entries) {
        tab = new LinkedList[entries];
        for (int i = 0; i < entries; i++){
            tab[i] = new LinkedList();
        }
    }

    public int findHashIdx(int value){
        return value % tab.length;
    }

    public void insert(int value){
        tab[this.findHashIdx(value)].insert(value);
    }

    public boolean find(int value){
        return tab[this.findHashIdx(value)].getNode(value) != null;
    }

    public boolean remove(int value) {
        if (find(value)){
            return tab[this.findHashIdx(value)].removeNode(value);
        }else {
            return false;
        }
    }
}
