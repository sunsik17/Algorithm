package 백준.d0705풍선터뜨리기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 풍선터뜨리기 {

	static int N;
	static Deque<int[]> q = new ArrayDeque<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i < N; i++) {
			q.add(new int[]{i + 1, arr[i]});
		}

		StringBuilder sb = new StringBuilder();
		sb.append(1).append(' ');
		int idx = arr[0];
		while (!q.isEmpty()) {
			if (idx > 0) {
				for (int i = 0; i < idx - 1; i++) {
					q.add(q.poll());
				}
				int[] tmp = q.poll();
				idx = tmp[1];
				sb.append(tmp[0]).append(' ');
			} else {
				for (int i = 0; i < -idx; i++) {
					q.addFirst(q.pollLast());
				}
				int[] tmp = q.poll();
				idx = tmp[1];
				sb.append(tmp[0]).append(' ');
			}
		}
		System.out.println(sb);
	}
}
