import java.util.List;

public class SimpleLinkedList<T> {
    private ListNode<T> head;
    private int length = 0;

    //do not need a constructor, Linked List would be empty

    public void append(T item) {
        ListNode<T> node = new ListNode<>(item);

        if(head ==null) head = node;
        else {
            ListNode<T> curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = node;
        }
        length++;
    }

    public boolean insert (int atIndex, T item){
        ListNode<T> node = new ListNode<>(item);


        ListNode<T> curr = head;
        ListNode<T> prev = head;
        int currIdx = 0;

        while (currIdx != atIndex) {
            prev = curr;
            curr = curr.next;
            currIdx++;
        }

        if (curr == head) head = node;
        else prev.next = node;

        node.next = curr;

        length++;
        return true;
    }

    public T set(int index, T item){
        ListNode<T> curr = head;
        int currIdx = 0;
        while (currIdx != index) {
            if (curr == null) return null;

            curr = curr.next;
            currIdx++;
        }

        T original = curr.data;
        curr.data = item;
        return original;
    }
    public T get (int index){
        ListNode<T> curr = head;
        int currIdx = 0;
        while (currIdx != index) {
            curr = curr.next;
            currIdx++;
        }
        return curr.data;
    }


    public String toString(){
        ListNode<T> curr = head;

        String s = "(head)";
        while (curr != null) {
            s += " -> " + curr.data;
            curr = curr.next;
        }
        s += " -|| ";

        return s;
    }
}
