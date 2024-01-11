package 백준.d240111이중우선순위큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class 이중우선순위큐 {

	static int T;
	static TreeMap<Integer, Integer> treeMap;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		StringBuilder result = new StringBuilder();
		while (T-- > 0) {
			treeMap = new TreeMap<>();
			int oc = Integer.parseInt(br.readLine());
			StringTokenizer st;
			while (oc-- > 0) {
				st = new StringTokenizer(br.readLine());
				String op = st.nextToken();
				int num = Integer.parseInt(st.nextToken());
				if (op.equals("I")) {
					treeMap.put(num, treeMap.getOrDefault(num, 0) + 1);
					continue;
				}

				if (!treeMap.isEmpty()) {
					int key = num == 1 ? treeMap.lastKey() : treeMap.firstKey();
					int val = treeMap.get(key);

					if (val == 1) {
						treeMap.remove(key);
					} else {
						treeMap.put(key, val - 1);
					}
				}
			}
			if (treeMap.isEmpty()) {
				result.append("EMPTY").append("\n");
			} else {
				result
					.append(treeMap.lastKey())
					.append(" ")
					.append(treeMap.firstKey())
					.append("\n");
			}
		}
		System.out.println(result);
	}

}
