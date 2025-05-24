import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] list = new int[N];
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        int[] sortedList = list.clone();
        Arrays.sort(sortedList);
        HashMap<Integer, Integer> orderTable = new HashMap<>();

        int compressedIndex = 0;
        for (int e: sortedList) {
            if (!orderTable.containsKey(e)) {
                orderTable.put(e, compressedIndex++);
            }
        }

        for (int e: list) {
            sb.append(orderTable.get(e)).append(" ");
        }

        sb.setLength(sb.length() - 1);
        System.out.print(sb);
    }
}