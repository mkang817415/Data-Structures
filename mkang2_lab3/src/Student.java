/**
 * Mingi Kang
 * 817415
 */

/**
 * The Student Class represents a single student's information.
 * Student Class requires a string of student's information as argument
 * and creates instance variables from the string of student's information
 *
 * TODO: Creates variables that are either used to store Student's information or
 *      modified information used for sorting in various ways. Modified information
 *      used to sort are su box number, last name, and number of vowels in full name.

 * Student provides methods to get the variable that are used to sort the SortableArrayList.
 * The methods return the student's last name, return the student's Su Box, return the number
 * of vowels in a student's full name.
 */

public class Student {
    /**
     * original is the string of student's information from a line of directory.txt.
     * name is the string of student's full name.
     * address is the string of student's address.
     * suBox is the string of student's su box number.
     * phone is the string of student's phone number.
     * email is the string of student's email.
     * firstNameSort is the string of student's first name in lower case.
     * lastNameSort is the string of student's last name in lower case.
     * suBoxSort is an integer of student's su box number.
     * phoneSort is a string of student's phone number without "-".
     * numVowelSort is a integer of the number of vowels in student's full name.
     *
     * @param original The original string of student's information from a line
     *                 of directory.txt
     */
    private String original;
    private String name;
    private String address;
    private String suBox;
    private String phone;
    private String email;
    private String firstNameSort;
    private String lastNameSort;
    private int suBoxSort;
    private String phoneSort;
    private int numVowelSort;

    public Student(String original) {
        this.original = original;

        //Splits the original string in pieces into an array
        String[] stringSections = original.trim().split(" \\| ");

        //Creates name, address, suBox, phone, email variables from stringSections

        name = stringSections[0];
        address = stringSections[1];
        suBox = stringSections[4];
        phone = stringSections[2];
        email = stringSections[3];

        //Creates phoneSort from removing "-" from the phone number string
        phoneSort = stringSections[2].replace("-", "");

        //Creates suBoxSort by changing Su Box number to integer
        suBoxSort = Integer.parseInt(stringSections[4]);

        //Creates firstNameSort and lastNameSort by separating them and making them
        //lower case.
        String[] splitName = stringSections[0].split(" ");
        firstNameSort = splitName[0].toLowerCase();
        lastNameSort = splitName[1].toLowerCase();

        //Creates a temporary variable fullName that consists of lowercase first and
        //last name combined that will be used for getting the number of vowels
        //for numVowelSort.
        String fullName = firstNameSort + lastNameSort;

        //Updates numVowelSort by increasing by increments of 1 each time
        //a vowel appears in fullName.
        numVowelSort = 0;
        for (int i = 0; i < fullName.length(); i++) {
            switch (fullName.charAt(i)) {
                case 'a', 'u', 'e', 'i', 'o' -> numVowelSort++;
            }
        }
    }


    /**
     * getLastNameSort method returns lastNameSort which will be
     * used in SortableArrayList to sort the students by last name.
     *
     * @return lastNameSort : The string of student's
     *                        last name in lower case.
     */
    public String getLastNameSort() {
        return lastNameSort;
    }

    /**
     * getSuBoxSort method returns suBoxSort which will be
     * used in SortableArrayList to sort the students by su box number.
     *
     * @return suBoxSort : The integer of student's
     *                     Su Box number.
     */
    public int getSuBoxSort(){
        return suBoxSort;
    }

    /**
     * getNumVowelSort method returns numVowelSort which will be
     * used in SortableArrayList to sort the students by the number
     * of vowels in their full name.
     *
     * @return NumVowelSort : The integer of number of
     *                        vowels in student's full
     *                        name.
     */
    public int getNumVowelSort() {
        return numVowelSort;
    }

    /**
     * toString method returns a specified format of student required by
     * the lab instructions.
     *
     * @return String - in format of :
     *          full name(with space between first and last), Su Box, phone number, email
     *
     */

    public String toString() {
        return String.format("%s, %s, %s, %s", name, suBox, phone, email);
    }

    public static void main(String[] args) {
    }

}