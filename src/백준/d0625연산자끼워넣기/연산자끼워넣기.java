package 백준.d0625연산자끼워넣기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연산자끼워넣기 {

	static int N;
	static int[] nums, arr;
	static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		arr = new int[4];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < 4; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		dfs(1, nums[0]);
		System.out.println(max + "\n" + min);
	}
	private static void dfs(int count, int sum) {
		if (count == N) {
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (arr[i] > 0) {
				arr[i]--;
				switch (i) {
					case 0 : dfs(count + 1, sum + nums[count]);
					break;
					case 1 : dfs(count + 1, sum - nums[count]);
					break;
					case 2 : dfs(count + 1, sum * nums[count]);
					break;
					case 3 : dfs(count + 1, sum / nums[count]);
					break;
				}
				arr[i]++;
			}
		}
	}

}
