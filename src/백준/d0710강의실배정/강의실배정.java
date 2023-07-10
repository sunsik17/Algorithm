package 백준.d0710강의실배정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 강의실배정 {
	static PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[1] - y[1]);
	static List<int[]> arr = new ArrayList<>();
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
		}
		arr.sort((x, y) -> x[0] == y[0] ? x[1] - y[1] : x[0] - y[0]);
		int result = 0;
		for (int[] time : arr) {
			if (!pq.isEmpty() && time[0] >= pq.peek()[1]) {
				pq.poll();
			}
			pq.add(time);
			result = Math.max(pq.size(), result);
		}
		System.out.println(result);
	}
}
