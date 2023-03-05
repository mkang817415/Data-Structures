/**
 * Mingi Kang
 * 817415
 */
import java.util.Map;
import java.util.HashMap;
import java.util.Random;

/**
 * The FrequencyMap class represents the possibilities
 * of every possible character that follows each k-length
 * sequence
 *
 * TODO: Stores the possible characters that follow each k-length sequence
 *      and their frequencies
 */
public class FrequencyMap {
    /**
     * letters is the hashmap of all possible characters as keys
     * and the number of frequency as values.
     *
     * TODO: Create a new Hashmap and put the character into the
     *      Hashmap with 1 as value
     *
     * @args character - initial character to be added to the hashmap
     */
    private Map<Character, Integer> letters;

    public FrequencyMap(char character) {
        letters = new HashMap<>();
        letters.put(character, 1);
    }

    /**
     * updateMap method updates frequency of character in Hashmap.
     * Adds one frequency value to specified character/key or
     * makes new Entry if character not in Hashmap everytime
     * it is called.
     *
     * @param character - new character needed to be added to arraylist
     *                  letters or need to update character's frequency
     */
    public void updateMap(char character){
        if (letters.containsKey(character)){
            letters.put(character, letters.get(character) + 1);
        } else {
            letters.put(character, 1);
        }
    }

    /**
     * getLetter method randomly picks out a letter from the hashmap keys,
     * based on their frequency value
     *
     * @return char - random character from the hashmap
     */
    public char getLetter() {
        //Getting indexes from letter frequency
        int sumFrequency = 0;
        for (int frequency : letters.values()) {
            sumFrequency += frequency;
        }
        //Getting random index number
        Random random = new Random();
        int i = random.nextInt(1, sumFrequency + 1);

        //iterating through key/value and returning random character
        for (Map.Entry<Character, Integer> entry : letters.entrySet()) {
            if (i > entry.getValue()) {
                i = i - entry.getValue();
                continue;
            } else {
                return entry.getKey();
            }
        }
        return 'a';
    }

    @Override
    public String toString() {
        return "FrequencyMap{" +
                "letters=" + letters +
                '}';
    }

    public static void main(String[] args){
    }
}
