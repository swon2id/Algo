import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Main {
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine()), y = Integer.parseInt(br.readLine());
		br.close();
		
		int res = -1;
		
		if (x > 0) res = y > 0 ? 1 : 4;
		else res = y > 0 ? 2 : 3;
		
		System.out.print(res);
	}
}