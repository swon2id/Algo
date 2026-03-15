import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Main {
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());
		br.close();
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= 9; i++) {
			sb.append(x).append(" * ").append(i).append(" = ").append(x*i).append("\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.print(sb);
	}
}