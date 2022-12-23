#include <bits/stdc++.h>

using namespace std;

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

    int sum = 0;

    for (int i = 2; i <= N; i++)
    {
        if (is_prime[i])
        {
            sum++;
        }
    }

    cout << sum << endl;

    return 0;
}