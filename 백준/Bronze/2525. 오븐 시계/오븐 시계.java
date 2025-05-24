import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int currHour = Integer.parseInt(st.nextToken());
        int currMin = Integer.parseInt(st.nextToken());
        int cookingDurationMin = Integer.parseInt(br.readLine());

        int endTimeTotalMin = currHour * 60 + currMin + cookingDurationMin;

        while (endTimeTotalMin >= 24 * 60) {
            endTimeTotalMin -= 24 * 60;
        }

        System.out.printf("%d %d", endTimeTotalMin / 60, endTimeTotalMin % 60);
    }
}
