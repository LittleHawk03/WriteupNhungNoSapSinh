#include <bits/stdc++.h>

using namespace std;

// Câu 11. Viết chương trình tính tổng của các số nguyên tố nhỏ hơn hoặc bằng N với N được nhập
// từ bàn phím.

int main()
{
    int N;
    long long sum = 0;

    cin >> N;

    bool is_prime[N + 1];

    memset(is_prime, true, N + 1);

    for (int i = 2; i * i <= N; i++)
    {
        if (is_prime[i])
        {
            for (int j = i * i; j <= N; j += i)
            {
                is_prime[j] = false;
            }
        }
    }

    for (int i = 2; i <= N; i++)
    {
        if (is_prime[i])
        {
            sum += i;
        }
        
    }
    
    cout << "tong : " << sum << endl;

    return 0;
}
