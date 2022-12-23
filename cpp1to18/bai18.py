import math
import re


W = 8
# m = round(math.log2(p))
# t = round(m/W)
t = 4


def int_to_array(n):
    n = bin(n)[2:].zfill(8*t)
    print(type(n))
    b = re.findall('\d{8}', n)
    print(b)
    c = ['0b' + i for i in b]
    return [int(i, 2) for i in c]


def add(a, b, W, t):
    c = []
    e = 0
    # (ε, C[i]) = A[i] + B[i] + ε
    for i in range(t):
        x = a[t - i - 1] + b[t - i - 1] + e
        s = x % pow(2, W)
        # ε ← 0 nếu w thuoc [0, 2W), ngược lại ε ← 1
        if x > pow(2, W):
            e = 1
        else:
            e = 0
        c.append(s)
    c.reverse()
    return e, c


if __name__ == '__main__':
    a = [0, 11, 173, 248]
    b = [0, 1, 226, 64]
    int_to_array(23456789)
    # p = int(input())
    print(add(a, b, W, t))
