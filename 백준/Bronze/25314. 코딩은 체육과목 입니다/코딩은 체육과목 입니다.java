import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Main {
	static int count = 0;
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int byteSize = Integer.parseInt(br.readLine());
		br.close();
		
		StringBuilder sb = new StringBuilder();
		for (int i = 4; i <= byteSize; i+=4) {
			sb.append("long ");
		}
		sb.append("int");
		System.out.print(sb);
	}
}