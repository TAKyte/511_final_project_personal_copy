# Thomas Kyte
# Lagged Fibonacci formula S(n-j)+S(n-k)%M,0<j<k

def lag_fib(seed, length, prng_r):
    # s is the seed
    s = seed
    # j and k are ints in the seed
    j = 2
    k = 4
    # m is range of values to generate
    m = prng_r

    # array of digits in seed
    digits = [int(x) for x in str(s)]
    # array of random numbers to be returned
    lag_generated = []

    # loop to generate a set amount of random numbers
    for i in range(length):
        v1 = digits[j]
        v2 = digits[k]
        val = (v1 + v2) % m
        lag_generated.append(val)
        digits.pop(0)
        digits.append(val)
