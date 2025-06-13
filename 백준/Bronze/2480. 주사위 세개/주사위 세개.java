import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		br.close();
		
		int duplicateCount = 0;
		int duplicateNum = 0;
		int diceA, diceB, diceC;
		
		diceA = Integer.parseInt(st.nextToken());
		diceB = Integer.parseInt(st.nextToken());
		if (diceA == diceB) { duplicateCount = 2; duplicateNum = diceA; }
		
		diceC = Integer.parseInt(st.nextToken());
		if (diceB == diceC) {
			if (duplicateCount == 2) {
				duplicateCount = 3;
			} else {
				duplicateCount = 2;
				duplicateNum = diceB;
			}
		} else if (diceA == diceC) {
			duplicateCount = 2;
			duplicateNum = diceC;
		}

		if (duplicateCount == 3) {
			System.out.print(10000 + duplicateNum * 1000);
			return;
		}
		
		if (duplicateCount == 2) {
			System.out.print(1000 + duplicateNum * 100);
			return;
		}
		
		System.out.print(100 * (int)Math.max(diceA, Math.max(diceB, diceC)));
	}
}

