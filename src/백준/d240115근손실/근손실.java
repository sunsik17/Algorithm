package 백준.d240115근손실;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 근손실 {
	static int N, K;
	static boolean[] visited;
	static int[] kits;
	static int answer = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		visited = new boolean[N];
		kits = new int[N];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			kits[i] = Integer.parseInt(st.nextToken());
		}

		dfs(500, 0);
		System.out.println(answer);
	}

	private static void dfs(int w, int count) {
		if (w < 500) {
			return;
		}

		if (count == N) {
			answer++;
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				count++;
				w = w - K + kits[i];
				dfs(w, count);
				w = w + K - kits[i];
				count--;
				visited[i] = false;
			}
		}
	}

}
