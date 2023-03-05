import java.util.Iterator;
public class StackyLinkedList<T> implements Iterable<T>{
    public ListNode<T> head;
    public ListNode<T> tail;
    protected int length = 0;

    // No constructor needed.

    public void addAtHead (T item) {
        ListNode<T> node = new ListNode<>(item);

        if (head == null) {
            tail = node;
        } else {
            node.next = head;
        }

        head = node;
        length++;
    }

    public void addAtTail (T item) {
        ListNode<T> node = new ListNode<>(item);

        if (head == null) {
            head = node;
        } else {
            tail.next = node;
        }

        tail = node;
        length++;
    }

    public T removeFromHead () {
        if (head == null) return null;
        T removedData = head.data;

        if (head == tail) tail = null;
        head = head.next;

        length--;
        return removedData;
    }

    // Can't easily do removeFromTail without prev,
    // but don't need it!

    public T lookAtHead () {
        if (head == null) return null;
        else return head.data;
    }

    // Don't need lookAtTail for our use cases!

    public int size () {
        return length;
    }

    public Iterator<T> iterator() {
        return new StackyIterator<>(this);
    }

    public String toString () {
        String s = "(head)";

        ListNode<T> curr = head;
        while (curr != null) {
            s += " -> " + curr.data;
            curr = curr.next;
        }

        s += " <- (tail)";
        return s;
    }

    static public void main (String[] args) {
        StackyLinkedList<Integer> list = new StackyLinkedList<>();
        list.addAtHead(2);
        list.addAtHead(1);
        list.addAtTail(3);
        list.addAtTail(4);

        System.out.println(list);

        list.removeFromHead();
        list.removeFromHead();

        System.out.println(list);
    }
}
