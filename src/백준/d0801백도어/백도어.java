package 백준.d0801백도어;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 백도어 {
	static int s = 0, e;
	static int N, M;
	static long[] dist;
	static List<List<Node>> graph = new ArrayList<>();
	static PriorityQueue<Node> pq = new PriorityQueue<>((x,y) -> Math.toIntExact(
		x.weight - y.weight));
	static int[] zo;

	static class Node {
		int to;
		long weight;

		public Node(int to, long weight) {
			this.to = to;
			this.weight = weight;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		e = N - 1;
		zo = new int[N + 1];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			graph.add(new ArrayList<>());
			zo[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int u = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph.get(v).add(new Node(u, w));
			graph.get(u).add(new Node(v, w));
		}
		dist = new long[N];
		Arrays.fill(dist, Long.MAX_VALUE);
		if (zo[s] == 1) {
			System.out.println(-1);
			return;
		}
		dijkstra();
		if (dist[e] == Long.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(dist[e]);
		}
	}

	static void dijkstra() {
		dist[s] = 0;
		pq.add(new Node(s, 0));

		while (!pq.isEmpty()) {
			Node curNode = pq.poll();

			if (dist[curNode.to] < curNode.weight) continue;

			List<Node> nodes = graph.get(curNode.to);

			for (Node adjNode : nodes) {

				if (dist[adjNode.to] > adjNode.weight + curNode.weight && (zo[adjNode.to] == 0 || adjNode.to == N - 1)) {
					dist[adjNode.to] = adjNode.weight + curNode.weight;
					pq.add(new Node(adjNode.to, dist[adjNode.to]));
				}
			}
		}
	}
}
