package Security.WriteupNhungNoSapSinh;

import java.util.Scanner;

public class bai7 {
    static Scanner scanner = new Scanner(System.in);

    public static int reverse(int n) {
        int x = 0 ;
        while (n > 0) {
            x = (x * 10) + (n % 10);
            n = n / 10;
        }
        return x;
    }

    public static Boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        // nếu n ,à bằng 2 hay 3 thì nó là số nguyên tố lluoon
        if (n == 2 || n == 3) {
            return true;
        }
        // nếu n chia hết cho 2 thid nó là số chẵn -> loại 
        // nếu các số lẻ mà là bội của 3 như 9 , 15 -> loại 
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }

        // tiến hành xét các số từ 5 với bước nhảy 6 11 - 18 - ..
        for (int i = 5; i <= Math.sqrt(n); i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;

        return true;
    }

    public static void main(String[] args) {
        int N;
        System.out.println("nhap so N : ");
        N = scanner.nextInt();
        for (int i = 2; i < N; i++) {
            if (isPrime(i) && isPrime(reverse(i))) {
                System.out.println("so i : " + i + " rever : " + reverse(i));
            }
        }
    }
}
