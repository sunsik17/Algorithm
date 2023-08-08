package 백준.d0808아이폰9S;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class 아이폰9S {

	static int N;
	static int[] person;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		person = new int[N];
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < N; i++) {
			person[i] = Integer.parseInt(br.readLine());
			set.add(person[i]);
		}
		int result = 1;
		for (int tmp : set) {
			int count = 1;
			int p = person[0];
			for (int i = 1; i < person.length; i++) {
				if (person[i] == tmp) continue;
				if (p != person[i]) count = 1;
				else {
					count++;
					result = Math.max(result, count);
				}

				p = person[i];
			}
		}
		System.out.println(set.size() == 1 ? 0 : result);
	}
}
