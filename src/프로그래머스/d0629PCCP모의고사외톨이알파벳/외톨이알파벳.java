package 프로그래머스.d0629PCCP모의고사외톨이알파벳;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class 외톨이알파벳 {

	Map<Character, Integer> charsMap = new HashMap<>();
	public String solution(String input_string) {
		String answer = "";
		charsMap.put(input_string.charAt(input_string.length() - 1), 1);
		charsMap.put(input_string.charAt(input_string.length() - 2), 1);

		for (int i = 0; i < input_string.length() - 2; i++) {
			char c = input_string.charAt(i);
			if(c == input_string.charAt(i + 1)) {
				continue;
			}
			charsMap.put(c, charsMap.getOrDefault(c, 0) + 1);
		}
		List<Character> res = new ArrayList<>();
		for (char c : charsMap.keySet()) {
			if(charsMap.get(c) > 1) {
				res.add(c);
			}
		}
		res.sort((x, y) -> x - y);
		answer = res.toString().replace("[", "").replace("]", "").replace(", ", "");
		return answer.length() == 0 ? "N" : answer;
	}

	public static void main(String[] args) {
		System.out.println(new 외톨이알파벳().solution("zbzbz"));
	}
}
