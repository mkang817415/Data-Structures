/**
 * Mingi Kang
 * 817415
 */
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.Scanner;
import java.io.File;

/**
 *
 * The DirectorySort scans a directory text file and creates a SortableArrayList object that
 * stores Student objects. After creating the SortableArrayList of Student object, it sorts
 * the directory by using different Comparator class's methods.
 *
 * TODO: Scans a directory text file and creates a SortableArrayList object that stores
 *       Student objects. After the SortableArrayList object has all the students from
 *       the directory, it sorts the Student Objects by last name, Su Box number, and
 *       the number of vowels in full name.
 */
public class DirectorySort {
    public static void main(String[] args) throws FileNotFoundException {

        //Try Catch to check if file given for the directory text file can be found
        Scanner scan;
        try {
            scan = new Scanner(new File("directory.txt"));
        } catch (Exception e) {
            System.out.println("Error: file not found");
            System.exit(0);
        }
        

        //Scans directory.txt
        scan = new Scanner(new File("directory.txt"));

        //Creates a new SortableArrayList
        SortableArrayList<Student> directory = new SortableArrayList<>(100);

        //Scans the document line by line and creates a Student object with the line of student
        // info from directory.txt as arguments and add Student object to SortableArrayList.
        while (scan.hasNext()) {
            String line = scan.nextLine();
            Student student = new Student(line);
            directory.add(student);
        }
        scan.close();

        // Creates integer value of last index and first index of SortableArrayList
        int lastIndex = directory.size()-1 ;
        int firstIndex = 0;

        // Uses SuComparator class and class method sort to sort SortableArrayList by Su Box number
        directory.sort(new SuComparator());
//        System.out.println("Which student has the smallest SU box?");
        System.out.printf("(a) %s\n", directory.get(firstIndex));
//        System.out.println("Which student has the largest SU box?");
        System.out.printf("(b) %s\n", directory.get(lastIndex));

        // Uses NameComparator class and class method sort to sort SortableArrayList by last name.
        directory.sort(new NameComparator());
//        System.out.println("Which student appears first in a printed directory, assuming the directory is ordered by last name?");
        System.out.printf("(c) %s\n", directory.get(firstIndex));
//        System.out.println("Which student appears last in a printed directory, assuming the directory is ordered by last name?");
        System.out.printf("(d) %s\n", directory.get(lastIndex));

        //Uses VowelComparator class and class method sort to sort SortableArrayList by number of vowels
        directory.sort(new VowelComparator());
//        System.out.println("Which student has the most vowels in their full name?");
        System.out.printf("(e) %s\n", directory.get(lastIndex));
//        System.out.println("Which student has the least vowels in their full name?");
        System.out.printf("(f) %s", directory.get(firstIndex));
    }

    /**
     * SuComparator Class implements the built-in Comparator interface.
     * Compare method compares two Student object's SuBoxSort (integer value of Su Box).

     */
    private static class SuComparator implements Comparator<Student> {
        /**
         * compare method compares Student object's SuBoxSort (integer value of
         * Su Box) to another Student object's SuBox Sort.
         *
         * @param a the first Student to be compared.
         * @param b the second Student to be compared.
         * @return int
         *      If Student b's Su Box is larger than Student a's Su Box, it returns -1.
         *      If Student b's Su Box is equal to Student a's, it returns 0.
         *      If Student b's Su Box is smaller than Student a's Su Box, it returns 1.
         */
        @Override
        public int compare(Student a, Student b) {
            if (a.getSuBoxSort() < b.getSuBoxSort()) {
                return -1;
            } else if (a.getSuBoxSort() == b.getSuBoxSort()) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    /**
     * VowelComparator Class implements the built-in Comparator interface.
     * Compare method compares two Student object's numVowelSort(integer value number
     * of vowels in full name).
     */
    private static class VowelComparator implements Comparator<Student> {
        /**
         * compare method compares Student object's numVowelSort (integer value number
         * of vowels in full name) to another Student object's numVowelSort.
         *
         * @param a the first Student to be compared.
         * @param b the second Student to be compared.
         * @return int
         *      If Student b's numVowelSort is larger than Student a's numVowelSort, it returns -1.
         *      If Student b's numVowelSort is equal to Student a's numVowelSort, it returns 0.
         *      If Student b's numVowelSort is smaller than Student a's numVowelSort, it returns 1.
         */
        @Override
        public int compare(Student a, Student b) {

            if (a.getNumVowelSort() < b.getNumVowelSort()) {
                return -1;
            } else if (a.getNumVowelSort() == b.getNumVowelSort()) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    /**
     * NameComparator Class implements the built-in Comparator interface.
     * Compare method compares two Student object's lastNameSort (string of last name in lowercase).
     */
    private static class NameComparator implements Comparator<Student> {
        /**
         * compare method compares Student object's lastNameSort (string of last name in lowercase)
         * to another Student object's lastNameSort. Method uses compareTo method that
         * allows comparing against another String object in alphabetically.
         *
         * @param a the first Student to be compared.
         * @param b the second Student to be compared.
         * @return int
         *      If Student b's last name is comes after Student a's last name, it returns -1.
         *      If Student b's last name is equal to Student a's last name, it returns 0.
         *      If Student b's last name is smaller than Student a's last name, it returns 1.
         */
        @Override
        public int compare(Student a, Student b) {
            return a.getLastNameSort().compareTo(b.getLastNameSort());
        }
    }
}