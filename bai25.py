
def Eratosthenes(b):
    isPrime = [True] * (b + 1)
    for i in range(2, round(b**(1/2)) + 1):
        if isPrime[i]:
            for j in range(i*i, b + 1, i):
                isPrime[j] = False
    c = []
    for i in range(2, b + 1):
        if isPrime[i]:
            c.append(i)
    return c


def f(v, i, S, memo):
    if i >= len(v):
        return 1 if S == 0 else 0
    if (i, S) not in memo:  # <-- Check if value has not been calculated.
        count = f(v, i + 1, S, memo)
        count += f(v, i + 1, S - v[i], memo)
        memo[(i, S)] = count  # <-- Memoize calculated result.
    return memo[(i, S)]     # <-- Return memoized value.


def g(v, S, memo):
    subset = []
    for i, x in enumerate(v):
        # Check if there is still a solution if we include v[i]
        if f(v, i + 1, S - x, memo) > 0:
            subset.append(x)
            S -= x
            
    return subset


def main():
    sum = int(input())
    M = int(input())
    v = Eratosthenes(sum)
    memo = dict()
    if f(v, 0, sum, memo) == 0:
        print("There are no valid subsets.")
    else:
        c = g(v, sum, memo)
        
        if len(c) == M:    
            print(g(v, sum, memo))
        else:
            print("no case valid")
    
if __name__ == '__main__':
    main()
