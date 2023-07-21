package 백준.d0721여우는어떻게울지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 여우는어떻게울지 {
	static int T;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			List<String> strings = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());

			while (st.hasMoreTokens()) {
				strings.add(st.nextToken());
			}

			while (true) {
				String[] goes = br.readLine().split(" ");
				if (!goes[0].equals("fox") && !goes[0].equals("what")) {
					strings.removeAll(Collections.singleton(goes[2]));
				} else if (goes[0].equals("what")) {
					for (String str : strings) {
						sb.append(str).append(' ');
					}
					sb.deleteCharAt(sb.lastIndexOf(" "));
					sb.append('\n');
					break;
				}
			}
		}
		System.out.println(sb);
	}

}
