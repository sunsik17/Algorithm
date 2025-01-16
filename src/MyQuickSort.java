import java.util.Arrays;

class MyQuickSort {
	public void quickSort(int[] arr, int left, int right) {
		if (left >= right) return;

		int pivot = partition(arr, left, right);

		quickSort(arr, left, pivot - 1);
		quickSort(arr, pivot + 1, right);
	}

	private int partition(int[] arr, int left, int right) {
		int pivot = arr[left];
		int i = left;
		int j = right;

		while (i < j) {
			while (arr[j] > pivot && i < j) j--;
			while (arr[i] <= pivot && i < j) i++;

			swap(arr, i, j);
		}
		swap(arr, left, i);

		return i;
	}

	private void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	public static void main(String[] args) {
		int[] arr = new int[]{12, 2, 4, 25, 20, 1, 2, 3};
		MyQuickSort sort = new MyQuickSort();
		sort.quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}
}