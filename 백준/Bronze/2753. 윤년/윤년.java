import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Main {
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int year = Integer.parseInt(br.readLine());
		br.close();
		
		boolean isLeapYear = false;
		if (year % 4 == 0 && year % 100 != 0) isLeapYear = true;
		else if (year % 400 == 0) isLeapYear = true;
		
		System.out.print(isLeapYear ? 1 : 0);
	}
}