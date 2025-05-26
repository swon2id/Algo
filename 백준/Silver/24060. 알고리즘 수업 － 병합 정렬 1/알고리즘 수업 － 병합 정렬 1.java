import java.io.*;
import java.util.StringTokenizer;

public class Main{
	private static long currSortCount;
	private static long targetSortCount;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] iArr = new int[Integer.parseInt(st.nextToken())];
		targetSortCount = Long.parseLong(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < iArr.length; i++) {
			iArr[i] = Integer.parseInt(st.nextToken());
		}
		
		br.close();
		mergeSort(iArr, 0, iArr.length - 1);
		System.out.print(-1);
	}
	
	private static void mergeSort(int[] arr, int l, int r) {
		if (l < r) {
			int mid = (l + r) / 2;
			mergeSort(arr, l, mid);
			mergeSort(arr, mid+1, r);
			merge(arr, l, mid, r);
		}
	}
	
	private static void merge(int[] arr, int l, int mid, int r) {
		int k = l;
		
		int[] leftArr = new int[mid + 1 - l];
		int[] rightArr = new int[r - mid];
		for (int i = 0; i < leftArr.length; i++) {
			leftArr[i] = arr[l + i];
		}
		
		for (int j = 0; j < rightArr.length; j++) {
			rightArr[j] = arr[mid + 1 + j];
		}
		
		
		int i = 0, j = 0;
		while(i < leftArr.length && j < rightArr.length) {
			if (leftArr[i] <= rightArr[j]) {
				arr[k++] = leftArr[i++];
			} else if (rightArr[j] < leftArr[i]) {
				arr[k++] = rightArr[j++];
			}			
			checkEndCondition(arr, k);
		}
		
		while(i < leftArr.length) {
			arr[k++] = leftArr[i++];
			checkEndCondition(arr, k);
		}
		
		while(j < rightArr.length) {
			arr[k++] = rightArr[j++];
			checkEndCondition(arr, k);
		}
	}
	
	private static void checkEndCondition(int[] arr, int k) {
		if (++currSortCount == targetSortCount) {
			System.out.print(arr[k-1]);
			System.exit(0);
		}
	}
}
