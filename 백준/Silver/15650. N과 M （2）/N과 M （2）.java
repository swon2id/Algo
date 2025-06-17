import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
1. 아이디어
- 백트래킹 재귀함수 안에서, for 돌면서 숫자 선택 (이 때 방문여부 확인)
- 종료 조건: M개를 선택할 경우

2. 시간복잡도
- N! (N이 10 이하 정도면 보통 OK, N^N이면 N이 8이하 정도면 보통 OK)

3. 자료구조
- 결과 값 저장 int[]
- 방문여부 체크 bool[]
*/

public class Main {
	static int[] nums;
	static boolean[] visited;
	static StringBuilder answer = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		br.close();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		nums = new int[M];
		visited = new boolean[N+1];
		
		recur(0, N);
		answer.setLength(answer.length() - 1);
		System.out.print(answer);
	}
	
	static void recur(int index, int N) {
		if (index == nums.length) {
			answer.append(intArrToStr(nums, " ")).append("\n");
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				if (index == 0 || nums[index-1] < i) {
					visited[i] = true;
					nums[index] = i;
					recur(index+1, N);
					visited[i] = false;
				}
			}
		}
	}
	
	static String intArrToStr(int[] nums, String sep) {
		StringBuilder sb = new StringBuilder();
		for (int e: nums) {
			sb.append(e).append(sep);
		}
		
		sb.setLength(sb.length() - 1);
		return sb.toString();
		
		// return Arrays.stream(nums)
		//					.mapToObj(String::valueOf)
		//					.collect(Collectors.joining(" "));
	}
}
