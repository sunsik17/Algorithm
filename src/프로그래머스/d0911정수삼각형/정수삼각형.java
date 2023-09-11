package 프로그래머스.d0911정수삼각형;

class 정수삼각형 {

	int[][] sum;
	public int solution(int[][] triangle) {
		int answer = 0;
		sum = triangle;
		sum[0][0] = triangle[0][0];

		for (int i = 1; i < triangle.length; i++) {
			for (int j = 0; j < triangle[i].length; j++) {
				if(j == 0) {
					sum[i][j] = sum[i - 1][j] + triangle[i][j];
					continue;
				}
				if(j == i) {
					sum[i][j] = sum[i - 1][j - 1] + triangle[i][j];
					continue;
				}
				sum[i][j] = Math.max(sum[i - 1][j - 1], sum[i - 1][j]) + triangle[i][j];
			}
		}
		for (int i = 0; i < triangle[triangle.length - 1].length; i++) {
			answer = Math.max(answer, sum[triangle.length - 1][i]);
		}
		return answer;
	}
}
