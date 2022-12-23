package Security;

import java.util.Arrays;
import java.util.Scanner;

public class bai29 {
    static Scanner scanner = new Scanner(System.in);
    static Boolean[] isPrime;

    public static long power(long a, long k, long n) {
        long b = 1;
        a = a % n;
        while (k > 0) {
            if (k % 2 == 1) {
                b = (b * a) % n;
            }
            k = k / 2;
            a = (a * a) % n;
        }
        return b;
    }

    public static int gcd(int a, int b) {
        int r;
        while (b > 0) {
            r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public static void Eratosthenes(int n, Boolean[] isPrime) {
        Arrays.fill(isPrime, true);
        isPrime[1] = false;
        isPrime[0] = false;
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }

    public static Boolean isCarmichael(int n) {
        if (isPrime[n] || n < 2) {
            return false;
        }
        for (int i = 2; i < n; i++) {
            if (gcd(i, n) == 1) {
                if (power(i, n - 1, n) != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int N = scanner.nextInt();
        int sum = 0;
        isPrime = new Boolean[N + 1];
        if (N < 2) {
            System.out.println("khong ton tai");
            return;
        }
        Eratosthenes(N, isPrime);
        for (int i = 3; i <= N; i += 2) {
            if (isCarmichael(i)) {
                sum += 1;
            }
        }

        System.out.println("co " + sum + " so carmichael nho hon " + N);

    }
}
