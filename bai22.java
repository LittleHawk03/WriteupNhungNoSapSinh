package Security.WriteupNhungNoSapSinh;

import java.util.Scanner;

public class bai22 {
    
    static Scanner scanner = new Scanner(System.in);
    static boolean[] is_prime;
    static int L;
    static int R;

    /**
     * Bai này tui làm sàng số cho nó đơn giản hóa mọi thứ 
     * sàng phân đoạn chọn ra tất cả các số nguyện tố có trong đọna L R 
     * 
    */
    public static void prime_check(int L,int R) {
        
        
        for (int i = 0; i < is_prime.length; i++) {
            is_prime[i] = true;
        }

        for (int i = 2; i*i <= R; i++) {
            for (int j = Math.max(i*i, (L + i -1) / i * i); j <= R; j+=i) {
                is_prime[j - L] = false;
            }
        }

        if (L <= 1) {
            is_prime[1 - L] = false;
        }

    }

    /**
     * F ( N ) = N nếu N là một số nguyên tố
        F ( N ) = 0 nếu là hợp số
     * 
    */
    public static int F(int x) {
        if (!is_prime[x - L]) {
            return 0;
        }
        return x;
    }

    public static void main(String[] args) {
        long sum = 0;
        System.out.println("L : ");
        L = scanner.nextInt();
        System.out.println("R : ");
        R = scanner.nextInt();
        is_prime = new boolean[R - L + 1];
        prime_check(L, R);

        for (int i = L; i < R; i++) {
            for (int j = i + 1; j <= R; j++) {
                sum = sum + (F(i) * F(j));
            }
        }

        System.out.println("sum = " + sum);
    }
}
