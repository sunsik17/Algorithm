package 백준.d0623좌표압축;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 좌표압축 {

	static int N;
	static List<Number> nums = new ArrayList<>();
	static class Number {
		int num;
		int idx;
		int count;
		public Number(int num, int idx, int count) {
			this.num = num;
			this.idx = idx;
			this.count = count;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums.add(new Number(Integer.parseInt(st.nextToken()), i, 0));
		}
		nums.sort((x, y) -> x.num - y.num);
		int count = 0;
		for (int i = 1; i < N; i++) {
			Number n = nums.get(i - 1);
			Number n2 = nums.get(i);
			if (n2.num > n.num) {
				n2.count = ++count;
			} else if (n2.num == n.num) {
				n2.count = n.count;
			}
		}
		nums.sort((x, y) -> x.idx - y.idx);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			if (i == N - 1) {
				sb.append(nums.get(i).count);
			} else {
				sb.append(nums.get(i).count).append(" ");
			}
		}
		System.out.println(sb);
	}

}
