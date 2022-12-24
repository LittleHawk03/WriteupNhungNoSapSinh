package Security.WriteupNhungNoSapSinh;

import java.util.Scanner;

public class bai3 {

    // . Cho một số nguyên dương N, gọi:
    // - k là số ước nguyên tố của N;
    // - q là tổng của các ước nguyên tố của N;
    // - p là tổng của các ước số của N;
    // - s là số ước của N;
    // Hãy viết chương trình tính giá trị của: N+p+s-q-k với N cho trước nhập từ bàn
    // phím.
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n;
        int k = 0, q = 0;
        int s = 0, p = 0;

        System.out.println(" nhap n : ");
        n = scanner.nextInt();

        Boolean[] isPrime = new Boolean[n + 1];
        // gan gia tri cua tat ca phan tu cua mang la true
        for (int i = 0; i < n + 1; i++) {
            isPrime[i] = true;
        }

        // tien hanh sang so nguyen to de viec timf 
        // uoc nguyên tố được dễ dàng hơn 
        for (int i = 2; i*i <= n ; i++) {
            if (isPrime[i]) {
                for (int j = i*i; j <= n; j+=i) {
                    isPrime[j] = false;
                }
            }
        }

        //tim k và q 
        for (int i = 2; i <= n; i++) {
            if (isPrime[i] && n%i == 0) {
                q += i;
                k++;
            }
        }

        //tim s va p
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                p += i;
                s++;
            }
        }

        System.out.println("số ước nguyên tố của N - k = " + k);
        System.out.println("tổng của các ước nguyên tố của N - q = " + q);
        System.out.println("tổng của các ước số của N - s = " + s);
        System.out.println("số ước của N p = " + p);

        System.out.println("N+p+s-q-k = " + (n + p + s - q - k));

    }
}
