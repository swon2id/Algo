import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		solve();
		br.close();
	}
	
	private static void solve() {
		StringBuilder sb = new StringBuilder();
		sb.append("\\    /\\\n");
		sb.append(" )  ( ')\n");
		sb.append("(  /  )\n");
		sb.append(" \\(__)|");
		System.out.print(sb);
	}
}