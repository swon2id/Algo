import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        String line = br.readLine();
        Stack<Integer> stack = new Stack<>();
        StringTokenizer st;

        while(line != null && !line.isEmpty()) {
            switch(line) {
                case "2":
                    if(stack.isEmpty()) System.out.println(-1);
                    else System.out.println(stack.pop());
                    break;
                case "3":
                    System.out.println(stack.size());
                    break;
                case "4":
                    if(stack.isEmpty()) System.out.println(1);
                    else System.out.println(0);
                    break;
                case "5":
                    if(stack.isEmpty()) System.out.println(-1);
                    else System.out.println(stack.peek());
                    break;
                default:
                    st = new StringTokenizer(line);
                    st.nextToken();
                    stack.push(Integer.parseInt(st.nextToken()));
            }
            line = br.readLine();
        }

        br.close();
    }
}