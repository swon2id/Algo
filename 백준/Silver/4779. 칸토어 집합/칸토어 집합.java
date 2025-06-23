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
			String line = "-".repeat((int)Math.pow(3, N));
			sb.append(kantoa(line)).append("\n");
		}
		br.close();
		
		sb.setLength(sb.length() - 1);
		System.out.print(sb);

	}
	
	static String kantoa(String line) {
		int length = line.length();
		if (length > 1) {
			int lengthDividedBy3 = length / 3;
			String left = line.substring(0, lengthDividedBy3);
			String right = line.substring(lengthDividedBy3 * 2, length);
			return kantoa(left) + " ".repeat(lengthDividedBy3) + kantoa(right);
		}
		return "-";
	}
}

