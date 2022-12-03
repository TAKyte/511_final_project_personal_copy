# Thomas Kyte
# middle square formula Seed -> seed^2 -> middle digit
# a length of 12 and 3:9 is needed for a long sequence couldn't find another working sequence.


def mdl_sqr(seed, length, prng_r):
    # s is the seed
    s = seed
    # m is the range of values to generate
    m = prng_r
    # generated is array of randoms to return
    mdl_generated = []

    for i in range(length):
        # take the square value of the seed and make it a string
        strS = str(s * s)
        while len(strS) < 12:
            # is the size is smaller than 12 add 0 to both sides until the length is larger than 12
            strS = '0' + strS + '0'
        # set the new seed as the middle of the square
        s = int(strS[3:9])
        # add the number to the list of randoms generated
        mdl_generated.append(s % m)

