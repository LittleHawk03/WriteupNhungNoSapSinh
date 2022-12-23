#include <bits/stdc++.h>

using namespace std;
// Câu 14. Viết chương trình tìm số nguyên tố có ba chữ số, biết rằng nếu viết số đó theo thứ tự
// ngược lại thì ta được một số là lập phương của một số tự nhiên.

int reverse(int n)
{
    // ham dao nguoc so
    int reve = 0;
    while (n > 0)
    {
        reve = (reve * 10) + n % 10;
        n = n / 10;
    }
    return reve;
}

bool chechLapPhuong(int b)
{
    // cho nay khong hieu lam khong co ham roud no auto lam tron ve so nho hon (125 can ba thanh 4)
    int i = round(pow(b, 1.0 / 3.0));
    return i * i * i == b;
}

int main()
{

    bool is_prime[999];

    memset(is_prime, true, 999 - 100 + 1);

    // sang so tren doan 100 999 ow day la tu 100 999
    for (int i = 2; i * i <= 999; i++)
    {
        for (int j = max(i * i, (100 + i - 1) / i * i); j <= 999; j += i)
        {
            is_prime[j - 100] = false;
        }
    }

    for (int i = 100; i <= 999; i++)
    {
        if (is_prime[i - 100])
        {
            if (chechLapPhuong(reverse(i)))
            {
                cout << "so can tim : " << i << " so dao nguoc la  : " << reverse(i);
            }
            
        }
    }
    
    cout << endl;
    // cout << chechLapPhuong(125) << endl;

    return 0;
}