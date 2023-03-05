public class Stack<T> extends StackyLinkedList<T> {

    //Inheritance Way

    /**
     * Adds an item to the top of the stack.
     * @param item to add
     */
    public void push(T item) {
        addAtHead(item);
    }

    /**
     * Removes an item from the top of the stack.
     * @return the item which was removed
     */
    public T pop() {
        return removeFromHead();
    }

    /**
     * Non-destructively looks at the top of the stack.
     * @return the item on top of the stack.
     */
    public T peek() {
        return lookAtHead();
    }

    public void addAtTail(T item){
        throw new UnsupportedOperationException("Failed to add: \"" + item + "\" Stack should add at front only!");
    }

    public static void main(String[] args) {
    }

}


//    // Containership Way
//    private StackyLinkedList<T> list = new StackyLinkedList<>();
//    /**
//     * Adds an item to the top of the stack.
//     * @param item to add
//     */
//    public void push(T item) {
//        list.addAtHead(item);
//    }
//
//    /**
//     * Removes an item from the top of the stack.
//     * @return the item which was removed
//     */
//    public T pop() {
//        return list.removeFromHead();
//    }
//
//    /**
//     * Non-destructively looks at the top of the stack.
//     * @return the item on top of the stack.
//     */
//    public T peek() {
//        return list.lookAtHead();
//    }
//
//    /**
//     * Returns the total number of items in the stack.
//     * @return the stack depth.
//     */
//    public int size() {
//        return list.size();
//    }
//
//    public String toString() {
//        return list.toString();
//    }
//
//    public static void main(String[] args) {
//    }
//}
