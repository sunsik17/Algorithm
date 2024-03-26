package 백준.d240321팔진수이진수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 팔진수이진수 {
	static Map<String, String> map = new HashMap<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split("");

		for (int i = 0; i <= 7; i++) {
			map.put(String.valueOf(i), String.format("%03d", Integer.parseInt(Integer.toBinaryString(i))));
		}

		StringBuilder sb = new StringBuilder();
		for (String s : tmp) {
			sb.append(map.get(s));
		}

		int idx = 0;
		String answer = sb.toString();
		while (idx < answer.length() && answer.charAt(idx) == '0') {
			idx++;
		}
		System.out.println(answer.substring(idx).equals("") ? 0 : answer.substring(idx));
	}
}

