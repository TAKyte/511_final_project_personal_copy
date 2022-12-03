# import PRNG methods
from linear_congruential import lin_con
from lag_fib import lag_fib
from mdl_sqr import mdl_sqr


# import time module for time comparison
import time


def lin_data(seed, size, prng_r):
    # basic structure is as follows
    # get start time
    # result = method(active seed, size to generate, range of output)
    # save time taken to generate 30m numbers without multi threading
    # append that time to the time taken file

    startTime = time.time()
    # call methods
    lin_con(seed, size, prng_r)
    lag_fib(seed, size, prng_r)
    mdl_sqr(seed, size, prng_r)
    #default_prng(seed, 10000000, prng_r)

    #save time taken to generate numbers
    time_process = str((time.time() - startTime))
    return time_process

if __name__ == '__main__':
    for x in range (1):
        mem = lin_data(59617645, 10000000, 501)