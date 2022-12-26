package Security.WriteupNhungNoSapSinh;

import java.util.Arrays;
import java.util.Scanner;

public class bai28 {
    
    static Scanner scanner = new Scanner(System.in);
    static Boolean[] isPrime;

    public static long power(long a, long k,long n) {
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

    private static int extend_Euclide(int e, int epN) {
        int x2 = 1, x1 = 0, y2 = 0, y1 = 1;
        int a = e,b = epN;
        while (b > 0) {
            // 𝑞 ← 𝑎/𝑏 , 𝑟 ← 𝑎 − 𝑞𝑏, 𝑥 ← 𝑥2 − 𝑞𝑥1 , 𝑦 ← 𝑦2 − 𝑞𝑦1
            int q = a / b;
            int r = a % b;
            int x = x2 - q * x1;
            int y = y2 - q * y1;
            // 𝑎 ← 𝑏, 𝑏 ← 𝑟, 𝑥2 ← 𝑥1 , 𝑥1 ← 𝑥, 𝑦2 ← 𝑦1 , 𝑦1 ← 𝑦
            a = b;
            b = r;
            x2 = x1;
            x1 = x;
            y2 = y1;
            y1 = y;
        }

        // truong hop x2 nho hon 0 cong voi b den khi duong thi thoi
        return a;
    }

    public static void Eratosthenes(int n, Boolean[] isPrime) {
        Arrays.fill(isPrime, true);
        isPrime[1] = false;
        isPrime[0] = false;
        for (int i = 2; i*i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i*i; j <= n; j += i) {
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
            if (extend_Euclide(i, n) == 1) {
                if (power(i, n - 1, n) != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("nhap so N : ");
        int N = scanner.nextInt();
        int flag = 0;
        isPrime = new Boolean[N + 1];
        if (N < 2) {
            System.out.println("khong ton tai");
            return;
        }
        Eratosthenes(N, isPrime);
        for (int i = 3; i <= N; i+=2) {
            if (isCarmichael(i)) {
                System.out.println("i = " + i);
                flag = 1;
            }
        }
        if (flag == 0) {
            System.out.println("khong ton tai so trong khoang nay");
        }
    }
}
