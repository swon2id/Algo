import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		br.close();
		
		for (int i = 1; i < N; i++) {
			int currVal, sum;
			currVal = sum = i;
			
			while (currVal != 0) {
				sum += (currVal % 10);
				currVal /= 10;
			}
			
			if (sum == N) {
				System.out.print(i);
				return;
			}
		}

		System.out.print(0);
	}
}
