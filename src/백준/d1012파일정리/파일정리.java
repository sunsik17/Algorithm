package 백준.d1012파일정리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 파일정리 {
	static int n;
	static StringBuilder sb = new StringBuilder();
	static Map<String, Integer> result = new HashMap<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			String extension = br.readLine()
				.split("\\.")[1];
			result.put(extension, result.getOrDefault(extension, 0) + 1);
		}
		List<String[]> list = new ArrayList<>();
		result.forEach(
			(k, v) -> list.add(new String[]{k, v+""})
		);
		list.sort((x, y) -> x[0].compareTo(y[0]));

		list.forEach(
			x -> sb.append(x[0]).append(' ').append(x[1]).append('\n')
		);

		System.out.println(sb);
	}

}
