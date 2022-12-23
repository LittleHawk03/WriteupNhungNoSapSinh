#include <bits/stdc++.h>

using namespace std;

int reverse(int n)
{
    int x = 0;
    while (n > 0)
    {
        x = (x * 10) + n % 10;
        // cout << x << endl;
        n = n / 10;
    }
    return x;
}

int main()
{
    int N;
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
        if (is_prime[i] && is_prime[reverse(i)])
        {
            cout << i << " ";
        }
        // if (is_prime[i])
        // {
        //     cout << i << " ";
        // }
        
        
    }

    return 0;
}