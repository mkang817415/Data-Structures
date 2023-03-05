public class Queue<T> {

    private DoublyLinkedList<T> list = new DoublyLinkedList<>();

    /**
     * Adds an item to the front of the queue.
     * @param item to add
     */
    public void enqueue (T item) {
        list.append(item);
    }

    /**
     * Removes an item from the front of the queue.
     * @return the item which was removed
     */
    public T dequeue () {
        return list.remove(0);
    }

    /**
     * Non-destructively looks at the front of the queue.
     * @return the next item in the queue.
     */
    public T peek () {
        return list.get(0);
    }

    /**
     * Returns the total number of items in the queue.
     * @return the queue length.
     */
    public int size () {
        return list.size();
    }

    public String toString () {
        return list.toString();
    }

}
