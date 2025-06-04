import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class Main {
	static Boolean[] memo = new Boolean[1001];
	
	public static void main(String[] args) throws IOException {
		memo[1] = false;
		memo[2] = true;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int res = 0;
		for (int i = 0; i < N; i++) {
			if ( isPrime(Integer.parseInt(st.nextToken())) ) res++;
		}
		
		System.out.print(res);
	}
	
	private static boolean isPrime(int num) {
		if (memo[num] != null) return memo[num];
		
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i != 0) continue;
			
			memo[num] = false;
			return false;
		}			
		
		memo[num] = true;
		return true;
	}
}
