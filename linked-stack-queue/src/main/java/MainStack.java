public class MainStack {

    public static void main(String[] args) {

        LinkedStack stack = new LinkedStack();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.show();

        System.out.println(stack.pop().getInfo());
        System.out.println(stack.pop().getInfo());
//
        System.out.println(stack.peek().getInfo());
        System.out.println(stack.peek().getInfo());

    }
}
