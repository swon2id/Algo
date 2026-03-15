import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Main {
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[] seen = new boolean[31];
		
		for (int i = 0; i < 28; i++) {
			seen[Integer.parseInt(br.readLine())] = true;
		}
		
		int[] badmans = new int[2];
		int count = 0;
		
		for (int i = 1; count < 2 && i < 31; i++) {
			if (!seen[i]) badmans[count++] = i;
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(badmans[0]).append('\n').append(badmans[1]);
		System.out.print(sb);
	}
}
