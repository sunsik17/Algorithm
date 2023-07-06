package 백준.d0706스택수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 스택수열 {
	static Stack<Integer> stack = new Stack<>();
	static int[] nums;
	static int n;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}

		int idx = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			stack.add(i);
			sb.append('+').append('\n');
			while (!stack.isEmpty() && idx < n && nums[idx] == stack.peek()) {
				stack.pop();
				sb.append('-').append('\n');
				idx++;
			}
		}
		if (idx == n) {
			System.out.println(sb);
		} else {
			System.out.println("NO");
		}
	}
}
