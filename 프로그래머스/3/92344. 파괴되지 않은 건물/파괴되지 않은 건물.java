class Solution {
	int[][] sum;
	int n, m;
	public int solution(int[][] board, int[][] skill) {
		int answer = 0;
		n = board.length;
		m = board[0].length;
		sum = new int[n + 1][m + 1];
		for (int[] s : skill) {
			int x1 = s[1], x2 = s[3];
			int y1 = s[2], y2 = s[4];
			int degree = (s[0] == 1 ? -1 : 1) * s[5];

			sum[x1][y1] += degree;
			sum[x1][y2 + 1] += -degree;
			sum[x2 + 1][y1] += -degree;
			sum[x2 + 1][y2 + 1] += degree;
		}
		operate();
		
		for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] + sum[i][j] > 0) answer++;
            }
        }
		return answer;
	}
	private void operate() {
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sum[i][j] += sum[i - 1][j];
			}
		}

		for (int i = 1; i < m; i++) {
			for (int j = 0; j < n; j++) {
				sum[j][i] += sum[j][i - 1];
			}
		}
	}
}