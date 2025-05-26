import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(br.readLine());
        int testCaseIdx = 0;

        Deque<Integer> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        while(testCaseIdx < testCaseCount) {
            String operations = br.readLine();
			br.readLine();

            // 리스트 초기화
            String rawList = br.readLine();
            rawList = rawList.substring(1, rawList.length() - 1);
			
			if (rawList.length() > 0) {
				String[] numListStr = rawList.split(",");
				for (String numStr: numListStr) {
					deque.add(Integer.parseInt(numStr));
				}
			}

            boolean reversed = false;
            boolean error = false;

            for (int i = 0; i < operations.length(); i++) {
                if (operations.charAt(i) == 'R') {
                    reversed = !reversed;
                } else {
                    if (deque.isEmpty()) {
                        error = true;
                        break;
                    }

                    if (reversed) deque.removeLast();
                    else deque.removeFirst();
                }
            }

            if (error) sb.append("error\n");
            else {
                sb.append("[");
                int size = deque.size();
                if (size > 0) {
                    Iterator<Integer> it;
                    if (!reversed) {
                        it = deque.iterator();
                    } else {
                        it = deque.descendingIterator();
                    }
                    sb.append(it.next());
                    while(it.hasNext()) {
                        sb.append(",").append(it.next());
                    }
                }
				sb.append("]\n");
            }

            // tc 인덱스 증가
			deque.clear();
            testCaseIdx++;
        }
        br.close();

        System.out.print(sb);
    }


}