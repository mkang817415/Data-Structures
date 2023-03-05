import java.util.Iterator;

public class StackyIterator<T> implements Iterator<T> {

    private ListNode<T> currentNode;

    public StackyIterator(StackyLinkedList<T> list) {
        this.currentNode = list.head;
    }
    public boolean hasNext(){
        return currentNode != null;
    }

    public T next() {
        T data = currentNode.data;
        currentNode = currentNode.next;
        return data;
    }
}
