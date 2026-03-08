import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Main {
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print(Integer.parseInt(br.readLine()) - (2541-1998));
	}
}