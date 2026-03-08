import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] nums = Main.parseInts(br.readLine());
		
		// StringBuilder sb = new StringBuilder();
		// for (int num : nums) {
		//  	sb.append(num).append('\n');
		// }
		
		// sb.setLength(sb.length() - 1);
		System.out.print(nums[0] - nums[1]);
	}
	
	static int[] parseInts(String s) {
		int len = s.length();
		int count = 0;
		boolean inNum = false;
		for (int i = 0; i < len; i++) {
			if (s.charAt(i) <= ' ') {
				inNum = false;
			} else if (!inNum) {
				inNum = true;
				count++;
			}
		}

		int[] result = new int[count];
		int idx = 0, start = -1;
		for (int i = 0; i <= len; i++) {
			boolean ws = (i == len) || s.charAt(i) <= ' ';
			if (ws) {
				if (start >= 0) {
					result[idx++] = Integer.parseInt(s, start, i, 10);
					start = -1;
				}
			} else if (start < 0) {
				start = i;
			}
		}
		return result;
	}
}

