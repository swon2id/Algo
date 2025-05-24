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
        while(st.hasMoreTokens()) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        ArrayList<Integer> copy = new ArrayList<>(list);
        copy.sort(Comparator.naturalOrder());
        HashMap<Integer, Integer> orderTable = new HashMap<>();

        int compressedIndex = 0;
        for (int e: copy) {
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

//전체 요소 정렬
//
//정렬된 요소를 key로 value를 0부터 채움
//
//원본 요소를 출력할 때 mapping 함