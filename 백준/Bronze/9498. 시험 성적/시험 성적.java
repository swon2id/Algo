import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int score = Integer.parseInt(br.readLine());
		br.close();
		
		char res;
		
		if (score - 90 >= 0) res = 'A';
		else if (score - 80 >= 0) res = 'B';
		else if (score - 70 >= 0) res = 'C';
		else if (score - 60 >= 0) res = 'D';
		else res = 'F';

		System.out.print(res);
	}
}