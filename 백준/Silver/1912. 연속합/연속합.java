import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	private static int[] nums;
	private static Integer[] memo;
	
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		nums = new int[n];
		memo = new Integer[n];
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		st = null;
		br.close();
		
		int maxSum = nums[0];
		for (int i = 0; i < n; i++) {
			maxSum = Math.max(maxSum, getMaxSumOfSubArray(i));
		}
		System.out.print(maxSum);
    }
	
	private static int getMaxSumOfSubArray(int i) {
		if (i == 0) return nums[0];
		if (memo[i] != null) return memo[i];
		memo[i] = Math.max(nums[i], nums[i] + getMaxSumOfSubArray(i-1));
		return memo[i];
	}
}
