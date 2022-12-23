package Security.WriteupNhungNoSapSinh;

import java.util.Scanner;

public class bai36 {
    
    static Scanner scanner = new Scanner(System.in);

    public static int last_occurrence(String P,Character x) {
        // L(x) được định nghĩa là:
        // Chỉ số i lớn nhất sao cho P[i] == x, hoặc
        // -1 nếu không tồn tại chỉ số i đó 

        for (int i = P.length() - 1; i > -2; i--) {
            if (i == -1) {
                return -1;
            }
            if (P.charAt(i) == x) {
                return i;
            }
        }
        return -1;
    }

    public static Boolean boyer_Moore(String T,String P) {
        int n = T.length();
        int m = P.length();
        int i = m - 1;
        int j = m - 1;
        int count = 0;
        while (i < n) {
            count++;
            if (T.charAt(i) == P.charAt(j)) {
                if (j == 0) {
                    System.out.println(" count = " + count + " i = " + i);
                    return true;
                }
                i--;
                j--;
            }else{
                int l = last_occurrence(P, T.charAt(i));
                // 𝑖𝑛𝑒𝑤 = 𝑖 + 𝑚 − min(𝑗, 1 + 𝐿(𝑇 𝑖 )
                i = i + m - Math.min(j,1 + l);
                // 𝑗𝑛𝑒𝑤 = 𝑚 − 1
                j = m - 1;
            }
        }
        System.out.println(" count = " + count + " i = " + i);
        return false;
    }

    public static void main(String[] args) {
        System.out.println("nhap day  T : ");
        String T = scanner.nextLine();
        System.out.println("nhap P :");
        String P = scanner.nextLine();

        if (boyer_Moore(T, P)) {
            System.out.println("T include P");
        }else{
            System.out.println("T not include P");
        }
    }
}
