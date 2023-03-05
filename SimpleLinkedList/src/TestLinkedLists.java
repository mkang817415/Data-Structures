public class TestLinkedLists {

    public static void main(String[] args) {
//        SimpleLinkedList<String> list = new SimpleLinkedList<>();
//        list.append("Dave");
//        list.append("Ian");
//        list.append("Amari");
//        list.insert(0, "Jeongdahl");
//        list.insert(2, "Lanesha");
//        System.out.println(list);
//
//        System.out.println(list.set(3, "Ziyou"));
//        System.out.println(list.get(1));
//
//        System.out.println(list);
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.append("end node");
        list.append("new end node");
        list.append("really the end");
        System.out.println(list);
    }




//        // Add three items.
//        ListNode<Integer> head = new ListNode<>(10);
//        head.next = new ListNode<>(15);
//        head.next.next = new ListNode<>(20);
//
//        printlist(head);
//
//        // Add at beginning
//        ListNode<Integer> temp = new ListNode<>(5);
//        temp.next = head;
//        head = temp;
//
//        printlist(head);
//
//        // Add some at end.
//        ListNode curr;
//        for (int i = 25; i <= 50; i+=5){
//            curr = head;
//            while (curr.next != null) {
//                curr = curr.next;
//            }
//            curr.next = new ListNode<>(i);
//        }
//
//        printlist(head);
//    }

    private static void printlist (ListNode curr) {
        System.out.print("[");
        while(curr != null){
            System.out.print(" " + curr.data);
            curr = curr.next;
        }
        System.out.print("]\n");
    }
}
