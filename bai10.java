package Security;

import java.util.Arrays;
import java.util.Scanner;

public class bai10 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n;
        System.out.println("nhap n : ");
        n = scanner.nextInt();
        long count_prime = 1, total = 1;
        Boolean[] isPrime = new Boolean[n + 1];
        Arrays.fill(isPrime, true);

        // sang so nguyen to nay
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // dem so uoc nguyen to cua n
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i] && n % i == 0) {
                count_prime++;
            }
        }

        // dem so uoc cua n
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                int count = 0;
                if (n % i == 0) {
                    while (n % i == 0) {
                        n = n / i;
                        count++;
                    }
                    total = total * (count + 1);
                }
            }
        }
        System.out.println("so uoc nguyen to cua n = : " + count_prime);
        System.out.println("so uoc so nguyen cua n = : " + total);

    }
}
