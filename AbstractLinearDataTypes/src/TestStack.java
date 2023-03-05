public class TestStack {

    public static void main (String[] args) {
        // Test a stack.
        System.out.println("Testing a stack:\n\n");
        Stack<String> stack = new Stack<>();

        // Test peek/pop when empty.
        System.out.println(stack.peek());
        System.out.println(stack.pop());

        // Test pushing a few items.
        stack.push("pushed first");
        stack.push("pushed second");
        stack.push("pushed third");
        stack.push("pushed fourth");
        System.out.println(stack);
        System.out.println("--------");

        // Test peek.
        System.out.printf("Peek: %s\n", stack.peek());
        System.out.println(stack);
        System.out.println("--------");

        // Test pop.
        System.out.printf("Pop: %s\n", stack.pop());
        System.out.println(stack);
        System.out.println("--------");

        System.out.printf("Pop: %s\n", stack.pop());
        System.out.println(stack);
        System.out.println("--------");

        System.out.printf("Pop: %s\n", stack.pop());
        System.out.println(stack);
        System.out.println("--------");

        stack.addAtTail("shouldn't work");
        System.out.println(stack);
    }
}
