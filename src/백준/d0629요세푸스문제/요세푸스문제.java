package 백준.d0629요세푸스문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 요세푸스문제 {

	static int N, K;
	static Queue<Integer> nums = new LinkedList<>();
	static int[] res;

	/**
	 *	N = 7
	 *	K = 3
	 *  1, 2, 3, 4, 5, 6, 7
	 *  ans = 3, 6, 2, 6, 5, 1, 4
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		res = new int[N];

		for (int i = 1; i <= N; i++) {
			nums.add(i);
		}
		int idx = 0;
		while (!nums.isEmpty()) {
			int num;
			for (int i = 0; i < K - 1; i++) {
				num = nums.poll();
				nums.add(num);
			}
			res[idx++] = nums.poll();
		}
		System.out.println(Arrays.toString(res).replace("[", "<").replace("]", ">"));
	}
}