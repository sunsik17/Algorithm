public class MyStack {
	private int size;
	private int[] stack;
	private int top;
	public MyStack(int size) {
		this.size = size;
		stack = new int[size];
		top = -1;
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public boolean isFull() {
		return top == size - 1;
	}

	public int pop(){
		if (isEmpty()){
			System.out.println("error");
			return 0;
		}
		int result = stack[top];
		stack[top--] = 0;
		return result;
	}

	public void push(int element) {
		if (isFull()) {
			System.out.println("error");
			return;
		}
		stack[++top] = element;
	}

	public int size() {
		return top;
	}

	public int peek() {
		return stack[top];
	}

	public void fun() {
		var x = 1;
		var y = 4;
		if (true) {
			var x = 4;
			y = 3;
		}
	}

	public static void main(String[] args) {

	}
}
