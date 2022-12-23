package Security.WriteupNhungNoSapSinh;

import java.util.Scanner;

public class bai12 {

    static Scanner scanner = new Scanner(System.in);

    /**
     * hàm nay để kiểm tra 1 số có là nguyen tố hay 
     * không 
     * 
    */

    public static void main(String[] args) {
        int n;
        System.out.println(" nhap n : ");
        n = scanner.nextInt();

        Boolean[] isPrime = new Boolean[n + 1];
        // gan gia tri cua tat ca phan tu cua mang la true
        for (int i = 0; i < n + 1; i++) {
            isPrime[i] = true;
        }

        // tien hanh sang so nguyen to 
        for (int i = 2; i*i <= n ; i++) {
            if (isPrime[i]) {
                for (int j = i*i; j <= n; j+=i) {
                    isPrime[j] = false;
                }
            }
        }

        // dãy này để lưu các số nguyên tố 
        int[] arr = new int[n + 1];
        int size = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                arr[size] = i;
                size++;
            }
        }

        // tien hanh kiem tra 
        for (int i = 0; i < size - 4; i++) {
            int tong = arr[i] + arr[i + 1] +  arr[i + 2] + arr[i + 3];
            // vì yêu cầu đề bài là tổng phải nhỏ hơn
            // hoặc bằng n nên là ta có thế sử dụng sàng vào đây
            if (tong <= n && isPrime[tong]) {

                /*
                 * thật ra bài toán này chỉ có một kết quẩ hay sao ấy 2 3 5 7 thui 
                */
                System.out.println("[" + arr[i] +" , "+ arr[i + 1] +" , "+  arr[i + 2] +" , "+ arr[i + 3] + " ]");
            }
        }

    }
}
