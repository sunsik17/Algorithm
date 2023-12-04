class 정수삼각형 {
    
	public int solution(int[][] triangle) {
		int answer = 0;
        
		for (int i = 1; i < triangle.length; i++) {
            int w = triangle[i].length;
			for (int j = 0; j < w; j++) {
				if(j == 0) {
					triangle[i][j] += triangle[i - 1][j];	
				} else if(j == i) {
					triangle[i][j] += triangle[i - 1][j - 1];
				} else {
                    triangle[i][j] += Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]);
                }
			}
		}
        int h = triangle.length - 1;
		for (int i = 0; i < triangle[h].length; i++) {
			answer = Math.max(answer, triangle[h][i]);
		}
		return answer;
	}
}
