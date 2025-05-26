import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String target = br.readLine();
        
        // Use Stack-based approach to efficiently handle the target removal
        Stack<Character> stack = new Stack<>();
        int targetLength = target.length();
        
        for (int i = 0; i < line.length(); i++) {
            stack.push(line.charAt(i));
            
            // Check if the stack's top contains the target pattern
            if (stack.size() >= targetLength) {
                boolean isMatch = true;
                
                // Compare with target string from the end
                for (int j = 0; j < targetLength; j++) {
                    if (stack.get(stack.size() - targetLength + j) != target.charAt(j)) {
                        isMatch = false;
                        break;
                    }
                }
                
                // If we found the target pattern, remove it from the stack
                if (isMatch) {
                    for (int j = 0; j < targetLength; j++) {
                        stack.pop();
                    }
                }
            }
        }
        
        // Prepare the result
        StringBuilder result = new StringBuilder();
        for (Character c : stack) {
            result.append(c);
        }
        
        // Output the result
        if (result.length() > 0) {
            System.out.print(result.toString());
        } else {
            System.out.print("FRULA");
        }
    }
}