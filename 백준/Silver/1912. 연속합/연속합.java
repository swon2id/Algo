import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		st = null;
		br.close();
		
		System.out.print(getMaxSumOfSubArray(nums));
    }
	
	private static int getMaxSumOfSubArray(int[] nums) {
		int newSum = nums[0];
		int maxSum = newSum;
		
		for (int i = 1; i < nums.length; i++) {
			newSum = Math.max(nums[i], nums[i] + newSum);
			maxSum = Math.max(newSum, maxSum);
		}
		
		return maxSum;
	}
}
