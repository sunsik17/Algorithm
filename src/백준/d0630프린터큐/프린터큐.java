package 백준.d0630프린터큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 프린터큐 {

	static int T;
	static int[] N = new int[2];
	static StringBuilder sb = new StringBuilder();
	static PriorityQueue<int[]> pq;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N[0] = Integer.parseInt(st.nextToken());
			N[1] = Integer.parseInt(st.nextToken());//{총 문서갯수, 내가출력해야할 문서 인덱스}
			st = new StringTokenizer(br.readLine());
			LinkedList<int[]> q = new LinkedList<>();
			for (int i = 0; i < N[0]; i++) {
				int[] tmp = new int[]{i, Integer.parseInt(st.nextToken())};
				q.add(tmp); //{인덱스, 중요도}
			}
			int count = 0;
			while (!q.isEmpty()) {
				int[] tmp = q.poll();
				boolean isValid = true;
				for (int i = 0; i < q.size(); i++) {
					if (tmp[1] < q.get(i)[1]) {
						q.add(tmp);
						for (int j = 0; j < i; j++) {
							q.add(q.poll());
						}
						isValid = false;
						break;
					}
				}
				if (!isValid) {
					continue;
				}
				count++;
				if (tmp[0] == N[1]) {
					break;
				}
			}
			sb.append(count).append('\n');
		}
		System.out.println(sb);
	}
}