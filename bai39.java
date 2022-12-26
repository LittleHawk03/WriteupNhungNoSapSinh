package Security.WriteupNhungNoSapSinh;

import java.util.Scanner;

public class bai39 {
    
    static Scanner scanner = new Scanner(System.in);

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
    
    public static long square_loop(long a,long k,long n) {
        long b = 1;
        a = a % n;
        while (k > 0) {
            if (k % 2 == 1) {
                b = (b * a) % n;
            }
            k = k >> 1;
            a = (a*a) % n;
        }
        return b;
    }

    public static Boolean millerRabin(int r,int n) {
        int min = 2, max = n - 2;
        int a = (int) Math.floor(Math.random() * (max - min + 1) + min);
        int x = (int) square_loop(a, r, n);
        if (x == 1 || x == n - 1) {
            return true;
        }
        while (r != n - 1) {
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


    public static Boolean isPrime(int n ,int k) {
        if (n <= 1 || n == 4) {
            return false;
        }
        if (n <= 3) {
            return true;
        }

        int r = n - 1;
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

    public static void ScannerArray(int[] arr,int n) {
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
    }

    public static void main(String[] args) {
        int n, k = 4;
        System.out.println("nhap kich thuoc mang n : ");
        n = scanner.nextInt();
        System.out.println("nhap day so : ");
        int[] arr = new int[n + 1];
        ScannerArray(arr, n);

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int uc = extend_Euclide(arr[i], arr[j]); // tim gcd
                if (isPrime(uc, k)) {
                    System.out.println("(i,j) : ("+ arr[i] +" , " + arr[j] + ") = " + uc);
                }
            }
        }
    }
}
