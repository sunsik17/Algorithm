import java.util.Scanner;

public class Z {

    static int z (int n, int i, int j) {
        return zAll(0, (int) Math.pow(2,n), i, j);
    }

    static int zAll(int count, int n, int i, int j) {

        if (n == 2) {
            if (i == 0 && j == 0) {
                return count;
            } else if (i == 0 & j == 1) {
                return count + 1;
            } else if (i == 1 & j == 0) {
                return count + 2;
            } else {
                return count + 3;
            }
        }

        int m = n / 2;
        if (i < m && j < m) {
            return zAll(count, m, i, j);
        } else if (i < m & j >= m) {
            count += m * m;
            return zAll(count, m, i, j - m);
        } else if (i >= m & j < m) {
            count += m * m * 2;
            return zAll(count, m, i - m, j);
        } else {
            count += m * m * 3;
            return zAll(count, m, i - m, j - m);
        }
    }

    static int n,i,j,m;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        i = sc.nextInt();
        j = sc.nextInt();

        System.out.println(z(n,i,j));
    }
}
