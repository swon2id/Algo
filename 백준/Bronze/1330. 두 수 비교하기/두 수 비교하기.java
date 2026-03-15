import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		br.close();
		StringTokenizer st = new StringTokenizer(line);
		int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());
		
		String res = A == B ? "==" : A > B ? ">" : "<";
		System.out.print(res);
	}
}