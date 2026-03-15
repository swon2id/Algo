import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Main {
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int height = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		char[] line = " ".repeat(height).toCharArray();
		for (int i = height - 1; i >= 0; i--) {
			line[i] = '*';
			sb.append(line).append("\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.print(sb);
	}
}