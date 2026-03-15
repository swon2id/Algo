import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Main {
	static int count = 0;
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());			
		br.close();

		System.out.print(num * (num + 1) / 2);
	}
}
