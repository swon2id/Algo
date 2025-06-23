import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class Main {
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		
		while ((input = br.readLine()) != null) {
			int N = Integer.parseInt(input);
			int length = (int)Math.pow(3, N);
			sb.append(kantoa(length)).append("\n");
		}
		br.close();
		
		sb.setLength(sb.length() - 1);
		System.out.print(sb);

	}
	
	static String kantoa(int length) {
		if (length <= 1) return "-";

		int lengthDividedBy3 = length / 3;
		return kantoa(lengthDividedBy3) + " ".repeat(lengthDividedBy3) + kantoa(lengthDividedBy3);
	}
}
