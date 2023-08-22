package 백준.d0822이모티콘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class 이모티콘 {
	static int S;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		S = Integer.parseInt(br.readLine());

		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[2000][2000];
		q.add(new int[]{1, 0, 0, 0});

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			int emojiCount = cur[0];
			int isCopy = cur[1];
			int copyCount = cur[2];
			int sec = cur[3];

			if (emojiCount == S) {
				System.out.println(sec);
				return;
			}

			int cnt = emojiCount + copyCount;
			if (cnt < 2000 && isCopy == 1 && !visited[cnt][copyCount]) {
				q.add(new int[]{cnt, 1, copyCount, sec + 1});
				visited[cnt][copyCount] = true;
			}

			cnt = emojiCount - 1;
			if (cnt >= 0 && !visited[cnt][copyCount]) {
				q.add(new int[]{cnt, isCopy, copyCount, sec + 1});
				visited[cnt][copyCount] = true;
			}

			if (emojiCount * 2 < 2000 && !visited[emojiCount][emojiCount]) {
				q.add(new int[]{emojiCount, 1, emojiCount, sec + 1});
				visited[emojiCount][emojiCount] = true;
			}
		}
	}
}

