package Security.WriteupNhungNoSapSinh;

import java.util.Scanner;

public class bai15 {
    
    /*
     * lại một bài nữa phải dùng sàng số nguyên tố huhu
    */
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n;
        System.out.println(" nhap so n : ");
        n = scanner.nextInt();
        /*
         * vì bài toán chỉ là tìm a để a + 2 và a - 2 là số nguyên tố
         * nên là ta lại tiến hành sàng
         */
        Boolean[] isPrime = new Boolean[n + 1];
        isPrime[1] = false;
        // gan gia tri cua tat ca phan tu cua mang la true
        for (int i = 2; i < n + 1; i++) {
            isPrime[i] = true;
        }

        // tien hanh sang so nguyen to
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // Hai số nguyên tố sinh đôi là hai số nguyên tố hơn kém nhau 2 đơn vị
        for (int i = 2; i <= n; i++) {
            if (isPrime[i] && isPrime[i + 2]) {
                System.out.println("hai so nguyen to sinh doi do la : [ " + i + " , " + (i + 2) + "]");
                
            }
        }


    }
}
