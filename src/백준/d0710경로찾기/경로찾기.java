package 백준.d0710경로찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 경로찾기 {

	static List<List<Integer>> G = new ArrayList<>();
	static boolean[] visited;
	static int N;
	static Queue<Integer> q = new LinkedList<>();
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i <= N; i++) {
			G.add(new ArrayList<>());
		}
		StringTokenizer st;
		int count = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				count++;
				if (Integer.parseInt(st.nextToken()) == 1) {
					G.get(i + 1).add(count);
				}
			}
			count = 0;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			sb.append(bfs(i)).append('\n');
		}
		System.out.println(sb);
	}
	private static String bfs(int num) {
		visited = new boolean[N + 1];
		q.add(num);
		int[] arr = new int[N];

		while (!q.isEmpty()) {
			int cur = q.poll();

			List<Integer> adj = G.get(cur);
			for (Integer integer : adj) {
				if (!visited[integer]) {
					visited[integer] = true;
					q.add(integer);
					arr[integer - 1] = 1;
				}
			}
		}
		return Arrays.toString(arr)
			.replace("[", "")
			.replace("]", "")
			.replace(",", "");
	}
}
