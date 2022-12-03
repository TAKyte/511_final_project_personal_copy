# import PRNG methods
import threading
from linear_congruential import lin_con
from lag_fib import lag_fib
from mdl_sqr import mdl_sqr
from default_prng import default_prng

# import time module for time comparison
import time


def thread_data(seed, size, prng_r):
    # basic structure is as follows
    # get start time
    # result = method(active seed, size to generate, range of output)
    # save time taken to generate 30m numbers without multi threading
    # append that time to the time taken file
    startTime = time.time()
    # call methods in their own thread
    t1 = threading.Thread(target=lin_con, args=(seed, size, prng_r,))
    t1.start()
    t2 = threading.Thread(target=lag_fib, args=(seed, size, prng_r,))
    t2.start()
    t3 = threading.Thread(target=mdl_sqr, args=(seed, size, prng_r,))
    t3.start()
    #t4 = threading.Thread(target=default_prng, args=(seed, 10000000, prng_r,))

    # join all threads
    t1.join()
    t2.join()
    t3.join()
    #t4.join()

    #save time taken to generate numbers
    time_process = str((time.time() - startTime))
    return time_process

if __name__ == '__main__':
    for x in range (1):
        mem = thread_data(59617645, 10000000, 501)