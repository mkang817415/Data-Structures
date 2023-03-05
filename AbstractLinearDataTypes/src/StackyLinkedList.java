public class StackyLinkedList<T> {

    private StackyListNode<T> head;
    private StackyListNode<T> tail;
    private int length = 0;

    public void addAtHead (T item) {
        StackyListNode<T> node = new StackyListNode<>(item);

        if (head == null) {
            tail = node;
        } else {
            node.next = head;
        }

        head = node;
        length++;
    }

    public void addAtTail (T item) {
        StackyListNode<T> node = new StackyListNode<>(item);

        if (head == null) {
            head = node;
        } else {
            tail.next = node;
        }

        tail = node;
        length++;
    }

    public T removeFromHead(){
        //Disconnect and remove head and return head
        if (head == null) return null;
        T removedData = head.data;
        head = head.next;

        if (head == tail) tail = null;

        length--;
        return removedData;
    }

    public T lookAtHead(){
        //peak at head
        if (head == null) return null;
        return head.data;
    }

    public int size(){
        return length;
    }

    public String toString(){
        String s = "(head)";

        StackyListNode<T> curr = head;
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
        System.out.println(list.lookAtHead());
        System.out.println(list.removeFromHead());
        System.out.println(list.removeFromHead());
        System.out.println(list);
    }
}
