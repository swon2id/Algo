import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	static int[][][] memo = new int[21][21][21];
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		StringBuilder sb = new StringBuilder();
		
		while ((input = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(input);
			int a, b, c;
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			if (b == c && b == a && b == -1) break;
			sb.append(String.format("w(%d, %d, %d) = %d\n", a, b, c, w(a, b, c)));
		}
		br.close();
		sb.setLength(sb.length() - 1);
		System.out.print(sb);
    }
	
	public static int w(int a, int b, int c) {
		if (a <= 0 || b <= 0 || c <= 0) return 1;
		if (a > 20 || b > 20 || c > 20) return w(20, 20, 20);
		
		if (memo[a][b][c] != 0) {
			return memo[a][b][c];
		}
		
		if (a < b && b < c) {
			memo[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
			return memo[a][b][c];
		}
		memo[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
		return memo[a][b][c];
	}
}
