package Security.WriteupNhungNoSapSinh;

import java.util.Scanner;

public class bai9 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n;
        System.out.println("nhap n : ");
        n = scanner.nextInt();

        // khỏi tạo số mảng boolean với 2 giá trị true false
        Boolean[] isPrime = new Boolean[n + 1];
        for (int i = 0; i < n + 1; i++) {
            isPrime[i] = true;
        }
        // sàng số nguyên tố 
        for (int i = 2; i*i <= n ; i++) {
            if (isPrime[i]) {
                for (int j = i*i; j <= n; j+=i) {
                    isPrime[j] = false;
                }
            }
        }
        
        // đếm các số nguyên tố 
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                System.out.println("snt : " + i);
                count++;
            }
        }

        System.out.println("count cac so nguyen to nho hon " + n + " la : " + count);
    }
}
