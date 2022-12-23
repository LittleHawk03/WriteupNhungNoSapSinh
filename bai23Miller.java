package Security.WriteupNhungNoSapSinh;

import java.util.Scanner;

public class bai23Miller {
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
        int A,B;
        long sum = 0;
        System.out.println("nhap A : ");
        A = scanner.nextInt();
        System.out.println("nhap B : ");
        B = scanner.nextInt();

        boolean[] is_prime = new boolean[B - A + 1];

        for (int i = 0; i < is_prime.length; i++) {
            is_prime[i] = true;
        }

        // sàng số nguyên tố trên đoạn [A,B]
        for (int i = 2; i*i <= B; i++) {
           for (int j = Math.max(i*i, (A + i - 1) / i * i); j <= B; j += i) {
                is_prime[j - A] = false;
           } 
        }
        if (A <= 1) {
            is_prime[1 - A] = false;
        }

        // tính tổng các số 
        for (int i = A; i <= B; i++) {
            if (is_prime[i - A]) {
                sum += i;
            }
        }

        // kiểm tra số nguyên tố sủ dụng thuật toán miller 
        if (isPrime(sum, 5)) {
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
