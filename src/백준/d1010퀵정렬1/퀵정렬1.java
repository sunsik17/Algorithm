package 백준.d1010퀵정렬1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 퀵정렬1 {
	static int answer, n, k;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		long start = System.currentTimeMillis();
		quickSort(arr, 0, n - 1);
		System.out.println(System.currentTimeMillis() - start);

		System.out.println(Arrays.toString(arr));
	}

	static void quickSort(int[] arr, int left, int right) {
		if (left >= right) return;

		int pivot = partition(arr, left, right);

		quickSort(arr, left, pivot - 1);
		quickSort(arr, pivot + 1, right);
	}

	static int partition(int[] arr, int left, int right) {
		int pivot = arr[left];
		int i = left;
		int j = right;

		while (i < j) {
			while (arr[j] > pivot && i < j) j--;
			while (arr[i] <= pivot && i < j) i++;

			if (i == j) break;
			swap(arr, i, j);
		}
		if (left == i) return left;
		swap(arr, left, i);
		return i;
	}

	static void swap(int[] arr, int i, int j) {
		answer++;
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;

		System.out.println("answer = : " + answer + " & " + i + " " +j);
	}
}
