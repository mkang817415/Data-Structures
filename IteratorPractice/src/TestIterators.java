import java.util.ArrayList;
import java.util.Iterator;

public class TestIterators {

    static public void main (String[] args) {
        //testArrayList();
        //testLinkedList();
        testSimpleArrayList();
    }

    static private void testArrayList() {
        System.out.println("\nArray List test...\n");

        ArrayList<String> list = new ArrayList<>();
        list.add("Item 1");
        list.add("Item 2");
        list.add("Item 3");
        list.add("Item 4");
        System.out.println(list);

        // Iterate by index.
        for (int i = 0; i < list.size(); i++) {
            System.out.println("By Index: " + list.get(i));
        }

        // Iterate automatically
        for (String s : list) {
            System.out.println("Automatic: " + s);
        }

        // Iterate manually.
        Iterator<String> iterator  = list.iterator();
        while (iterator.hasNext()) {
            System.out.println("Manual: " + iterator.next());
        }
    }

    static private void testLinkedList() {
        System.out.println("\nStacky Linked List test...\n");

        StackyLinkedList<String> list = new StackyLinkedList<>();
        list.addAtTail("Back 1");
        list.addAtTail("Back 2");
        list.addAtHead("Front 1");
        list.addAtHead("Front 2");
        System.out.println(list);

        Iterator<String> iterator = new StackyIterator<>(list);
        while (iterator.hasNext()) {
            System.out.println("Manual: " + iterator.next());
        }

        for (String s : list) {
            System.out.println("Manual: " + s);
        }
    }

    static private void testSimpleArrayList() {
        System.out.println("\nSimple Array List test...\n");

        SimpleArrayList<String> list = new SimpleArrayList<>();
        list.add("Item 1");
        list.add("Item 2");
        list.add("Item 3");
        list.add("Item 4");
        System.out.println(list);

        // Iterate by index.
        for (int i = 0; i < list.size(); i++) {
            System.out.println("By Index: " + list.get(i));
        }

//        // Iterate automatically
//        for (String s : list) {
//            System.out.println("Automatic: " + s);
//        }

        // Iterate manually.
        Iterator<String> iterator  = new SimpleArrayList<>(list);
        while (iterator.hasNext()) {
            System.out.println("Manual: " + iterator.next());
        }
    }
}
