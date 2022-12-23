package Security;

import java.util.Scanner;

public class bai17 {
    
    static Scanner scanner = new Scanner(System.in);

    public static Boolean isPrime(long n) {
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

        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0)
                return false;

        return true;
    }

    public static void main(String[] args) {
        int A,B,C,N;
        System.out.println("nhap A : ");
        A = scanner.nextInt();
        System.out.println("nhap B : ");
        B = scanner.nextInt();
        System.out.println("nhap C : ");
        C = scanner.nextInt();
        System.out.println("nhap N : ");
        N = scanner.nextInt();

        for (int i = 1; i < N; i++) {
            long ra = A * i * i + B * i + C;
            if (isPrime(ra)) {
                System.out.println(i + " la gia tri de thoa man bieu thuc 𝐴𝑥^2 + 𝐵𝑥 + 𝐶 là một số nguyên tố  = " + ra);
            }
            if (!isPrime(ra) && i == N - 1) {
                System.out.println("ko co gia tri thoa man");
            }
        }


    }
}
