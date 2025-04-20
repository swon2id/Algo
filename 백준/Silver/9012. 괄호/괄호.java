import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
        
		int testCaseNum = Integer.parseInt(br.readLine());
		for (int i = 0; i < testCaseNum; i++) {
			String input = br.readLine();
			Stack<Character> stack = new Stack<>();
			boolean isValid = true;

			for (int j = 0; j < input.length(); j++) {
				char currChar = input.charAt(j);
				
				switch (currChar) {
					case '(':
						stack.push(currChar);
						break;
					case ')':
						try{
							stack.pop();
						} catch (Exception e) {
							isValid = false;
							break;
						}
						break;
					default:
						continue;
				}
			}
			
			if (!isValid || !stack.isEmpty()) {
				System.out.println("NO");
			} else {
				System.out.println("YES");
			}
		}
		br.close();
    }
}
