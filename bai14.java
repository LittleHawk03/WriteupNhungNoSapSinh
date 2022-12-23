package Security.WriteupNhungNoSapSinh;

import java.util.Arrays;

public class bai14 {

    // khởi tạo mảng boolean với b -a + 1 phần tử
    static Boolean[] isPrime = new Boolean[999 - 100 + 1];

    // hàm đaoả ngược một số nguyên 
    public static int reverse(int n) {

        int x = 0;
        while (n > 0) {
            x = (x * 10) + (n % 10);
            n = n / 10;
        }
        return x;
    }

    // hamf nay de kiem tra xem số đó có phải là số chính phương ko
    public static boolean CheckLapPhuong(int b) {
        int i = (int) Math.round(Math.pow(b, 1.0 / 3.0));
        return i * i * i == b;
    }

    public static void main(String[] args) {
        int a = 100;
        int b = 999;
        // gán tất cả phần tử bằng true
        Arrays.fill(isPrime, true);
        // bát đầu sàng phân đoạn thế a , b
        for (int i = 2; i * i <= b; i++) {
            for (int j = Math.max(i * i, (a + i - 1) / i * i); j <= b; j += i) {
                isPrime[j - a] = false;
            }
        }
        // trương hợp nếu a <= 1 thì phải gán faile
        if (a <= 1) {
            isPrime[1 - a] = false;
        }

        /*
         * kiem tra tu 100 den 999
        */
        for (int i = 100; i <= 999; i++) {
            if (isPrime[i - 100]) {
                if (CheckLapPhuong(reverse(i))) {
                    System.out.println(" so can tim la i : " 
                    + i + " voi so i khi viet theo thu tu nguoc lai la : " + reverse(i));
                }
            }
        }
    }
}
