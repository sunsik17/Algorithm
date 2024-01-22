package 프로그래머스.d240122최솟값만들기;

import java.util.Arrays;
import java.util.Collections;

class 최솟값만들기 {
	public int solution(int[] A, int[] B) {
		int answer = 0;

		Arrays.sort(A);
		Arrays.sort(B);
		int idx = B.length - 1;
		for (int i = 0; i < A.length; i++) {
			answer = answer + (A[i] * B[idx--]);
		}

		return answer;
	}
}
