public class TestQueue {

    static public void main (String[] args) {

        // Test a queue.
        System.out.println("Testing a queue:\n\n");
        Queue<String> queue = new Queue<>();

        // Test peek/pop when empty.
        System.out.println(queue.peek());
        System.out.println(queue.dequeue());

        // Test enqueuing a few items.
        queue.enqueue("enqueued first");
        queue.enqueue("enqueued second");
        queue.enqueue("enqueued third");
        queue.enqueue("enqueued fourth");
        System.out.println(queue);

        // Test peek.
        System.out.printf("Peek: %s\n", queue.peek());
        System.out.println(queue);

        // Test dequeue.
        System.out.printf("Dequeue: %s\n", queue.dequeue());
        System.out.println(queue);

        System.out.printf("Dequeue: %s\n", queue.dequeue());
        System.out.println(queue);

        System.out.printf("Dequeue: %s\n", queue.dequeue());
        System.out.println(queue);

    }
}
