import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

class Main {
	static int count = 0;
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int receiptTotal = Integer.parseInt(br.readLine()), cases = Integer.parseInt(br.readLine());
		
		int calculatedTotal = 0;
		
		for (int i = 0; i < cases; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int price = Integer.parseInt(st.nextToken()), count = Integer.parseInt(st.nextToken());
			calculatedTotal += price * count;
		}
		br.close();
		System.out.print(receiptTotal == calculatedTotal ? "Yes" : "No");
	}
}