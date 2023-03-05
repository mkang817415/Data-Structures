/**
 * Mingi Kang
 * 817415
 */
import java.util.Map;
import java.util.HashMap;
/**
 * The SequenceTable takes some input text as string and analyzes and stores
 * the possibilities of every possible character that follows each k-length
 * sequence encountered in the input text
 *
 * SequenceTable creates a hashmap of k length sequence string as key and
 * Frequency Map objects as values
 *
 * TODO: Takes the string of text and the k, the number of letters to analyze
 *      and creates a Hashmap of k previous letters as key
 *      and Frequency Map object.
 */
public class SequenceTable {
    /**
     * contents is the text that you are finding the probabilities
     * modifiedContents is the modified text with the last k letters added in front of the text
     * k is the number of characters to analyze
     * table is the Hashmap that stores k sequence strings as keys and
     * FrequencyMap objects as values
     *
     * @arg contents - string value of text to analyze
     * @arg k - integer value, desired level of analysis
     */
    private String contents;
    private String modifiedContents;
    private int k;
    private Map<String, FrequencyMap> table;

    public SequenceTable(String contents, int k) {
        this.contents = contents;
        this.k = k;
        modifiedContents = contents.substring(contents.length()-k, contents.length()) + contents;
        table = new HashMap<>();
    }

    /**
     * collectFrequency method analyzes the text to the level k of desired
     * analysis and creates a hashmap with k-length sequence string
     * as key and correlated FrequencyMap object as value. Updates the
     * FrequencyMap's probabilities in array.
     */
    public void collectFrequency(){
        for (int i = k; i < modifiedContents.length(); i++) {
            String key = modifiedContents.substring(i-k, i);
            char value = modifiedContents.charAt(i);
            if (table.containsKey(key)) {
                table.get(key).updateMap(value);
            } else {
                FrequencyMap item = new FrequencyMap(value);
                table.put(key, item);
            }
        }
    }

    /**
     * getCharacter method finds the Frequency Map object value based on
     * the key string. Once found, it uses getLetter method from Frequency
     * Map Class and returns a character.
     *
     * @param key - k-length sequence string
     * @return char - returns random letters from the FrequencyMap object's method
     *                  getLetter
     */
    public char getCharacter(String key){
        return table.get(key).getLetter();
    }

    @Override
    public String toString() {
        return "SequenceTable{" +
                "table=" + table +
                '}';
    }

    public static void main(String[] args){
    }
}
