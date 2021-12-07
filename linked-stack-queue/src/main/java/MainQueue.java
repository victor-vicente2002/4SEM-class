public class MainQueue {

    public static void main(String[] args) {

        LinkedQueue queue = new LinkedQueue();

        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);
        queue.insert(5);

        System.out.println(queue.poll().getInfo());
        System.out.println(queue.poll().getInfo());

        System.out.println(queue.peekFirst().getInfo());
        System.out.println(queue.peekLast().getInfo());

        queue.show();
    }
}
