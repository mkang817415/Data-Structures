public class DoublyLinkedList<T> {
    private DoubleListNode<T> head;
    private DoubleListNode<T> tail;
    private int length = 0;

    public DoubleListNode<T> getNodeByIndex (int index) {
        if (index >= length) return null;
        DoubleListNode<T> curr;

        if (index <= (int) (length/2)) {
            curr = head;
            for (int i = 0; i < index; i++) curr = curr.next;
        } else {
            curr = tail;
            for (int i = length-1; i > index; i--) curr = curr.prev;
        }

        return curr;

    }

    public T get (int index) {
        DoubleListNode<T> node = getNodeByIndex(index);

        if (node == null) return null;
        else return node.data;
    }

    public T set (int index, T item) {
        DoubleListNode<T> node = getNodeByIndex(index);
        if (node == null) return null;

        T oldData = node.data;
        node.data = item;
        return oldData;
    }

    public void insert (int index, T item) {
        // Always need a node for the new item.
        DoubleListNode<T> node = new DoubleListNode<>(item);

        // Handle the four cases we discussed.
        // Case 1: empty list.
        if (head == null) {
            head = node;
            tail = node;
        // Case 2: before front of non-empty list.
        } else if (index == 0) {
            node.next = head;
            head.prev = node;
            head = node;
        // Case 3: after end of non-empty list.
        } else if (index == length) {
            tail.next = node;
            node.prev = tail;
            tail = node;
        // Case 4: anywhere in the middle means we don't
        //         move head or tail.
        } else {
            // We need to add before the below node.
            DoubleListNode<T> addBefore = getNodeByIndex(index);

            addBefore.prev.next = node;
            node.next = addBefore;
            node.prev = addBefore.prev;
            addBefore.prev = node;
        }

        length++;
    }

    public T remove (int index) {
        // Usually need a place to hold the "old" data.
        T data;

        // Case 1: remove from empty list.
        if (head == null) return null;
        // Case 2: remove head.
        else if (index == 0) {
            data = head.data;

            // 2a: If this was the only node, it is a little different.
            if (head == tail) {
                tail = null;
                // 2b: Otherwise, tail is not impacted, but "next" node
                //     will be new head, must point "back" at nothing.
            } else {
                head.next.prev = null;
            }

            // Works for both.  Head becomes null or next node in list.
            head = head.next;

        // Case 3: remove tail (which is not also head).
        } else if (index == length-1) {
            data = tail.data;
            tail.prev.next = null;
            tail = tail.prev;
        // Case 4: remove neither head nor tail.
        } else {
            DoubleListNode<T> toRemove = getNodeByIndex(index);
            data = toRemove.data;

            toRemove.next.prev = toRemove.prev;
            toRemove.prev.next = toRemove.next;
        }

        length--;
        return data;
    }

    public void clear () {
        head = null;
        tail = null;
        length = 0;
    }

    public void append (T item) {
        DoubleListNode<T> node = new DoubleListNode<>(item);

        if (length == 0) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }

        length++;
    }

    public int size () {
        return length;
    }

    public String toString () {
        DoubleListNode<T> curr = head;

        String s = "(head)";
        while (curr != null) {
            s += " -> " + curr.data;
            curr = curr.next;
        }
        s += " -||\n";


        curr = tail;

        s += "(tail)";
        while (curr != null) {
            s += " -> " + curr.data;
            curr = curr.prev;
        }
        s += " -||\n";

        s += "\n------------";
        return s;
    }
}
