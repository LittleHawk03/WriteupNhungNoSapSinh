package Security.WriteupNhungNoSapSinh;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class bai32 {

    static Scanner scanner = new Scanner(System.in);
    static long[] list_frime = { 101, 103, 107, 109, 113, 127,
            131, 137, 139, 149, 151, 157, 163, 167,
            173, 179, 181, 191, 193, 197, 199, 211,
            223, 227, 229, 233, 239, 241, 251, 257, 263,
            269, 271, 277, 281, 283, 293, 307, 311, 313,
            317, 331, 337, 347, 349, 353, 359, 367, 373,
            379, 383, 389, 397, 401, 409, 419, 421, 431,
            433, 439, 443, 449, 457, 461, 463, 467, 479,
            487, 491, 499 };

    public static long random_prime() {
        long rnd = new Random().nextInt(list_frime.length);
        return list_frime[(int) rnd];
    }

    public static long random_e(long epN) {
        long min = 2, max = epN;
        return ThreadLocalRandom.current().nextLong(min, max);
    }

    public static long power(long a, long k, long n) {
        long b = 1;
        a = a % n;
        while (k > 0) {
            if (k % 2 == 1) {
                b = (b * a) % n;
            }
            k = k >> 1;
            a = (a * a) % n;
        }
        return b;
    }

    private static long gcd(long e, long epN) {
        long x2 = 1, x1 = 0, y2 = 0, y1 = 1;
        long a = e, b = epN;
        while (b > 0) {
            // 𝑞 ← 𝑎/𝑏 , 𝑟 ← 𝑎 − 𝑞𝑏, 𝑥 ← 𝑥2 − 𝑞𝑥1 , 𝑦 ← 𝑦2 − 𝑞𝑦1
            long q = a / b;
            long r = a % b;
            long x = x2 - q * x1;
            long y = y2 - q * y1;
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

    public static long sinhSoE(long epN) {
        long n = random_e(epN);
        while (gcd(n, epN) != 1) {
            n = random_e(epN);
        }
        return n;
    }

    private static long extend_Euclide(long e, long epN) {
        long x2 = 1, x1 = 0, y2 = 0, y1 = 1;
        long a = e, b = epN;
        while (b > 0) {
            // 𝑞 ← 𝑎/𝑏 , 𝑟 ← 𝑎 − 𝑞𝑏, 𝑥 ← 𝑥2 − 𝑞𝑥1 , 𝑦 ← 𝑦2 − 𝑞𝑦1
            long q = a / b;
            long r = a % b;
            long x = x2 - q * x1;
            long y = y2 - q * y1;
            // 𝑎 ← 𝑏, 𝑏 ← 𝑟, 𝑥2 ← 𝑥1 , 𝑥1 ← 𝑥, 𝑦2 ← 𝑦1 , 𝑦1 ← 𝑦
            a = b;
            b = r;
            x2 = x1;
            x1 = x;
            y2 = y1;
            y1 = y;
        }

        // truong hop x2 nho hon 0 cong voi b den khi duong thi thoi
        while (x2 < 0) {
            x2 = x2 + epN;
        }

        return x2;
    }

    public static long encryption(long m, long e, long n) {
        System.out.println("encryotion RSA  m = " + m + " ,e = " + e + " n = " + n);
        long c = power(m, e, n);
        System.out.println("encryption : c = " + c);
        return c;
    }

    public static void decryption(long c, long d, long n) {
        System.out.println("decryotion RSA  c = " + c + " ,d = " + d + " n = " + n);
        System.out.println("decryption : m = " + power(c, d, n));

    }

    public static void main(String[] args) {
        long p, q, SBD;
        // nhap p
        // do {
        // System.out.println("nhap so p thoa man q > 100 va la so nguyen to : ");
        // p = scanner.nextInt();
        // } while (isPrime(p));
        System.out.println("sinh so p : ");
        p = random_prime();
        System.out.println("so p la : " + p);
        // while (!isPrime(p)) {
        // System.out.println("nhap so p thoa man q > 100 va la so nguyen to : ");
        // p = scanner.nextInt();
        // }

        System.out.println("sinh so q : ");
        q = random_prime();
        System.out.println("so q la : " + q);
        // while (!isPrime(q)) {
        // System.out.println("nhap so q thoa man q < 500 va la so nguyen to : ");
        // q = scanner.nextInt();
        // }

        long N = p * q;
        System.out.println("N = p * q = " + N);
        long epN = (p - 1) * (q - 1);
        System.out.println("epN = (p - 1) * (q - 1) = " + epN);

        // nhap e
        
        long e = sinhSoE(epN);
        System.out.println("sinh so e : " + e);
        // while (!kiemTraSoNguyenToCungNhau(e, epN)) {
        //     System.out.println("nhap lai so e : ");
        //     e = scanner.nextInt();
        // }

        long d = extend_Euclide(e, epN);

        System.out.println("nhap SBD : ");
        SBD = scanner.nextLong();
        long m = SBD + 123;

        // tien hanh ma koa
        System.out.println("---------------------------------");
        long c = (long) encryption(m, e, N);
        System.out.println("---------------------------------");
        decryption(c, d, N);

    }
}
