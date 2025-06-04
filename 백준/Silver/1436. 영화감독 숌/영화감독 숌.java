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
				num++;
				if (String.valueOf(num).contains("666")) {
					count++;
				}
			}
		}			
		
		System.out.print(num);
	}
}
