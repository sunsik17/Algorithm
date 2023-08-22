package 백준.d0822최소공배수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class 최소공배수{
	static int T;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int max = Math.max(a, b);
			int min = Math.min(a, b);
			for (int i = 1; i <= min; i++) {
				if ((max * i) % min == 0) {
					sb.append(max * i).append('\n');
					break;
				}
			}
		}
		System.out.println(sb);
	}
}
