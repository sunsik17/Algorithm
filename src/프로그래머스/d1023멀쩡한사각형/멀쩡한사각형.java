class 멀쩡한사각형 {
    public long solution(int w, int h) {
        long answer = 1;

        int gcd = gcd(w, h);

        return (long) h * w - (w + h - gcd);
    }
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
