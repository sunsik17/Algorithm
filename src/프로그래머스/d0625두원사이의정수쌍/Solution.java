package 프로그래머스.d0625두원사이의정수쌍;

class Solution {
	public long solution(int r1, int r2) {
		long answer = 0;

		for (int i=1; i<=r2; i++) {
			long minJ = (int) Math.ceil(Math.sqrt(Math.pow(r1, 2) - Math.pow(i, 2)));
			long maxJ = (int) Math.floor(Math.sqrt(Math.pow(r2, 2) - Math.pow(i, 2)));

			answer += (maxJ - minJ + 1);
		}

		return answer * 4;
	}
}
