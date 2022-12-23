#include <bits/stdc++.h>

using namespace std;

int main()
{
    int N;
    long long sum_prime = 1, sum = 1;
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

    for (int i = 2; i * i <= N; i++)
    {
        if (is_prime[i] && N % i == 0)
        {
            sum_prime++;
        }
    }

    int total = 1;

    for (int i = 2; i <= N; i++)
    {
        if (is_prime[i])
        {
            int count = 0;
            if (N % i == 0)
            {
                while (N % i == 0)
                {
                    N = N / i;
                    count++;
                }
                total = total * (count + 1);
            }
        }
    }

    cout << sum_prime << endl;
    cout << total << endl;
    return 0;
}