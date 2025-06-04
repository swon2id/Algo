import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		br.close();
		
		int num = 0;
		if (N > 0) {
			num = 666;
			int count = 1;
			
			while (count != N) {
				if (has666(++num)) count++;
			}
		}			
		
		System.out.print(num);
	}
	
	private static boolean has666(int num) {
		while (num > 99) {
			if (num % 1000 == 666) return true;
			num = num / 10;
		}
		return false;
	}
}
