package 백준.d0629요세푸스문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 요세푸스문제풀이2 {
	static int[] res;
	static List<Integer> nums = new ArrayList<>();
	static int N, K;

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
		int idx2 = 0;
		while (!nums.isEmpty()) {
			idx += K - 1;
			idx %= nums.size();
			res[idx2++] = nums.remove(idx);
		}
		System.out.println(Arrays.toString(res).replace("[", "<").replace("]", ">"));
	}
}
