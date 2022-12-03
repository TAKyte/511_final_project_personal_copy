# import PRNG methods
from concurrent.futures import process
from multiprocessing import Process
from linear_congruential import lin_con
from lag_fib import lag_fib
from mdl_sqr import mdl_sqr

# import time module for time comparison
import time


def multi_data(seed, size, prng_r):
    # basic structure is as follows
    # get start time
    # result = method(active seed, size to generate, range of output)
    # save time taken to generate 30m numbers without multi threading
    # append that time to the time taken file
    startTime = time.time()
    # call methods in their own thread
    p1 = Process(target=lin_con, args=(seed, size, prng_r,))
    p1.start()
    p2 = Process(target=lag_fib, args=(seed, size, prng_r,))
    p2.start()
    p3 = Process(target=mdl_sqr, args=(seed, size, prng_r,))
    p3.start()
    #t4 = threading.Thread(target=default_prng, args=(seed, 10000000, prng_r,))

    # join all threads
    p1.join()
    p2.join()
    p3.join()
    #t4.join()

    #save time taken to generate numbers
    time_process = str((time.time() - startTime))
    return time_process

if __name__ == '__main__':
    for x in range (1):
        mem = multi_data(59617645, 10000000, 501)