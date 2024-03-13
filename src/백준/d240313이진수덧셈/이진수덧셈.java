package 백준.d240313이진수덧셈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 이진수덧셈 {

	static int T;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder answer = new StringBuilder();
		Stack<Integer> stack;
		boolean isOver = false;

		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			String[] a = st.nextToken().split("");
			String[] b = st.nextToken().split("");
			StringBuilder sb = new StringBuilder();
			stack = new Stack<>();

			int aLen = a.length - 1;
			int bLen = b.length - 1;

			while (aLen >= 0 && bLen >= 0) {
				int i = Integer.parseInt(a[aLen--]);
				int j = Integer.parseInt(b[bLen--]);

				int result = i + j;

				if (isOver) {
					result += 1;
					if (result < 2) {
						isOver = false;
					}
				}

				if (result > 1) {
					isOver = true;
					result -= 2;
				}
				stack.add(result);
			}

			while (aLen >= 0) {
				int i = Integer.parseInt(a[aLen--]);
				if (isOver) {
					i += 1;
					if (i < 2) {
						isOver = false;
					}
				}
				if (isOver) {
					i -= 2;
				}
				stack.add(i);
			}

			while (bLen >= 0) {
				int i = Integer.parseInt(b[bLen--]);
				if (isOver) {
					i += 1;
					if (i < 2) {
						isOver = false;
					}
				}
				if (isOver) {
					i -= 2;
				}
				stack.add(i);
			}
			if (isOver) {
				stack.add(1);
				isOver = false;
			}
			while (!stack.isEmpty() && stack.peek() == 0) {
				stack.pop();
			}
			if (stack.isEmpty()) {
				answer.append('0').append('\n');
				continue;
			}
			while (!stack.isEmpty()) {
				sb.append(stack.pop());
			}
			answer.append(sb).append('\n');

		}
		System.out.println(answer);
	}

}