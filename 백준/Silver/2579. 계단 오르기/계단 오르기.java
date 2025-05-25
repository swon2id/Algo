import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static int[] score;
	private static int[] maxScoreMemo;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
		score = new int[n+1];
		maxScoreMemo = new int[n+1];
		
		for (int i = 1; i <= n; i++) {
			score[i] = Integer.parseInt(br.readLine());
		}
		
		System.out.print(climb(n));
    }
	
	private static int climb(int n) {
		if (n == 1) return score[1];
		else if (n == 2) return score[1] + score[2];
		
		maxScoreMemo[1] = score[1];
		maxScoreMemo[2] = score[1] + score[2];
		
		for (int i = 3; i <= n; i++) {
			maxScoreMemo[i] = Math.max(maxScoreMemo[i-3] + score[i-1] + score[i], maxScoreMemo[i-2] + score[i]);
		}
		
		return maxScoreMemo[n];
	}
}
