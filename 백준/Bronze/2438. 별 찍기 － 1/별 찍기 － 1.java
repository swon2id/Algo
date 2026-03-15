import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Main {
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int height = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= height; i++) {
			sb.append("*".repeat(i)).append("\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.print(sb);
	}
}
