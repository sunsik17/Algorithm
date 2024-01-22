package 프로그래머스.d240122타겟넘버;

class 타겟넘버 {
	int count = 0;
	public int solution(int[] numbers, int target) {
		int answer = 0;
		dfs(numbers, target, 0, 0);
		return count;
	}
	private void dfs(int[] numbers, int target, int num, int idx) {
		if(idx == numbers.length) {
			if(num == target) {
				count++;
			}
			return;
		}
		dfs(numbers, target, num + numbers[idx], idx + 1);
		dfs(numbers, target, num - numbers[idx], idx + 1);
	}

	public static void main(String[] args) {
//		int[] numbers = {1, 1, 1, 1, 1};
//		int target = 3;
		int[] numbers = {4, 1, 2, 1};
		int target = 4;
		System.out.println(new 타겟넘버().solution(numbers, target));
	}
}