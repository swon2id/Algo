import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        char[] word = br.readLine().toUpperCase().toCharArray();
        HashMap<Character, Integer> alphabetCountTable = new HashMap<>();

        for (int i = 0; i < word.length; i++) {
            if (!alphabetCountTable.containsKey(word[i])) {
                alphabetCountTable.put(word[i], 1);
            } else {
                alphabetCountTable.put(word[i], alphabetCountTable.get(word[i]) + 1);
            }
        }


        char maxCountChar = '\0';
        int maxCount = 0;
        boolean isDuplicated = false;

        for (Map.Entry<Character, Integer> entry: alphabetCountTable.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                maxCountChar = entry.getKey();
                isDuplicated = false;
            } else if (entry.getValue() == maxCount) {
                isDuplicated = true;
            }
        }

        System.out.print(isDuplicated ? '?' : maxCountChar);
    }
}
