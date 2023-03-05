/**
 * Mingi Kang
 * 817415
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * The WordGen class produces 500 characters of randomly-generated text
 * following the probabilities of the input text
 *
 * TODO: Creates a SequenceTable object with the contents of the text file
 *      as a string, and with the probabilities of characters, it generates
 *      500 characters of randomly-generated text
 */
public class WordGen {
    /**
     * Read the contents of a file into a string. If the file does not exist
     * or cannot be read for any reason, returns null.
     *50 410 30 2
     * @param filename The name of the file to read.
     * @return The contents of the file as a string, or null
     */
    private static String readFileAsString(String filename){
        try{
            return Files.readString(Paths.get(filename));
        } catch (IOException e) {
            return null;
        }
    }

    public static void main(String[] args) {

        //Get document with scanner and turn into string
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter file to read: ");
        String file = scanner.nextLine();
        String contents = readFileAsString(file);
        if (contents == null) {
            System.out.println("Error: invalid filename");
            System.exit(0);
        }

        //Get integer k value with scanner
        System.out.println("Enter desired value of k: ");
        int k = scanner.nextInt();
        if (k<1) {
            System.out.println("Error: invalid k value");
            System.exit(0);
        }

        //Create SequenceTable with file string and k
        SequenceTable text = new SequenceTable(contents, k);
        text.collectFrequency();

        //Generate and print out 500 characters
        String words = contents.substring(contents.length()-k, contents.length());
        int i = k;
        while (i<500+k) {
            String key = words.substring(i - k, i);
            words = words + text.getCharacter(key);
            i += 1;
        }
        System.out.println(words.substring(k, words.length()));
    }
}
