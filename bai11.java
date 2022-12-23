package Security.WriteupNhungNoSapSinh;


import java.util.Scanner;

public class bai11 {

    static Scanner scanner = new Scanner(System.in);

    /**
     * bài này chỉ cần sàng rồi tạo biến tính tổng thui
    */

    public static void main(String[] args) {
        int n;
        System.out.println("nhap n : ");
        n = scanner.nextInt();

        Boolean[] isPrime = new Boolean[n + 1];
        for (int i = 0; i < n + 1; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i*i <= n ; i++) {
            if (isPrime[i]) {
                for (int j = i*i; j <= n; j+=i) {
                    isPrime[j] = false;
                }
            }
        }
        

        int tong = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                System.out.println("snt : " + i);
                tong = tong + i;
            }
        }

        System.out.println("tong cac so nguyen to nho hon " + n + " la : " + tong);
    }
}
