# Thomas Kyte
# linear_congruential formula (a*s+c) mod M

def lin_con(seed, length, prng_r):
    # a is a constant multiplier
    a = 1526
    # s is the seed
    s = seed
    # c value chosen to have no common factors with m to increase length of pattern
    c = 57
    # M is the range of values to generate
    m = prng_r

    # generated is an array holding the list of values to be returned
    lin_generated = []

    # loop that generates a set number of randoms to be returned
    for i in range(length):
        val = (a * s + c) % m
        lin_generated.append(val)
        s = val

