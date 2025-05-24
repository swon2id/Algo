import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		br.readLine();
		String input = null;
		while((input = br.readLine()) != null) {
			st = new StringTokenizer(input);
			int repeatCount = Integer.parseInt(st.nextToken());
			char[] originalWord = st.nextToken().toCharArray();
			
			for(int i = 0; i < originalWord.length; i++) {
				for(int j = 1; j <= repeatCount; j++) {
					sb.append(originalWord[i]);
				}
			}
			sb.append('\n');
		}
		
		sb.setLength(sb.length() - 1);
		System.out.print(sb);
	}
}
