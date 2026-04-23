import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;

class Solution {
	public int solution(int[] ingredient) {
		Deque<Integer> stack = new ArrayDeque<>();
		int answer = 0;
		int[] pattern = {1, 2, 3, 1};

		for (int item : ingredient) {
			stack.push(item);
			if (stack.size() >= 4) {
				Iterator<Integer> iter = stack.iterator();
				int[] top4 = new int[4];
				for (int i = 3; i >= 0; i--) {
					top4[i] = iter.next();
				}

				if (Arrays.equals(top4, pattern)) {
					for (int i = 0; i < 4; i++) stack.pop();
					answer++;
				}
			}
		}

		return answer;
	}
	
}
