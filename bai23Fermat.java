package Security;

import java.util.Scanner;

public class bai23Fermat {
    
    static Scanner scanner = new Scanner(System.in);

    public static long square_loop(long a,long k,long n) {
        long b = 1;
        // a = a % n;
        while (k > 0) {
            if (k % 2 == 1) {
                b = b*a % n;
            }
            k = k / 2;
            a = a*a % n;
        }
        return b;
    }

    public static boolean fermat_algo(long n,int t) {
        if (n < 4) {
            return n == 3 || n == 4;
        }

        if (n % 2 == 0) {
            return false;
        }
        
        for (int i = 1; i <= t; i++) {
            long a = (long) (Math.random() * (n - 2 - 2 + 1) + 2);
            System.out.println("a = " + a);
            long r = square_loop(a, n - 1, n);
            System.out.println("r = " + r);
            if (r != 1) {
                return false;
            }
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

        // kiểm tra số nguyên tố sủ sụng thuật toán fermat 
        if (fermat_algo(sum, 5)) {
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
