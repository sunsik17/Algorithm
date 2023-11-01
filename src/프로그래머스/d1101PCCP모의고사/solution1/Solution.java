package 프로그래머스.d1101PCCP모의고사.solution1;

public class Solution {
	final int[] dx = {0, 1, 0, -1};
	final int[] dy = {1, 0, -1, 0};
	int v = 0;
	public int[] solution(String command) {

		final char[] RLGB = command.toCharArray();
		int[] cur = {0, 0};
		int finalX;
		int finalY;
		for(char c : RLGB) {
			if (c == 'R') {
				v++;
				continue;
			}
			if (c == 'L') {
				v--;
				continue;
			}
			if (c == 'G') {
				finalX = cur[0] + dx[v];
				finalY = cur[1] + dy[v];
				cur = new int[]{finalX, finalY};
				continue;
			}
			if (c == 'B') {
				finalX = cur[0] - dx[v];
				finalY = cur[1] - dy[v];
				cur = new int[]{finalX, finalY};
			}
		}

		return cur;
	}

}
