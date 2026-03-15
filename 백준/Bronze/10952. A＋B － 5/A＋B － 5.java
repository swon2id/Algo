import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

class Main {
	static int count = 0;
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		
		StringBuilder sb = new StringBuilder();
		while ((line = br.readLine()) != null) {
			if (line.contains("0 0")) break;
			StringTokenizer st = new StringTokenizer(line);
			sb.append(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())).append("\n");
		}
		br.close();
		
		sb.setLength(sb.length() - 1);
		System.out.print(sb);
	}
}