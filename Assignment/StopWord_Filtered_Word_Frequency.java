import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class StopWord_Filtered_Word_Frequency {

    static void printFilteredWordFrequency(String feedback) {

        // Convert to lowercase and remove punctuation
        feedback = feedback.toLowerCase();
        feedback = feedback.replace(".", "");
        feedback = feedback.replace(",", "");

        String[] words = feedback.split("\\s+");

        String[] stopWords = {
            "the", "was", "and", "a", "is", "of", "in"
        };

        HashMap<String, Integer> frequency = new HashMap<>();

        for (int i = 0; i < words.length; i++) {

            boolean isStopWord = false;

            for (int j = 0; j < stopWords.length; j++) {

                if (words[i].equals(stopWords[j])) {
                    isStopWord = true;
                    break;
                }
            }

            if (!isStopWord && !words[i].isEmpty()) {

                if (frequency.containsKey(words[i])) {
                    frequency.put(
                        words[i],
                        frequency.get(words[i]) + 1
                    );
                } else {
                    frequency.put(words[i], 1);
                }
            }
        }

        // Convert HashMap entries to a List
        List<Map.Entry<String, Integer>> entries =
                new ArrayList<>(frequency.entrySet());

        // Sort by count in descending order
        entries.sort(
            (a, b) -> b.getValue().compareTo(a.getValue())
        );

        // Print result
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(
                entry.getKey() + ": " + entry.getValue()
            );
        }
    }

    public static void main(String[] args) {

        String feedback =
            "The mentor was great, the session was great and clear.";

        printFilteredWordFrequency(feedback);
    }
}
