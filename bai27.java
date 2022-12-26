package Security.WriteupNhungNoSapSinh;

import java.util.Arrays;
import java.util.Scanner;

public class bai27 {

    static Boolean[] isPrime = new Boolean[1000 + 1];
    static Scanner scanner = new Scanner(System.in);

    public static void Eratosthenes() {
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i * i <= 1000; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= 1000; j += i) {
                    isPrime[j] = false;
                }
            }
        }
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

    public static void main(String[] args) {
        Eratosthenes();
        int a, b;

        // a = scanner.nextInt();
        // b = scanner.nextInt();
        a = 1;
        b = 1000;
        for (int i = a; i <= b; i++) {
            for (int j = a; j <= b; j++) {
                int uc = extend_Euclide(i, j);
                if (isPrime[uc]) {
                    System.out.println("the (a, b) : (" + i + " , " + j + ")  : gcd = " + uc);
                }
            }
        }
    }
}
