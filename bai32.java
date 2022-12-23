package Security;

import java.util.Scanner;

public class bai32 {

    static Scanner scanner = new Scanner(System.in);

    public static long power(long a,long k,long n) {
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

    public static int gcd(int a, int b) {
        int r;
        while (b > 0) {
            r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public static Boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n == 2 || n == 3) {
            return true;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }

        for (int i = 5; i <= Math.sqrt(n); i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
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
        while (x2 < 0) {
            x2 = x2 + epN;
        }

        return x2;
    }

    public static Boolean kiemTraSoNguyenToCungNhau(int n,int e) {
        if (gcd(n, e) == 1) {
            return true;
        }else{
            return false;
        }
    }

    public static long encryption(int m,int e,int n) {
        System.out.println("encryotion RSA  m = " + m  + " ,e = " + e +" n = " + n);
        long c = power(m, e, n);
        System.out.println("encryption : c = " + c);
        return c;
    }

    public static void decryption(int c,int d,int n) {
        System.out.println("decryotion RSA  c = " + c  + " ,d = " + d +" n = " + n);
        System.out.println("decryption : m = " + power(c, d, n));
        
    }

    public static void main(String[] args) {
        int p,q,SBD;
        // nhap p
        // do {
        //     System.out.println("nhap so p thoa man q > 100 va la so nguyen to : ");
        //     p = scanner.nextInt();
        // } while (isPrime(p));
        System.out.println("nhap so p : ");
        p = scanner.nextInt();
        while (!isPrime(p)) {
            System.out.println("nhap so p thoa man q > 100 va la so nguyen to : ");
            p = scanner.nextInt();
        }

        System.out.println("nhap so q : ");
        q = scanner.nextInt();
        while (!isPrime(q)) {
            System.out.println("nhap so q thoa man q < 500 va la so nguyen to : ");
            q = scanner.nextInt();
        }

        int N = p*q;
        int epN = (p - 1) * (q - 1);

        // nhap e
        System.out.println("nhap so e : ");
        int e = scanner.nextInt();
        while (!kiemTraSoNguyenToCungNhau(e, epN)) {
            System.out.println("nhap lai so e : ");
            e = scanner.nextInt();
        }

        int d = extend_Euclide(e, epN);

        System.out.println(" nhap SBD : ");
        SBD = scanner.nextInt();
        int m = SBD;

        // tien hanh ma koa 
        System.out.println("---------------------------------");
        int c = (int) encryption(m, e, N);
        System.out.println("---------------------------------");
        decryption(c, d, N);

    }
}
