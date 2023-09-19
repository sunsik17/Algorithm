package 백준.d0919오셀로재배치;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 오셀로재배치 {

	static int T;
	static char B = 'B', W = 'W';

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			char[] init = br.readLine().toCharArray();
			char[] goal = br.readLine().toCharArray();
			int answer = 0;
			int bCnt = 0;
			int wCnt = 0;
			for (int i = 0; i < N; i++) {
				if (init[i] != goal[i]) {
					if (init[i] == B) bCnt++;
					else wCnt++;
				}
			}
			sb.append(Math.max(wCnt, bCnt)).append('\n');
		}
		System.out.println(sb);
	}

}
