import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	static int count = 0;
	
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		br.close();
				
		StringBuilder sb = new StringBuilder();
		fib(n);
		sb.append(count).append(' ');
		
		count = 0;
		fib_dp(n);
		sb.append(count);
		System.out.print(sb);
    }
	
	private static int fib(int n) {
		if (n <= 2) {
			count++;
			return 1;
		};
		return fib(n-1) + fib(n-2);
	}
	
	private static void fib_dp(int n) {
		int[] fib = new int[n+1];
		fib[1] = fib[2] = 1;
		
		for (int i = 3; i <= n; i++) {
			fib[i] = fib[i-1] + fib[i-2];
			count++;
		}
	}
}
