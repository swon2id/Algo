import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        br.readLine();
        st = new StringTokenizer(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> sortedList = new ArrayList<>();
        while(st.hasMoreTokens()) {
            int elem = Integer.parseInt(st.nextToken());
            list.add(elem);
            sortedList.add(elem);
        }

        sortedList.sort(Comparator.naturalOrder());
        HashMap<Integer, Integer> orderTable = new HashMap<>();

        int compressedIndex = 0;
        for (int e: sortedList) {
            if (orderTable.containsKey(e)) continue;
            orderTable.put(e, compressedIndex++);
        }

        for (int e: list) {
            sb.append(orderTable.get(e)).append(" ");
        }

        sb.setLength(sb.length()-1);
        System.out.print(sb);
    }
}