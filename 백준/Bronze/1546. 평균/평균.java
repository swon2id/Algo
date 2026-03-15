import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int scoreCount = Integer.parseInt(br.readLine());
		
		int max = -1;
		int[] originalScoreArr = new int[scoreCount];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		br.close();
		for (int i = 0; i < scoreCount; i++) {
			originalScoreArr[i] = Integer.parseInt(st.nextToken());
			if (originalScoreArr[i] > max) max = originalScoreArr[i];
		}
		
		double newTotal = 0;
		for (int i = 0; i < scoreCount; i++) {		
			newTotal = newTotal + (double)originalScoreArr[i] / max * 100.0;
		}
		
		System.out.print(newTotal/scoreCount);
	}
}