public class TestLinkedLists {

    public static void main (String[] args) {

        DoublyLinkedList<String> list = new DoublyLinkedList<>();

        // Case 1: Test insert empty list.
        list.insert(0, "initial node");

        list.append("first end");
        list.append("new end");
        list.append("new new end");
        System.out.println(list);

        // Case 2: Test insert front of non-empty list.
        list.insert(0, "new front");

        // Case 3: Test insert end of non-empty list.
        list.insert(list.size(), "inserted back");

        // Case 4: Test insert somewhere in the middle.
        list.insert(3, "should be index 3 now");

        System.out.println(list);


        // Case 4: Test remove somewhere in the middle.
        System.out.println(list.remove(3));
        System.out.println(list);

        // Case 3: Test remove last node.
        System.out.println(list.remove(list.size() - 1));
        System.out.println(list);

        // Case 2b: Test remove first (but not only) node.
        System.out.println(list.remove(0));
        System.out.println(list);

        // Remove three more to set up last test.
        list.remove(0);
        list.remove(0);
        list.remove(0);
        System.out.println(list);

        // Case 2a: Test remove first (and only) node.
        System.out.println(list.remove(0));
        System.out.println(list);

        // Case 1: Test trying to remove (anything) from empty list.
        System.out.println(list.remove(0));
        System.out.println(list);
    }

}
