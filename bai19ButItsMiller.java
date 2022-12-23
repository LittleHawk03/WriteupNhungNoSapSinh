package Security.WriteupNhungNoSapSinh;

import java.util.Scanner;

public class bai19ButItsMiller {
    static Scanner scanner = new Scanner(System.in);

    public static long square_loop(long a,long k,long n) {
        long b = 1;
        a = a % n;
        while (k > 0) {
            if (k % 2 == 1) {
                b = (b * a) % n;
            }
            k = k / 2;
            a = (a*a) % n;
        }
        return b;
    }

    public static Boolean millerRabin(long r,long n) {
        long min = 2,max = n -2;
        long a = (long) Math.floor(Math.random() * (max - min + 1) + min);
        long x = (long) square_loop(a, r, n);
        if (x == 1 || x == n -1) {
            return true;
        }
        while (r != n -1) {
            x = (x * x) % n;
            r = r * 2;

            if (x == 1) {
                return false;
            }
            if (x == n - 1){
                return true;
            }
        }
        return false;
    }

    public static Boolean isPrime(long n ,long k) {
        if (n <= 1 || n == 4) {
            return false;
        }
        if (n <= 3) {
            return true;
        }

        long r = n - 1;
        while (r % 2 == 0) {
            r = r / 2;
        }

        while (k > 0) {
            if (!millerRabin(r, n)) {
                return false;
            }
            k--;
        }
        return true;
    }

    public static void main(String[] args) {
        long A, B, C, l, m, k = 5;
        System.out.println("nhap A : ");
        A = scanner.nextLong();
        System.out.println("nhap B : ");
        B = scanner.nextLong();
        System.out.println("nhap C : ");
        C = scanner.nextLong();
        System.out.println("nhap m : ");
        m = scanner.nextLong();
        System.out.println("nhap l : ");
        l = scanner.nextLong();

        for (long i = m; i < l; i++) {
            long ra = A * i * i + B * i + C;
            if (isPrime(ra, k)) {
                System.out.println(
                        i + " la gia tri de thoa man bieu thuc 𝐴𝑥^2 + 𝐵𝑥 + 𝐶 là một số nguyên tố  = " + ra);
            }
            if (!isPrime(ra , k) && i == l - 1) {
                System.out.println("ko co gia tri thoa man");
            }
        }
    }
}