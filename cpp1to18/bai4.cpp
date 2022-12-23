#include<bits/stdc++.h>
#include<math.h>

using namespace std;

int main(){

    int a,b;
    cin >> a >> b;

    bool is_prime[b-a+1];

    memset(is_prime,true,sizeof(is_prime));

    for (int i = 2; i*i <= b; i++)
    {
        for (int j = max(i*i , (a + i - 1)/i * i); j <= b; j+=i)
        {
            
            is_prime[j - a] = false;
        }
        
    }

    if (a <= 1)
    {
        is_prime[1 - a] = false;
    }
    

    for (int i = a; i <= b; i++)
    {
        if (is_prime[i - a])
        {
            cout << i << " ";
        }
        
    }
    cout << endl;

    return 0;
    
    
}