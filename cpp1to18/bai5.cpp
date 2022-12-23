#include<bits/stdc++.h>

using namespace std;

int main(){

    int a,b;
    long long sum;
    cin >> a >> b;

    bool isprime[b - a + 1];

    memset(isprime,true,b - a + 1);

    for (int i = 2; i*i <= b; i++)
    {
        for (int j = max(i*i, (a + i - 1)/ i * i ); j <= b; j+=i)
        {
            isprime[j - a];
        }
        
    }

    if (a <= 1)
    {
        isprime[1 - a] = false;
    }
    
    for (int i = a; i <= b; i++)
    {
        if (isprime[i - a])
        {
            sum += i;
        }
        
    }

    cout << sum << endl;
    
    return 0;
    
}