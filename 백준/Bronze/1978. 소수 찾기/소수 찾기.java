import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class Main {
	static boolean[] isPrimeNumList = new boolean[1001];
	
	public static void main(String[] args) throws IOException {
		for (int i = 2; i <= 1000; i++) isPrimeNumList[i] = true;
		for (int i = 2; i * i <= 1000; i++) {
			if (isPrimeNumList[i]) {
				for (int j = i * i; j <= 1000; j += i) isPrimeNumList[j] = false;
			}
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		br.close();
		int res = 0;
		for (int i = 0; i < N; i++) {
			if ( isPrimeNumList[Integer.parseInt(st.nextToken())]) res++;
		}
		
		System.out.print(res);
	}
}
