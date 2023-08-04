package 백준.d0804부분문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분문자열 {

	static String s, t;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		String str;
		while ((str = br.readLine()) != null && !str.equals("")) {
			st = new StringTokenizer(str);
			s = st.nextToken();
			t = st.nextToken();
			int count = 0;
			boolean isTrue = false;
			for (int i = 0; i < t.length(); i++) {
				if (t.charAt(i) == s.charAt(count)) {
					count++;
				}
				if (count == s.length()) {
					isTrue = true;
					break;
				}
				if (s.length() - count > t.length() - i) {
					break;
				}
			}
			if (isTrue) {
				sb.append("Yes").append('\n');
			} else {
				sb.append("No").append('\n');
			}
		}

		System.out.println(sb);
	}

}
