#include <bits/stdc++.h>

using namespace std;

long sumOfdivior(int N)
{
    long sum = 1;

    for (int i = 2; i * i <= N; i++)
    {
        if (N % i == 0)
        {

            if ((N / i) == i)
            {
                sum += i;
            }
            else
            {
                sum += (i + (N / i));
            }
        }
    }
    return sum;
}

int main()
{
    int N;
    cin >> N;

    for (int i = 1; i <= N; i++)
    {
        long a = sumOfdivior(i);
        if (i == sumOfdivior(a)  && a != i && a < N && i < a)
        {
            cout << i << " " << a << endl;
            // break; 
        }
       
    }
    

    return 0;
}