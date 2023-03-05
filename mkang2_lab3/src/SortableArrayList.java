/**
 * Mingi Kang
 * 817415
 */

import java.util.Comparator;

/**
 * The SortableArrayList Class inherits SimpleArrayList. The Student Class
 * represents an ArrayList that stores type T objects and can sort them.
 *
 * TODO: Creates a SortableArraylist by calling the constructors from
 *       SimpleArrayList by calling super. Initializes all the instance
 *       variables from SimpleArrayList and SortableArrayList object can
 *       use SimpleArrayList methods (size, add, set, etc).
 *
 * SortableArrayList provides a method to sort the objects inside the Arraylist.
 * The method's signature is void, and does not return anything, it sorts objects
 * inside the ArrayList based on the specified Comparator class.
 *
 * @param <T> This class is of Generic type. SortableArrayList elements must be
 *           of type T.
 *
 */
public class SortableArrayList<T> extends SimpleArrayList<T> {

    public SortableArrayList(int startingCapacity) {
        super(startingCapacity);
    }

    /**
     * sort method sorts the elements inside the SortableArrayList object. For each
     * unsorted list index, starting from the end: it finds the largest value of
     * element in the unsorted part of the list, and swaps this value with the
     * rightmost unsorted list element.
     *
     * @param c the {@code Comparator} used to compare list elements.
     */

    public void sort(Comparator<? super T> c) {

        //looping through the elements in SortableArrayList
        for (int loops = this.size() - 1; loops > 0; loops--) {

            // getting the largest object in unsorted part
            T largest = this.get(loops);

            //Looping through the unsorted part of list to find the largest object
            for (int i = loops - 1; i > -1; i--) {
                if (c.compare(this.get(i), largest) >= 0) {
                    largest = this.get(i);
                }
            }

            //get the index of the largest in unsorted part
            int idx = loops;
            for (int j = loops; j > -1; j--) {
                if (largest == this.get(j)) {
                    break;
                } else {
                    idx--;
                }
            }

            //Create a temporary variable to store the rightmost element of unsorted part
            T temp = this.get(loops);

            //switch the largest object with the rightmost element of unsorted part
            this.set(idx, temp);
            this.set(loops, largest);

        }
    }

    public String toString() {
        String str = "[";
        for (int i = 0; i < this.size(); i++) {
            str += this.get(i);
            if (i < this.size() - 1) {
                str += ", ";
            }
        }
        return str + "]";
    }

    public static void main(String[] args) {
    }
}