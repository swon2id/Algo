import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

        int tcCount = Integer.parseInt(br.readLine());
		for (int i = 0; i < tcCount; i++) {
			int n = Integer.parseInt(br.readLine());
			int[] nums = new int[n];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				nums[j] = Integer.parseInt(st.nextToken());
			}
			
			sb.append(getMaxSumSubArray(nums)).append('\n');
		}
		br.close();
		
		sb.setLength(sb.length() - 1);
		System.out.print(sb);
    }
	
	private static int getMaxSumSubArray(int[] nums) {
		int totalMaxSum = nums[0];
		int newMaxSum = nums[0];
		
		for (int i = 1; i < nums.length; i++) {
			newMaxSum = Math.max(nums[i] + newMaxSum, nums[i]);
			totalMaxSum = Math.max(totalMaxSum, newMaxSum);
		}
		
		return totalMaxSum;
	}
}
